import { HttpClient } from '@angular/common/http';
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

  constructor(private request:RequestService,private api: RestApiService,private http:HttpClient) {}

  rest = new Restaurant();
  addRestaurant!:FormGroup;
  selectedFile:any=null;

  resData:any;

  sendDish:boolean=false;

  ngOnInit(): void {
    this.addRestaurant = new FormGroup({
      restaurantName: new FormControl('',Validators.required),
      restaurantLocation : new FormControl('',Validators.required),
      image:new FormGroup({
        image:new FormControl(''),
      })

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

  onFileSelected(event:any)
  {
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);
  }

  sendRestaurant()
  {
    this.rest.restaurantId=Math.random().toString(36).substring(2,15);
    this.api.restId=this.rest.restaurantId;
    this.rest.restaurantName=this.addRestaurant.value.restaurantName;
    this.rest.restaurantLocation= this.addRestaurant.value.restaurantLocation;
    this.rest.dishList=this.addRestaurant.value.dishList;
    this.uploadImage();
    this.request.addRestaurant(this.rest).subscribe((response: any)=>{
      console.log(response);
      this.request.restaurantId=this.rest.restaurantId;
      if(this.addRestaurant.valid)
      {
        alert("Request Send Successfully..");
        if(this.api.restId===this.rest.restaurantId)
        {
          this.request.findAllRestaurantByStatus("approve").subscribe(s=>{
            this.sendDish=true;
          })
        } 
      }
    })
  }

  uploadImage()
  {
    this.request.payload = new FormData();

    this.request.payload.append('file',this.selectedFile,this.rest.restaurantId+".jpg");

    this.http.post("http://localhost:9000/api/request/restaurant/files"
    ,this.request.payload,
    // {headers:{'Content-Type':'multipart/formdata'}}
    )

    .subscribe((data:any)=>{
      this.resData = data;
      console.log(this.resData);
    })
  }

}
