import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Map } from '../modal/map';
import { List } from '../modal/list';
import { Dish } from '../modal/dish';
import { Observable } from 'rxjs';
import { Image } from '../modal/image';
import { FavService } from 'src/app/favService/service/fav.service';
import { Favourite } from 'src/app/favService/domain/favourite';
import { UserRequestService } from 'src/app/user-request.service';
import { Restaurant } from '../modal/restaurant';

@Component({
  selector: 'app-show-dish',
  templateUrl: './show-dish.component.html',
  styleUrls: ['./show-dish.component.css']
})
export class ShowDishComponent {
 
  // data2:Array<String>=[];

  
  // data:Dish[]=[];
  data:Dish[];
  favs:Favourite[];
  fId:string;
  rest:Restaurant[];
  // myArray: any; 
  //  map = new Map;
  //  list=new List;
   data2:Image[];
  //  dataDisp:Dish[];
  //  imagDisp:Image[];
  isadmin:boolean=true;
  favourite = new Favourite();
  restaurant :any;
  flag=0;
  alert=0;


  ngOnInit(): void{
    this.activatedRoute.paramMap.subscribe(data=>{
      let id=data.get('id') ??0;
      this.user.restID=id;
      this.request.getDishes(id).subscribe(result1=>
        {
        result1.forEach((element: Dish) => {
          this.request.getImages(element.dishId).subscribe(result=>{
            this.data2=result;
            element.image=result;
            console.log(element);
            console.log(result1);
            this.data=result1;
          })  
        });  
      });
    })
    if(this.user.loginType!="admin")
    {
      this.isadmin=true;
    }
    else
    {
      this.isadmin=false;
    }
  }
  constructor(private activatedRoute:ActivatedRoute,private request:InventoryRequestService,private favService:FavService,private user:UserRequestService) 
  {}

  add(dish:any){
    this.favService.getAllFav(this.user.mailId).subscribe(d=>{
      this.favs=d;
      if(this.favs.length!=0)
      {
      this.favs.forEach(r=>{
        this.favourite.favouriteId=r.favouriteId;
        console.log(r);
        r.restaurantList.forEach(restau=>{
          restau.dishList.forEach(d=>{
            if(d.dishId==dish.dishId)
            {
              this.alert=1;
              this.flag=1;
            }
          })

            if(this.alert==0)
            {
            if(restau.restaurantId==this.user.restID)
          {
            this.favService.addDish(r.favouriteId,restau.restaurantId,dish).subscribe(d=>{
              console.log("added Dish",d);
            })
            this.flag=1;
            console.log(this.flag);
          }
          console.log(this.flag);
        }
          })      
      
      console.log(this.flag);
      if(this.flag==0)
      {
        this.request.getRestData(this.user.restID).subscribe(data=>{
          this.restaurant=data;
          console.log(this.restaurant);
          this.restaurant.dishList.forEach((_dishes: any)=>{
            if(_dishes.dishId!=dish.dishId)
            {
              console.log(this.restaurant.dishList.indexOf(_dishes))
              this.restaurant.dishList.splice(this.restaurant.dishList.indexOf(_dishes));
            }
            console.log(this.restaurant);
          })
          console.log(this.restaurant);
          this.favService.update(this.favourite.favouriteId,this.restaurant).subscribe(d=>{

          })
        })
        
      }
    })
      console.log("favsdish" + JSON.stringify(this.favs));
      console.log(d);
    }
    else{
      this.favourite.favouriteId = Math.random().toString(36).substring(2,15);
    this.favService.favId=this.favourite.favouriteId
    console.log(this.favourite.favouriteId);
    this.favourite.userMailId = this.user.mailId;
    console.log("mail"+this.favourite.userMailId)
    this.request.getRestData(this.user.restID).subscribe(data=>{
      this.restaurant=data;
      this.favourite.restaurantList=[this.restaurant];
      console.log(this.favourite);
      this.favourite.restaurantList.forEach(d=>{
        console.log(d.dishList);
        
        d.dishList.forEach(dishes=>{
          if(dishes.dishId!=dish.dishId)
          {
            console.log(d.dishList.indexOf(dishes))
            d.dishList.splice(d.dishList.indexOf(dishes));
          }
        })
      })
      console.log(this.favourite);
      this.favService.addToFav(this.favourite).subscribe(res=>{
        console.log(res);
      },error =>{
          console.log(error);
      })
    })
    }
    })
  }
}
