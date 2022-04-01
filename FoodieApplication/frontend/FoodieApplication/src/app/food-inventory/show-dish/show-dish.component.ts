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
  restId:string;
  // myArray: any; 
  //  map = new Map;
  //  list=new List;
   data2:Image[];
  //  dataDisp:Dish[];
  //  imagDisp:Image[];



  ngOnInit(): void{
    this.activatedRoute.paramMap.subscribe(data=>{
      let id=data.get('id') ??0;
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
    
  }
  constructor(private activatedRoute:ActivatedRoute,private request:InventoryRequestService,private favService:FavService,private user:UserRequestService) 
  {}

  add(dish:any){
    //this.data=dish;
    this.favService.getAllFav(this.user.mailId).subscribe(d=>{
      this.favs=d;
      this.favs.forEach(r=>{
        console.log(r);
        r.restaurantList.forEach(restau=>{
          //this.restId=restau.restaurantId;
        // this.fId=r.favouriteId;
        // console.log("rid",r.favouriteId)
        // console.log(this.fId);
        this.favService.addDish(r.favouriteId,restau.restaurantId,dish).subscribe(d=>{
      console.log("added Dish",d);
    })
      })
    })
      console.log("favsdish" + JSON.stringify(this.favs));
      console.log(d);
    })

  }
}
