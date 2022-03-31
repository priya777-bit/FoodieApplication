import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Dish } from 'src/app/add-Restaurant-Service/addRestModel/dish';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html',
  styleUrls: ['./add-dish.component.css']
})
export class AddDishComponent implements OnInit {

  selected='';
  selectedFile:any=null;
  newdata:any;
  constructor(private fb: FormBuilder,private restApi : RestApiService,private request : RequestService,private http:HttpClient) { 
    this.restaurant=[];
    this.selected = 'Please Select a Restaurant';
    
    
  }

  addDishForm !: FormGroup
  dish = new Dish();
  dishes:Dish[]=[];
  types = ['Veg','Non-Veg'];
  restaurant:Restaurant[]=[];

  changeRest(e: any){
    console.log('Selected Id ', e.value);
    this.selected = e.value;
    console.log(this.selected);
    this.restApi.restId = this.selected;
    console.log("iddddd",this.selected);
    this.selected=this.restApi.restId
    this.request.findAllDishByRestaurantId(this.restApi.restId).subscribe(r=>{
       console.log("se"+this.selected)
       console.log("Restapi",this.restApi.restId)
       this.dishes=r;
       console.log("dish",r);
      })
      

  }

  ngOnInit(): void { 
    
    this.request.findAllRestaurantByStatus("approve").subscribe(res=>{
      console.log(res);
      this.restaurant=res;
      console.log('Rst', this.restaurant);
    });

    this.addDishForm = this.fb.group({
      dishId: [null,Validators.required],
      dishName: [null,Validators.required],
      dishType: [null,Validators.required],
      image : this.fb.group({
        image:[null]
      })
    })
  }

  onFileSelected(event:any)
  {
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);
  }

  uploadImage()
  {
    const payload = new FormData();
    payload.append('file',this.selectedFile,this.dish.dishId+".jpg");

    this.http.post("http://localhost:8090/api/user/admin/dishImage",payload,)
    .subscribe((data:any)=>{
      this.newdata = data;
      console.log(this.newdata);
    })
  }


  addDish(){
    // this.dish.dishId=this.restApi.dishId;
    // console.log("iee"+this.restApi.dishId)
    // console.log("ds"+this.dish.dishId)
    this.dish.dishId=this.addDishForm.value.dishId;
    this.dish.dishName=this.addDishForm.value.dishName;
    this.dish.dishType=this.addDishForm.value.dishType;
    this.uploadImage();
    this.restApi.addDishToRestaurant(this.restApi.restId,this.dish).subscribe(response=>{
      console.log(response);
      if(this.addDishForm.valid){
      alert("Dish Added Successfully\n Your RestaurantId is\n" + this.dish.dishId);
    }
  },
    error =>{
          console.log(error);
        }
    )
    this.request.updateDishWhenApprove(this.restApi.restId,this.dish,"approve").subscribe(response=>{
      console.log(response);
    })
  }
}
