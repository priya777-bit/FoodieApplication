import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Dish } from 'src/app/add-Restaurant-Service/addRestModel/dish';
import { Image } from 'src/app/add-Restaurant-Service/addRestModel/image';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { Order } from 'src/app/addToCart/add-to-cart/domain/order';
import { OrderRequestService } from 'src/app/addToCart/add-to-cart/service/order-request.service';
import { InventoryRequestService } from 'src/app/food-inventory/service/inventory-request.service';
import { RestApiService } from 'src/app/rest_management/service/rest-api.service';
import { UserRequestService } from 'src/app/user-request.service';
import { FindService } from '../service/find.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  search:FormGroup;

  rest = new Restaurant();
  rest1 = new Restaurant();


  dish = new Dish();

  dish2 = new Dish();

  filename:string;

  restaurant:Restaurant[]=[];

  dishes:Dish[]=[];

  image:Image[]=[];

  img = new Image();

  data:Dish[];

  flag=0;

  alert=0;

  order=new Order();

  ors:Order[];

  orderRestaurant :any;

  flagOrder=0;

  alertOrder=0;

  constructor(private fs:FindService,private toaster:ToastrService,private orderService:OrderRequestService,private user:UserRequestService,private request:InventoryRequestService) { }

  ngOnInit(): void {
    this.search = new FormGroup({  
      find:new FormControl()
    }); 
  }

  get find()
  {
    return this.search.get('find');
  }

getRestaurant()
{
  this.rest.restaurantName=this.search.value.find;
  this.fs.getByRestaurantName(this.rest.restaurantName).subscribe(obj=>{
    this.restaurant=obj;
    console.log(this.restaurant);
    this.restaurant.forEach(p=>{
      this.rest.restaurantId=p.restaurantId;
      this.fs.getImage(this.rest.restaurantId).subscribe(restimg=>{
        this.image=restimg;
        p.image=restimg;
        this.rest=p;
      })
      this.dishes=this.rest.dishList;
      this.rest=p;
      this.dishes.forEach(d=>{
        this.dish.dishId=d.dishId;
        console.log(this.dish.dishId)
        this.fs.getImage(this.dish.dishId).subscribe(obj=>{
          this.image=obj;
          d.image=obj;
          this.data=this.dishes;
          console.log(this.dishes);
          console.log(this.restaurant);
      })
    })
  })
    
  })
}

getDish()
{
  this.dish.dishName=this.search.value.find;
  this.fs.getByDishName(this.dish.dishName).subscribe(obj=>{
    console.log(obj);
    this.restaurant=obj
    console.log(this.restaurant);
    this.restaurant.forEach(p=>{
      this.rest1=p;
      this.dishes=this.rest1.dishList;
      console.log("dishes"+this.dishes);
      console.log("rest dishlist"+this.rest1.dishList);
      this.dishes.forEach(d=>{
        console.log(d);
        if(d.dishName==this.search.value.find)
        {
        this.dish.dishId=d.dishId;
        console.log(this.dish.dishId);
        this.fs.getImage(this.dish.dishId).subscribe(obj=>{
          this.image=obj;
          d.image=obj;
          this.data=this.dishes;
          console.log("data "+this.data);
          console.log(this.dishes);
          console.log(this.restaurant);
        })
      }       
      })
    })
   
  })
  
  
}


getImage(id:string)
{
  // this.img.fileName=this.dish.dishId;
  this.fs.getImage(id).subscribe(obj=>{
    this.image=obj;
    console.log(obj);
    console.log("image"+this.image)
  })
}

  searching(event:any)
  {
    
    this.getDish();
    this.getRestaurant();
  }

  addTocart(dish:any){

    this.orderService.getAllOrder(this.user.mailId).subscribe(d=>{
      this.ors=d;
      if(this.ors.length!=0)
      {
      this.ors.forEach(r=>{
        this.order.orderId=r.orderId;
        console.log(r);
        r.restaurantList.forEach(restau=>{
          restau.dishList.forEach(d=>{
            if(d.dishId==dish.dishId)
            {
              this.alert=1;
              this.flag=1;
              this.toaster.error("Already added to Cart");
            }
          })

            if(this.alert==0)
            {
            if(restau.restaurantId==this.user.restID)
          {
            this.orderService.addOrderDish(r.orderId,restau.restaurantId,dish).subscribe(d=>{
              console.log("added Dish",d);
              this.toaster.success("Added to Cart");
            })
            this.flag=1; 
          }
        }
          })      
      if(this.flag==0)
      {
        this.toaster.error("Please clear the cart and try again");
      }
    })
    }
    else
    {
      console.log(dish);
      this.order.orderId = Math.random().toString(36).substring(2,15);
      this.order.userMailId = this.user.mailId;
      this.request.getRestData(this.user.restID).subscribe((data: any)=>{
        this.orderRestaurant=data;
        this.order.restaurantList=[this.orderRestaurant];
        this.order.restaurantList.forEach(d=>{
          //console.log(d.dishList);
          
          d.dishList.forEach(dishes=>{
            if(dishes.dishId!=dish.dishId)
            {
              console.log(d.dishList.indexOf(dishes))
              d.dishList.splice(d.dishList.indexOf(dishes));
            }
          })
        })
        console.log(this.order);
        this.orderService.addToOrder(this.order).subscribe(res=>{
          console.log(res);
          this.toaster.success("Added to Cart");
        },error =>{
            console.log(error);
        })
      })
    }
    })
  } 


}
