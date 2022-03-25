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
  constructor(private fb: FormBuilder,private restApi : RestApiService) { 
    this.selected="";
    this.restaurant=[];
  }

  addDishForm !: FormGroup
  dish = new Dish();
  types = ['Veg','Non-Veg'];
  restaurant:Restaurant[]=[];
  id:string;
 


  changeRest(e:any){
    this.selected = e.target.value;
  }

  ngOnInit(): void {
    this.restApi.findAllRestaurant().subscribe(response=>{
      this.restaurant=response;
      //this.restid=response.restaurantId;
      //console.log("rest"+this.restid);
      console.log(response);
    })
    this.addDishForm = this.fb.group({
      dishName: [null,Validators.required],
      dishType: [null,Validators.required]
    });
  }

  addDish(){
    console.log("hieee")
    // const id = this.restaurant.indexOf(restaurant);
    // this.dish.restaurantId=this.restaurant[id].restaurantId;
    // console.log(id);
    // console.log(this.dish.restaurantId);

    this.dish.dishName=this.addDishForm.value.dishName;
    this.dish.dishType=this.addDishForm.value.dishType;
    this.restApi.addDishToRestaurant(this.id,this.dish).subscribe(response=>{
      console.log(response);
      console.log(this.id);
      if(this.addDishForm.valid){
      alert("Dish Added Successfully");
    }
  },
    error =>{
          console.log(error);
        }
    )}
}
