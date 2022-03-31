import { Component } from '@angular/core';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Restaurant } from '../modal/restaurant';
import { FavService } from 'src/app/favService/service/fav.service';
import { Favourite } from 'src/app/favService/domain/favourite';
import { UserRequestService } from 'src/app/user-request.service';
import { Dish } from '../modal/dish';


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
  favourite = new Favourite();
  
  constructor(private breakpointObserver: BreakpointObserver,private request:InventoryRequestService,private favService:FavService,private userRqst:UserRequestService) {}

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
    this.favourite.favouriteId = Math.random().toString(36).substring(2,15);
    this.favService.favId=this.favourite.favouriteId
    console.log(this.favourite.favouriteId);
    this.favourite.userMailId = this.userRqst.mailId;
    console.log("mail"+this.favourite.userMailId)
    this.favourite.restaurantList = [restuarent];
    console.log("res",restuarent);
    console.log("fav",this.favourite)
    // restuarent.dishList.forEach((element:Dish)=> {
    //   this.request.getImages(element.dishId).subscribe(i=>{
    //     element.image=i;
    //   })
    // });
    this.favService.addToFav(this.favourite).subscribe(res=>{
      console.log(res);
    })

  }

}
