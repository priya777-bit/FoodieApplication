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

  resData:any;
  selectedFile:any=null;

  constructor(private api: RestApiService,private send:RequestService,private http:HttpClient) {
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
    this.send.getResturant().subscribe((r)=>{
      console.log(r);
      this.rest=r;
      console.log(this.rest);
      this.rest.forEach(r=>{
        this.sel=r.restaurantId;
        this.send.restaurantId=this.sel;
        console.log(r.restaurantId);
      })
    })

    this.api.findAllRestaurant().subscribe((response)=>{
      this.restaurant=response;
      console.log(response);
      this.restaurant.forEach(response=>{
        this.selected=response.restaurantId;
        this.api.restId=this.selected;
        console.log(response);
        console.log(this.api.restId);
      })
      })
      this.addDish = new FormGroup({
        dishName:new FormControl('',Validators.required),
        dishType:new FormControl('',Validators.required),

      image:new FormGroup({
        image:new FormControl(''),
      })
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

  onFileSelected(event:any)
  {
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);
  }

  uploadImage()
  {
    const payload = new FormData();

    payload.append('file',this.selectedFile,this.selectedFile.name);

    this.http.post("http://localhost:9000/api/request/restaurant/files"
    ,payload,
    )

    .subscribe((data:any)=>{
      this.resData = data;
      console.log(this.resData);
    })
  }

  sendDish()
  {
    this.dish.dishId=Math.random().toString(36).substring(2,15);
    this.dish.dishName=this.addDish.value.dishName;
    this.dish.dishType=this.addDish.value.dishType;

    this.uploadImage();

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