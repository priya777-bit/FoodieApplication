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
      restaurantName: new FormControl('',Validators.required),
      restaurantLocation : new FormControl('',Validators.required)

    });
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
<<<<<<< HEAD
  
    // this.restaurant.push(restaurant);
=======
>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
    this.rest.restaurantId=Math.random().toString(36).substring(2,15);
    this.rest.restaurantName=this.addRestaurant.value.restaurantName;
    this.rest.restaurantLocation= this.addRestaurant.value.restaurantLocation;
    this.rest.dishList=this.addRestaurant.value.dishList;
    this.request.addRestaurant(this.rest).subscribe(response=>{
      console.log(response);
<<<<<<< HEAD
=======
      this.request.restaurantId=this.rest.restaurantId;
>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
      if(this.addRestaurant.valid)
      {
        alert("Request Send Successfully..");
      }
    })

  }

}
