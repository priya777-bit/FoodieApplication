import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RestApiService } from 'src/app/rest_management/service/rest-api.service';
import { Restaurant } from '../addRestModel/restaurant';

@Component({
  selector: 'app-send-dish',
  templateUrl: './send-dish.component.html',
  styleUrls: ['./send-dish.component.css']
})
export class SendDishComponent implements OnInit {

  selected='';
  constructor(private api: RestApiService) {
    this.selected="";
    this.restaurant=[];
   }

  addDish!:FormGroup;

  restaurant:Restaurant[]=[];
  
  update(e:any){
    this.selected = e.target.value;
  }

  ngOnInit(): void {
    this.api.findAllRestaurant().subscribe(response=>{
      this.restaurant=response;
    })
    this.addDish = new FormGroup({
      restaurantId:new FormControl('',Validators.required),
      dishName:new FormControl('',Validators.required),
      dishType:new FormControl('',Validators.required)
    })
  }

  get dishName()
  {
    return this.addDish.get('dishName');
  }

  get dishType()
  {
    return this.addDish.get('dishType');
  }

  sendDish(){}

}

