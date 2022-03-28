import { Component, OnInit } from '@angular/core';
import { Dish } from '../../add-Restaurant-Service/addRestModel/dish';
import { RequestService } from '../../add-Restaurant-Service/addRestService/request.service';
import { Restaurant } from '../domain/restaurant';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-view-dish',
  templateUrl: './view-dish.component.html',
  styleUrls: ['./view-dish.component.css']
})
export class ViewDishComponent implements OnInit {

  selected='';
  Dish = new Dish();
  dish:Dish[]=[];
  restaurant : Restaurant [] =[];

  constructor(private addService: RequestService, private restApi: RestApiService) { 
    this.selected='';
    this.restaurant=[];
    this.dish=[];
  }

  ngOnInit(): void {
    this.addService.getResturant().subscribe(res=>{
      console.log(res);
      this.restaurant=res;
      this.restaurant.forEach(res=>{
        this.selected=res.restaurantId;
        this.addService.restaurantId=this.selected;
      })
       this.addService.findAllDishByRestaurantId(this.addService.restaurantId).subscribe(r=>{
          console.log(r);
        })
    });
    // this.addService.findAllDishByRestaurantId().subscribe(res=>{
    //   console.log(res);
    // })
  }

  changeRest(e:any){
    this.selected = e.target.value;
  }

  Add(dish: any){
    this.Dish=dish;
    //this.restApi.addDishToRestaurant()

  }
}
