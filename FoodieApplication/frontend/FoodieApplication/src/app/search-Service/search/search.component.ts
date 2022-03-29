import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Dish } from 'src/app/add-Restaurant-Service/addRestModel/dish';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RestApiService } from 'src/app/rest_management/service/rest-api.service';
import { FindService } from '../service/find.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  search:FormGroup;

  rest = new Restaurant();

  dish = new Dish();

  filename:string;

  restaurant:Restaurant[]=[];

  dishes:Dish[]=[];

  constructor(private fs:FindService,private restapi:RestApiService) { }

  ngOnInit(): void {
    this.search = new FormGroup({  
      find:new FormControl()
    }); 
  }

  get find()
  {
    return this.search.get('find');
  }

  // getDishId()
  // {
  //   this.restapi.findAllRestaurant().subscribe(obj=>{
  //     this.dishes=obj;
  //     this.dishes.forEach(p=>{
  //       this.dish.dishId=p.dishId;
  //       console.log(this.dish.dishId);
  //     }) 
  //   })
  // }

getRestaurant()
{
  this.rest.restaurantName=this.search.value.find;
  this.fs.getByRestaurantName(this.rest.restaurantName).subscribe(obj=>{
    this.restaurant=obj;
    console.log(this.restaurant);
    this.getDish();
    this.dishes.forEach(p=>{
      this.dish.dishId=p.dishId;
    })
    this.getImage();
  })
}

getDish()
{
  this.dish.dishName=this.search.value.find;
  // this.getDishId();
  this.fs.getByDishName(this.dish.dishName).subscribe(obj=>{
    this.dishes=obj;
    console.log(this.dishes);
      this.dishes.forEach(p=>{
        console.log(p);
        this.dish.dishId=p.dishId;
        console.log(this.dish.dishId);
      })
    this.getImage();
  })
}

getImage()
{
  this.filename=this.dish.dishId;
  this.fs.getImage(this.filename).subscribe(obj=>{
    console.log(obj);
  })
}

  searching(event:any)
  {
    this.getRestaurant();
  }

}
