import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from '../addRestModel/restaurant';
import { RequestService } from '../addRestService/request.service';

@Component({
  selector: 'app-send-restaurant',
  templateUrl: './send-restaurant.component.html',
  styleUrls: ['./send-restaurant.component.css']
})
export class SendRestaurantComponent implements OnInit {

  constructor(private request:RequestService) {}

  rest = new Restaurant();
  addRestaurant!:FormGroup;

  ngOnInit(): void {
    this.addRestaurant = new FormGroup({
      restaurantId: new FormControl('',Validators.required),
      restaurantName: new FormControl('',Validators.required),
      restaurantLocation : new FormControl('',Validators.required)

    });
  }

  get restaurantId()
  {
    return this.addRestaurant.get('restaurantId');
  }

  get restaurantName()
  {
    return this.addRestaurant.get('restaurantName');
  }

  get restaurantLocation()
  {
    return this.addRestaurant.get('restaurantLocation');
  }

  sendRestaurant()
  {
  
    // this.restaurant.push(restaurant);
    this.rest.restaurantName=this.addRestaurant.value.restaurantName;
    this.rest.restaurantLocation= this.addRestaurant.value.restaurantLocation;
    this.request.addRestaurant(this.rest).subscribe(response=>{
      console.log(response);
    })

  }

}
