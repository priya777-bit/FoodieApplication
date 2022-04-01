import { Component, OnInit } from '@angular/core';
import { UserRequestService } from 'src/app/user-request.service';
import { Favourite } from '../domain/favourite';
import { Restaurant } from '../domain/restaurant';
import { FavService } from '../service/fav.service';

@Component({
  selector: 'app-get-all-fav',
  templateUrl: './get-all-fav.component.html',
  styleUrls: ['./get-all-fav.component.css']
})
export class GetAllFavComponent implements OnInit {
  
  favs:Favourite[];
  rest:Restaurant[];

  constructor(private FavService:FavService,private user:UserRequestService) { }

  ngOnInit(): void {
    this.FavService.getAllFav(this.user.mailId).subscribe(data=>{
      this.favs = data;
      console.log(data);
      this.favs.forEach(r=>{
        this.rest=r.restaurantList;
        console.log(r.restaurantList);
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
