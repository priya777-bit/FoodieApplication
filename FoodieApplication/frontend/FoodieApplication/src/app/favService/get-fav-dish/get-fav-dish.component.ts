import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  //favId:string;

  constructor(private FavService:FavService,private user:UserRequestService,private request:InventoryRequestService,private activateRoute: ActivatedRoute) { }

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

}
