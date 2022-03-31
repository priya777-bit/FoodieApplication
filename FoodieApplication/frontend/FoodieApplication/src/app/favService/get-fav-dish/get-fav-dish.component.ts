import { Component, OnInit } from '@angular/core';
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
  rest:Restaurant[];
  dishes:Dish[];
  image:Image[];
  dishId:any;

  constructor(private FavService:FavService,private user:UserRequestService,private request:InventoryRequestService) { }

  ngOnInit(): void {
    this.FavService.getAllFav(this.user.mailId).subscribe(data=>{
      this.favs = data;
      console.log("favs" + JSON.stringify(this.favs));
      this.favs.forEach(r=>{
        this.rest=r.restaurantList;
        console.log(r.restaurantList);
          this.rest.forEach(d=>{
            this.dishes=d.dishList;
            console.log(this.dishes);
            this.dishes.forEach(data=>{
              this.dishId=data.dishId;
              console.log(this.dishId);
              this.request.getImages(this.dishId).subscribe(i=>{
                this.image=i;
                console.log(this.image);
              })
            })
          })
        })
      })
    }

  remove(fav:any){
    this.FavService.removeFromFav(fav.favouriteId).subscribe(f=>{
      console.log(f);
    })

  }

}
