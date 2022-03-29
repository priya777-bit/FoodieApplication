import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RestApiService } from 'src/app/rest_management/service/rest-api.service';
import { Restaurant } from '../addRestModel/restaurant';
import { RequestService } from '../addRestService/request.service';

@Component({
  selector: 'app-send-restaurant',
  templateUrl: './send-restaurant.component.html',
  styleUrls: ['./send-restaurant.component.css']
})
export class SendRestaurantComponent implements OnInit {

  constructor(private request:RequestService,private api: RestApiService) {}

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
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
    this.rest.restaurantId=Math.random().toString(36).substring(2,15);
    this.api.restId=this.rest.restaurantId;
    this.rest.restaurantName=this.addRestaurant.value.restaurantName;
    this.rest.restaurantLocation= this.addRestaurant.value.restaurantLocation;
    this.rest.dishList=this.addRestaurant.value.dishList;
    this.request.addRestaurant(this.rest).subscribe((response: any)=>{
      console.log(response);
<<<<<<< HEAD


      this.request.restaurantId=this.rest.restaurantId;

=======
      this.request.restaurantId=this.rest.restaurantId;
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
      if(this.addRestaurant.valid)
      {
        alert("Request Send Successfully..");
      }
    })

  }

}
