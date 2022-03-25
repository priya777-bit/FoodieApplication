import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RestApiService } from 'src/app/rest_management/service/rest-api.service';
import { Dish } from '../addRestModel/dish';
import { Restaurant } from '../addRestModel/restaurant';
import { RequestService } from '../addRestService/request.service';

@Component({
  selector: 'app-send-dish',
  templateUrl: './send-dish.component.html',
  styleUrls: ['./send-dish.component.css']
})
export class SendDishComponent implements OnInit{

  selected='';
  sel='';

  constructor(private api: RestApiService,private send:RequestService) {
    this.selected="";
    this.restaurant=[];
    this.rest=[];
    this.sel="";
   }


   dish = new Dish();

  addDish!:FormGroup;

  restaurant:Restaurant[]=[];

  rest:Restaurant[]=[];
  
  update(e:any){
    this.selected = e.target.value;
  }

  ngOnInit(): void {
    this.send.getResturant().subscribe(r=>{
      console.log(r);
      this.rest=r;
      console.log(this.rest);
      this.rest.forEach(r=>{
        this.sel=r.restaurantId;
        this.send.restaurantId=this.sel;
        console.log(r.restaurantId);
      })
    //   this.restaurant=r;
    //   this.restaurant.forEach(r=>{
    //     this.selected=r.restuarantId;
    //     this.send.newRestId=this.selected;
    //     console.log(this.send.newRestId);
    //   })
    })

    this.api.findAllRestaurant().subscribe(response=>{
      this.restaurant=response;
      console.log(response);
      // this.send.restaurantId=response[0].restaurantId;
      console.log(response[0].restaurantId);
      this.restaurant.forEach(response=>{
        this.selected=response.restaurantId;
        this.send.restaurantId=this.selected;
        console.log(response);
        console.log(response.restaurantId);
        console.log(this.send.restaurantId);
    })
      })
      this.addDish = new FormGroup({
        dishName:new FormControl('',Validators.required),
        dishType:new FormControl('',Validators.required),
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

  sendDish()
  {
    // this.dish.restaurantId=this.send.restaurantId;
    this.dish.dishName=this.addDish.value.dishName;
    this.dish.dishType=this.addDish.value.dishType;
    this.send.addDish(this.send.restaurantId,this.dish).subscribe(observer=>{
      console.log(observer);
      if(this.addDish.valid)
      {
        alert("Send Dish Request Successful..");
      }
    })
  }

}

