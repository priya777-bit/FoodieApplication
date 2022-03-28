import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
import { Dish } from '../domain/dish';
import { Restaurant } from '../domain/restaurant';
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
    this.selected="";
    this.restaurant=[];
  }

  addDishForm !: FormGroup
  dish = new Dish();
  types = ['Veg','Non-Veg'];
  restaurant:Restaurant[]=[];

  changeRest(e:any){
    this.selected = e.target.value;
  }

  ngOnInit(): void {
<<<<<<< HEAD
    this.restApi.findAllRestaurant().subscribe(response=>{

=======
   this.restApi.findAllRestaurant().subscribe((response)=>{
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
      this.restaurant=response;
      console.log(response);
<<<<<<< HEAD
    })

    // this.restaurant=response;
      this.restaurant.forEach(element=>{
        // if(element.restaurantId=response[0].restaurantId){
        this.selected=element.restaurantId;
        // }
      })

      this.addDishForm = this.fb.group({
        dishName: [null,Validators.required],
        dishType: [null,Validators.required]
      });
    }


    

    addDish(){
      this.dish.dishId=this.request.dishId;
      this.dish.dishName=this.addDishForm.value.dishName;
      this.dish.dishType=this.addDishForm.value.dishType;
      this.restApi.addDishToRestaurant(this.request.restaurantId,this.dish).subscribe(response=>{
        console.log(response);
        // this.dishList=response;
        // console.log(this.dishList)
        // console.log(this.restApi.restId);
        if(this.addDishForm.valid){
        alert("Dish Added Successfully\n Your RestaurantId is\n" + this.dish.dishId);
      }
    },
      error =>{
            console.log(error);
          }
      )}
  }

 
=======
      this.restaurant.forEach(response=>{
        this.selected=response.restaurantId;
        this.restApi.restId=this.selected;
        console.log(response);
        console.log(this.restApi.restId);
      })
      })

    this.addDishForm = this.fb.group({
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

    payload.append('file',this.selectedFile,this.selectedFile.name);

    this.http.post("http://localhost:8090/api/user/admin/dishImage",payload,)
    .subscribe((data:any)=>{
      this.newdata = data;
      console.log(this.newdata);
    })
  }


  addDish(){
    this.dish.dishId=this.request.dishId;
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
    )}
}
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
