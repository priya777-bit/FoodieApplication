import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Dish } from '../domain/dish';
import { Restaurant } from '../domain/restaurant';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html',
  styleUrls: ['./add-dish.component.css']
})
export class AddDishComponent implements OnInit {

  selected='';
 // dishList:Dish[] =[];
  constructor(private fb: FormBuilder,private restApi : RestApiService) { 
    this.selected="";
    this.restaurant=[];
  }

  addDishForm !: FormGroup
  dish = new Dish();
  types = ['Veg','Non-Veg','Dessert'];
  restaurant:Restaurant[]=[];

  changeRest(e:any){
    this.selected = e.target.value;
  }

  ngOnInit(): void {
    this.restApi.findAllRestaurant().subscribe(response=>{
    this.restaurant=response;
      this.restaurant.forEach(element=>{
        // if(element.restaurantId=response[0].restaurantId){
        this.selected=element.restaurantId;
        // this.dishList = element.dishList;
        // console.log("element"+this.dishList)
        this.restApi.restId=this.selected;
        console.log(this.restApi.restId);
        // }
      })
    });

    this.addDishForm = this.fb.group({
      dishName: [null,Validators.required],
      dishType: [null,Validators.required]
    });
  }

  addDish(){
    this.dish.dishId=Math.random().toString(36).substring(2,15);
    this.dish.dishName=this.addDishForm.value.dishName;
    this.dish.dishType=this.addDishForm.value.dishType;
    this.restApi.addDishToRestaurant(this.restApi.restId,this.dish).subscribe(response=>{
      this.restApi.dishId=this.dish.dishId;
      console.log(response);
      // this.dishList=response;
      // console.log(this.dishList)
      // console.log(this.restApi.restId);
      if(this.addDishForm.valid){
      alert("Dish Added Successfully\n Your RestaurantId is\n" + this.dish.dishId);
    }
  },
    error =>{
          console.log(error);
        }
    )}
}
