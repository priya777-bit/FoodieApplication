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
  dishStatus='reject';
  imageId:string;

  constructor(private addService: RequestService, private restApi: RestApiService) { 
    this.selected = 'Please Select a Restaurant';
    this.restaurant=[];
    this.dish=[];
    this.imageId = this.Dish.dishId; 
  }

  ngOnInit(): void {
    this.addService.findAllRestaurantByStatus("approve").subscribe(res=>{
      console.log(res);
      this.restaurant=res;
      console.log('Rst', this.restaurant);
    });
  }

  

  changeRest(e: any){
    console.log('Selected Id ', e.value);
    this.selected = e.value;
    console.log(this.selected);
    this.addService.restaurantId = this.selected;
  
      console.log("iddddd",this.addService.restaurantId);
       this.addService.findAllDishByRestaurantId(this.addService.restaurantId).subscribe(r=>{
         this.dish = r.filter(f=>f.dishStatus!="approve");
          console.log("dish", this.dish);
        })
  }
  

  Add(dish: Dish){
    this.Dish=dish;
    this.restApi.addDishToRestaurant(this.addService.restaurantId,dish).subscribe(r=>{
      console.log(r);
      this.dish=r;
      alert("Dish Request Accepted....")
    })
    this.addService.updateDishWhenApprove(this.addService.restaurantId,this.Dish,"approve")
    .subscribe(d=>{
      console.log("updated Dish",d);
    })
  }
}
