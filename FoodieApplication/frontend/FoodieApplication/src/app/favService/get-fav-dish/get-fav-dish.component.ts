import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Order } from 'src/app/addToCart/add-to-cart/domain/order';
import { OrderRequestService } from 'src/app/addToCart/add-to-cart/service/order-request.service';
import { InventoryRequestService } from 'src/app/food-inventory/service/inventory-request.service';
import { UserRequestService } from 'src/app/user-request.service';
import { Dish } from '../domain/dish';
import { Favourite } from '../domain/favourite';
import { Image } from '../domain/image';
import { Restaurant } from '../domain/restaurant';
import { FavService } from '../service/fav.service';

@Component({
  selector: 'app-get-fav-dish',
  templateUrl: './get-fav-dish.component.html',
  styleUrls: ['./get-fav-dish.component.css']
})
export class GetFavDishComponent implements OnInit {

  favs:Favourite[];
  favsAfterRemove:Favourite;
  rest:Restaurant[];
  dishes:Dish[];
  image:Image[];
  rId:any;
  order=new Order();
  ors:Order[];
  orderRestaurant :any;
  flag=0;
  alert=0;
  //favId:string;

  constructor(private FavService:FavService,private user:UserRequestService,private request:InventoryRequestService,private activateRoute: ActivatedRoute,private toastr: ToastrService,private orderService:OrderRequestService) { }

  ngOnInit(): void {
    
    this.activateRoute.paramMap.subscribe(data=>{
    let id=data.get('id') ??0;
    this.rId = id;

    console.log('rid '+ id);

    this.FavService.getAllFav(this.user.mailId).subscribe(data=>{
      this.favs = data;
      console.log("favs" + JSON.stringify(this.favs));
      this.favs.forEach(r=>{
        this.rest=r.restaurantList;
          this.rest.forEach(d=>{
            if(id == d.restaurantId){
                this.dishes=d.dishList;
                console.log(this.dishes);
                this.dishes.forEach(dish=>{
                  this.request.getImages(dish.dishId).subscribe(i=>{
                    this.image=i;
                    dish.image=i;
                    console.log('Img'+this.image);
                  })
                })
              }
          })
        })
      })
    })
  }

  remove(dish:any){
    console.log(dish);
    this.favs.forEach(f=>{
      this.FavService.removeDish(f.favouriteId,this.rId,dish.dishId).subscribe(d=>{
      console.log(d);
      this.favsAfterRemove=d;
      this.favsAfterRemove.restaurantList.forEach(dish=>{
        if(dish.dishList.length==0)
        {
          this.FavService.removeFromFav(f.favouriteId,dish.restaurantId).subscribe(f=>{
            console.log(f);
          })
        }
      })
    })
    })
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
              this.toastr.error("Already added to Cart");
            }
          })

            if(this.alert==0)
            {
            if(restau.restaurantId==this.user.restID)
          {
            this.orderService.addOrderDish(r.orderId,restau.restaurantId,dish).subscribe(d=>{
              console.log("added Dish",d);
              this.toastr.success("Added to Cart");
            })
            this.flag=1; 
          }
        }
          })      
      if(this.flag==0)
      {
        this.toastr.error("Please clear the cart and try again");
      }
    })
    }
    else
    {
      console.log(dish);
      this.order.orderId = Math.random().toString(36).substring(2,15);
      this.order.userMailId = this.user.mailId;
      this.request.getRestData(this.user.restID).subscribe(data=>{
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
          this.toastr.success("Added to Cart");
        },error =>{
            console.log(error);
        })
      })
    }
    })
  } 

}
