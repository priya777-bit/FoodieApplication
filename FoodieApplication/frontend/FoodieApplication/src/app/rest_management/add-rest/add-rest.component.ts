import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurant } from 'src/app/rest_management/domain/restaurant';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-add-rest',
  templateUrl: './add-rest.component.html',
  styleUrls: ['./add-rest.component.css']
})
export class AddRestComponent implements OnInit {

  constructor(private fb: FormBuilder,private restApi: RestApiService,private router: Router, private route: ActivatedRoute) { 
    //this.restApi.restId = this.route.snapshot.params['this.Rest.restaurantId']
  }

  addRestForm !: FormGroup;
  Rest = new Restaurant();
  
  //Locations = ['Sigra','Lanka','Nasik','Madras','Mehmurganj','Delhi','MotiMahal','DurgaKund','Sidgiribaag','Lahatara','Babatpur','Pahariya']

  ngOnInit(): void {
    this.addRestForm = this.fb.group({
      restaurantName: [null,Validators.required],
      restaurantLocation: [null,Validators.required]
    });
  }

  addRest(){
    this.Rest.restaurantId=Math.random().toString(36).substring(2,15);
    this.Rest.restaurantName=this.addRestForm.value.restaurantName;
    this.Rest.restaurantLocation=this.addRestForm.value.restaurantLocation;
    this.Rest.dishList=this.addRestForm.value.dishList;
    this.restApi.registerRestaurant(this.Rest)
    .subscribe(
        response=>{
          console.log(response)
          // this.restApi.restId = this.Rest.restaurantId;
          // console.log(this.restApi.restId);
          // console.log(this.Rest.restaurantId)
          if(this.addRestForm.valid){
          alert("Restaurant Added Successfully\n Your RestaurantId is\n" + this.Rest.restaurantId);
        }
      },
      error =>{
          console.log(error);
        }
    )
  }


}
