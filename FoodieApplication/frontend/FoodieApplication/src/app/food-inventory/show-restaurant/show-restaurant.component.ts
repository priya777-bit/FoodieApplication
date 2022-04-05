import { Component } from '@angular/core';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Restaurant } from '../modal/restaurant';
import { FavService } from 'src/app/favService/service/fav.service';
import { Favourite } from 'src/app/favService/domain/favourite';
import { UserRequestService } from 'src/app/user-request.service';
import { Dish } from '../modal/dish';
import { Image } from '../modal/image';
import { Router } from '@angular/router';


@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})
export class ShowRestaurantComponent {

  
  restuarents: any;
  data:Restaurant[];
  // favId:any;
  // mailId:any;
  dishes:Dish[];
  image:Image[];
  favourite = new Favourite();
  color="white";
  
  constructor(private breakpointObserver: BreakpointObserver,private request:InventoryRequestService,private favService:FavService,private userRqst:UserRequestService,private router:Router) {}

  ngOnInit(){
    this.request.getdata().subscribe(result=>{
      this.restuarents=result;
      result.forEach((element: Restaurant) => {
        console.log(element.restaurantId);
        this.request.getImages(element.restaurantId).subscribe(result1=>{
          // this.data2=result;
          element.image=result1;
          console.log(element);
          console.log(result);
          this.data=result;
        })  
      }); 
    })
  }

  add(restuarent:any){
    //restuarent.isSelected = true;
<<<<<<< HEAD
    this.color="red";
    
=======

    if(this.userRqst.mailId!=null)
    {
>>>>>>> b2f9bf21f0e46779dd8add24387ac0c079bdaaed
    this.favourite.favouriteId = Math.random().toString(36).substring(2,15);
    this.favService.favId=this.favourite.favouriteId
    console.log(this.favourite.favouriteId);
    this.favourite.userMailId = this.userRqst.mailId;
    console.log("mail"+this.favourite.userMailId)
    this.favourite.restaurantList = [restuarent];
    this.favourite.restaurantList.forEach(d=>{
        this.dishes=d.dishList;
        console.log("dish",this.dishes);
          this.dishes.forEach(i=>{
            this.request.getImages(i.dishId).subscribe(val=>{
              this.image=val;
              console.log("img",this.image);
            })
          })
        })
    this.favService.addToFav(this.favourite).subscribe(res=>{
      console.log(res);
    },error =>{
      // if(this.favourite.restaurantList=[restuarent]){
      //   alert("Already Added");
      // }
      // else{
        console.log(error);
      //}
    })

  }
  else
{
  this.router.navigate(['/login']);
}
}


}
