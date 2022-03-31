import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Restaurant } from '../modal/restaurant';
import { FavService } from 'src/app/favService/service/fav.service';


@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})
export class ShowRestaurantComponent {

  
  restuarents: any;
  data:Restaurant[];
  
  constructor(private breakpointObserver: BreakpointObserver,private request:InventoryRequestService,private fav:FavService) {}

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
    console.log("res",restuarent);
    this.fav.addToFav(restuarent).subscribe(res=>{
      console.log(res);
    })

  }

}
