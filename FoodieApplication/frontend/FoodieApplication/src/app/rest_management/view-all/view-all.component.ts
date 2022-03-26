import { Component, OnInit } from '@angular/core';
//import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
import { RestApiService } from '../service/rest-api.service';
import { Restaurant } from 'src/app/rest_management/domain/restaurant';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  selected='';
  status:boolean;
  Rest = new Restaurant();
  restaurant:Restaurant[]=[];

  constructor(private addservice: RequestService,private restApi: RestApiService) { 
    this.selected='';
    this.restaurant=[];
  }

  ngOnInit(): void {
    this.addservice.getResturant().subscribe(response=>{
      console.log(response);
      this.restaurant=response;
    })
  }

  delete(id: any){
    console.log('Selected remove Id ', id);
    this.restApi.removeRestaurant(id).subscribe(res=>{
      console.log(res);
    })
  }

  Add(restaurant: any){
    this.Rest=restaurant;
    this.restApi.registerRestaurant(this.Rest).subscribe(res=>{
      console.log(res);
      alert("Restaurant Added Successfully"); 
      // if(status="approve"){
      
      // }
    },error =>{
      if(this.Rest=restaurant){
        alert("Restaurant Already Exist");
      }
      else{
        console.log(error);
      }
    }
    )}
}
