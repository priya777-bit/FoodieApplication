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

  restData! : Restaurant[];

  constructor(private fb: FormBuilder,private restApi : RestApiService) { 
    this.restData=[];
  }

  addDishForm !: FormGroup
  dish = new Dish();
  types = ['Veg','Non-Veg']
  
  restaurant: any = ['Killer Pizza from Mars','The French Laundry','Starbelly','Egg Slut', 'Goosefoot']
  //restaurant = [this.Rest.restaurantName]


  changeRest(e:any){
    this.restaurant = e.target.value;
  }

  ngOnInit(): void {
    this.addDishForm = this.fb.group({
      dishName: [null,Validators.required],
      dishType: [null,Validators.required]
    });
  }

  addDish(){
    
    if(this.addDishForm.valid){
      alert("Dish Added Successfully");
    }
  }
}
