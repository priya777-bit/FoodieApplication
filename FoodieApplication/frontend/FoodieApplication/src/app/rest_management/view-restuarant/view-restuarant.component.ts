import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../../add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from '../../add-Restaurant-Service/addRestService/request.service';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-view-restuarant',
  templateUrl: './view-restuarant.component.html',
  styleUrls: ['./view-restuarant.component.css']
})
export class ViewRestuarantComponent implements OnInit {

  selected='';
  Rest = new Restaurant();
  restaurant:Restaurant[]=[];
  isSubmitBtnDisabled: boolean= false;

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
    //console.log('Selected remove Id ', id);
    this.addservice.deleteRestaurant(id).subscribe(res=>{
      console.log(res);
      alert("Request rejected...");
    })
  }

  Add(restaurant: any){
    this.Rest=restaurant;
    this.restApi.registerRestaurant(this.Rest).subscribe(res=>{
      console.log(res);
      // if(res){
      //   this.isSubmitBtnDisabled=true;
      // }
      alert("Restaurant Added Successfully");
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
