import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
// import { Restaurant } from 'src/app/rest_management/domain/restaurant';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-add-rest',
  templateUrl: './add-rest.component.html',
  styleUrls: ['./add-rest.component.css']
})
export class AddRestComponent implements OnInit {

  constructor(private fb: FormBuilder,private restApi: RestApiService,private request: RequestService,private http:HttpClient) { }

  addRestForm !: FormGroup;
  Rest = new Restaurant();
  selectedFile:any=null;
   newdata:any;

  ngOnInit(): void {
    this.addRestForm = this.fb.group({
      restaurantName: [null,Validators.required],
      restaurantLocation: [null,Validators.required],
      image : this.fb.group({
        image:[null]
      })
    });
  }

  
  addRest(){
    this.Rest.restaurantId=Math.random().toString(36).substring(2,15);
    this.Rest.restaurantName=this.addRestForm.value.restaurantName;
    this.Rest.restaurantLocation=this.addRestForm.value.restaurantLocation;
    this.Rest.dishList=this.addRestForm.value.dishList;
    this.uploadImage();
    this.restApi.registerRestaurant(this.Rest)
    .subscribe(
        response=>{
          console.log(response)
          if(this.addRestForm.valid){
          alert("Restaurant Added Successfully\n Your RestaurantId is\n" + this.Rest.restaurantId);
        }
      },
      error =>{
          console.log(error);
        }
    )
    this.request.updateRestaurantWhenApprove(this.Rest,"approve").subscribe(res=>{
      console.log(res);
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
    payload.append('file',this.selectedFile,this.Rest.restaurantId+".jpg");

    this.http.post("http://localhost:8090/api/user/admin/image",payload,)
    .subscribe((data:any)=>{
      this.newdata = data;
      console.log(this.newdata);
    })
  }
  
}
