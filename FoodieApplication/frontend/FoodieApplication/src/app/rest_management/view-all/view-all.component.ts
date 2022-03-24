import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
import { RestApiService } from '../service/rest-api.service';
//import { Restaurant } from 'src/app/rest_management/domain/restaurant';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  Rest = new Restaurant();
  restaurant:Restaurant[]=[];

  constructor(private addservice: RequestService,private restApi: RestApiService) { 
    this.restaurant=[];
  }

  ngOnInit(): void {
    this.addservice.getResturant().subscribe(response=>{
      this.restaurant=response;
      console.log(response);
    })
  }

  delete(){
    //this.restaurant=e.target.value;
    this.addservice.deleteRestaurant().subscribe(response=>{
      console.log(response);
    })

  }

  Add(e:any){
    // this.restaurant=e.target.value;
    // //this.Rest=this.restaurant;
    // // this.Rest.restaurantId=Math.random().toString(36).substring(2,15);
    // // this.Rest.restaurantName=
    // // this.Rest.restaurantLocation=this.restaurant.value.restaurantLocation;
    // this.restApi.registerRestaurant(this.restaurant).subscribe(response=>{
    //   console.log(response);
    // })
  }

}
