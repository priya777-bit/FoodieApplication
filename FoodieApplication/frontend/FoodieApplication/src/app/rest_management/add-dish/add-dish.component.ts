import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
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
  constructor(private fb: FormBuilder,private restApi : RestApiService,private request : RequestService) { 
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
<<<<<<< HEAD
      this.restaurant=response;
      //this.restid=response.restaurantId;
      //console.log("rest"+this.restid);
      console.log(response);
    })
=======
    this.restaurant=response;
      this.restaurant.forEach(element=>{
        // if(element.restaurantId=response[0].restaurantId){
        this.selected=element.restaurantId;
        // }
      })
    });

>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
    this.addDishForm = this.fb.group({
      dishName: [null,Validators.required],
      dishType: [null,Validators.required]
    });
  }

  addDish(){
    this.dish.dishId=this.request.dishId;
    this.dish.dishName=this.addDishForm.value.dishName;
    this.dish.dishType=this.addDishForm.value.dishType;
    this.restApi.addDishToRestaurant(this.request.restaurantId,this.dish).subscribe(response=>{
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
