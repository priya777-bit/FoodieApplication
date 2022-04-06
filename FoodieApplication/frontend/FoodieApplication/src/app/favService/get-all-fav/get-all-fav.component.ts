import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import { InventoryRequestService } from 'src/app/food-inventory/service/inventory-request.service';
import { UserRequestService } from 'src/app/user-request.service';
import { Favourite } from '../domain/favourite';
import { Image } from '../domain/image';
import { Restaurant } from '../domain/restaurant';
import { FavService } from '../service/fav.service';

@Component({
  selector: 'app-get-all-fav',
  templateUrl: './get-all-fav.component.html',
  styleUrls: ['./get-all-fav.component.css']
})
export class GetAllFavComponent implements OnInit {

  //  @Output() restuarent = new EventEmitter<string>();
  
  favs:Favourite[];
  rest: Restaurant[];
  image:Image[];

  constructor(private FavService:FavService,private user:UserRequestService,private request:InventoryRequestService) { }

  ngOnInit(): void {
    this.FavService.getAllFav(this.user.mailId).subscribe(data=>{
      this.favs = data;
      console.log(data);
      this.favs.forEach(r=>{
        this.rest=r.restaurantList;
        //this.restuarent.emit();
        console.log(r.restaurantList);
        this.rest.forEach(data=>{
          console.log(data.restaurantId);
          this.request.getImages(data.restaurantId).subscribe(i=>{
            data.image=i
            console.log(i);
          })
        })
      })
      console.log("favs" + JSON.stringify(this.favs));
    })

  }

  remove(fav:any){
    this.FavService.removeFromFav(fav.favouriteId).subscribe(f=>{
      console.log(f);
    })
  }


}
