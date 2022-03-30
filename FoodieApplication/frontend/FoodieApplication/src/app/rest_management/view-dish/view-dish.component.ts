import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';
import { Dish } from '../domain/dish';
import { Image } from '../domain/image';
import { Restaurant } from '../domain/restaurant';
import { RestApiService } from '../service/rest-api.service';

@Component({
  selector: 'app-view-dish',
  templateUrl: './view-dish.component.html',
  styleUrls: ['./view-dish.component.css']
})
export class ViewDishComponent implements OnInit {

  selected='';
  Dish = new Dish();
  dishes:Dish[]=[];
  restaurant : Restaurant [] =[];
  dishImage : Image[];
  dishStatus:"reject";
  // dishObj:any;
  

  constructor(private addService: RequestService, private restApi: RestApiService,private activatedRoute:ActivatedRoute) { 
    this.selected = 'Please Select a Restaurant';
    this.restaurant=[];
    this.dishes=[];
  }

  ngOnInit(): void {
    this.addService.findAllRestaurantByStatus("approve").subscribe(res=>{
      console.log(res);
      this.restaurant=res;
      console.log('Rst', this.restaurant);
    });
  }


  changeRest(e: any){
    console.log('Selected Id ', e.value);
    this.selected = e.value;
    console.log(this.selected);
    this.addService.restaurantId = this.selected;
  
      console.log("iddddd",this.addService.restaurantId);
       this.addService.findAllDishByRestaurantId(this.addService.restaurantId).subscribe(r=>{
         this.dishes = r.filter(f=>f.dishStatus!="approve");
          console.log("dishes", this.dishes);
          // this.dishes=this.Dish;
          this.dishes.forEach((element: Dish)=>{
            console.log("newid"+element.dishId);
          this.restApi.getImages(element.dishId).subscribe(i=>{
            //   console.log("i"+i.dishId)
            // i.dishId=this.imgId;
            // if(this.dishObj.dishId=this.imgId){
              // i.image=this.dishImages
            element.image=i;
            console.log(i);
            //this.imgpath=i;
            //}
            
          //   console.log(element);
          //   console.log(element.image)
          //  console.log("obj"+this.dishObj)
          //   console.log("img"+element.dishId)
    
          //   this.restApi.getImages(element.dishId).subscribe(i=>{
          //   //   console.log("i"+i.dishId)
          //   // i.dishId=this.imgId;
          //   // if(this.dishObj.dishId=this.imgId){
          //     // i.image=this.dishImages
          //   console.log(i.image);
          //   console.log("newid"+element.dishId);
          //   //this.imgpath=i;
          //   //}
          // })
          })
        })
      })
    }
  

  Add(dish: any){
    // this.Dish.dishId=this.addService.dishId;
    // console.log(this.Dish.dishId)
    //this.Dish=dish;
    //console.log("this.Dish"+this.Dish);
    console.log("dish",dish)
    this.restApi.addDishToRestaurant(this.addService.restaurantId,dish).subscribe(r=>{
      console.log(r);
      alert("Dish Request Accepted....")
    });

    this.addService.updateDishWhenApprove(this.addService.restaurantId,dish,"approve").subscribe(d=>{
       console.log("updated Dish",d);
    })
  }
}
