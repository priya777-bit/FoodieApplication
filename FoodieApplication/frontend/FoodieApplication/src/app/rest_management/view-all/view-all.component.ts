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

  selected='';
  Rest = new Restaurant();
  restaurant:Restaurant[]=[];

  constructor(private addservice: RequestService,private restApi: RestApiService) { 
    this.selected='';
    this.restaurant=[];
  }

  ngOnInit(): void {
    this.addservice.getResturant().subscribe(response=>{
<<<<<<< HEAD
      console.log(response);
      this.restaurant=response;
=======
      // response.forEach(e=>{
      // })
      this.restaurant=response;
      console.log(response)
>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
    })
  }

  delete(){
    //this.restaurant=e.target.value;
    // this.addservice.deleteRestaurant().subscribe(response=>{
    //   console.log(response);
    // })

  }

  Add(e:any){
    this.selected=e.target.value;
    
    this.restApi.registerRestaurant(this.Rest).subscribe(res=>{
      console.log(res);
      alert("Restaurant Added Successfully\n Your RestaurantId is\n" + this.Rest.restaurantId); 
    },error =>{
          console.log(error);
    }
    )}
}
