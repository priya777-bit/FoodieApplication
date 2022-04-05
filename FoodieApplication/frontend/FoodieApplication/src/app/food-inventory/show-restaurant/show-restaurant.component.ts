import { Component, HostListener } from '@angular/core';
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
  
  constructor(private breakpointObserver: BreakpointObserver,private request:InventoryRequestService,private favService:FavService,private userRqst:UserRequestService,private router:Router) {}

  ngOnInit(){
    let tempFavRestId:any[]=[];

    this.favService.getAllFav(this.userRqst.mailId).subscribe(data=>{
      //console.log("favobj", data);
      data.forEach(favourite=>{
        favourite.restaurantList.forEach((restaurant:any)=>{     
          tempFavRestId.push(restaurant.restaurantId);
        })
      })
      //console.log("tempFavRestId",tempFavRestId);
      this.getInventoryRestaurants(tempFavRestId);
    })

    
  }

  getInventoryRestaurants(tempFavRestId:any[]){

    this.request.getdata().subscribe(result=>{
      let tempArray:any[]=[];
	  
      result.forEach((element) => {
        this.request.getImages(element.restaurantId).subscribe(result1=>{
          element.image=result1;
         
          let rest = {
            "restaurantId": element.restaurantId,
            "restaurantName": element.restaurantName,
            "restaurantLocation": element.restaurantLocation,
            "restaurantImage": element.image[0].image,
            "isFavourite": "white",
            "dishList": element.dishList
          };
          
          if(tempFavRestId.includes(element.restaurantId)){
            rest.isFavourite = 'red';
          }
		      tempArray.push(rest);
        })  
      });
      this.restuarents = tempArray; 
      console.log('Restaurants updated ', this.restuarents);
    })
  }

  add(restuarent:any){

    this.restuarents.forEach((ele:any)=>{
      if(ele.restaurantId == restuarent.restaurantId){
        ele.isFavourite = 'red';
      }
    })

    if(this.userRqst.mailId!=null){
      this.favourite.favouriteId = Math.random().toString(36).substring(2,15);
      this.favService.favId=this.favourite.favouriteId
      console.log(this.favourite.favouriteId);
      this.favourite.userMailId = this.userRqst.mailId;
      console.log("mail"+this.favourite.userMailId)
      this.favourite.restaurantList = [restuarent];

      this.favourite.restaurantList.forEach(d=>{
        console.log("restaurantList",d)
          this.dishes=d.dishList;
          console.log("dish",this.dishes);
            this.dishes.forEach(i=>{
              this.request.getImages(i.dishId).subscribe(val=>{
                this.image=val;
                console.log("img",this.image);
              })
            })
          })
        console.log('favou. last ', this.favourite);

      this.favService.addToFav(this.favourite).subscribe(res=>{
        console.log(res);
      },error =>{
          console.log(error);
      })
    }else{
      this.router.navigate(['/login']);
    }
  }
}
