import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dish } from '../addRestModel/dish';
import { Restaurant } from '../addRestModel/restaurant';
import { SendDishComponent } from '../send-dish/send-dish.component';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http:HttpClient) { }

  restaurantId:string;
<<<<<<< HEAD
  dishId:string;
  payload=new FormData();
=======

  dishId:string;
  payload=new FormData();


>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910

  addRestaurant(rest:Restaurant)
  {
    return this.http.post("http://localhost:9000/api/request/restaurant",rest);
  }

<<<<<<< HEAD
  addDish(restaurantId:string,dish:Dish)
  {
    return this.http.put("http://localhost:9000/api/request/restaurant/"+restaurantId+"/dish",dish);
=======

  addDish(restaurantId:string,dish:Dish)
  {
    return this.http.put("http://localhost:9000/api/request/restaurant/"+restaurantId+"/dish",dish);

//   addDish(restaurantId:string,addDish:any)
//   {
//     return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",addDish);

>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910
  }

  findAllRestaurantByStatus(status:any):Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:9000/api/request/find/"+ `${status}`);
  }

  // findByRestaurantNameAndRestaurantLocation(restaurantName:string,restaurantLocation:string):Observable<any>{
  //   // return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+`${restaurantName}`+"/"+`${restaurantLocation}`);
<<<<<<< HEAD
  //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+restaurantName"/"+restaurantLocation",{responseType:text}");
  // }

=======

  //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+restaurantName"/"+restaurantLocation",{responseType:text}");
  // }



  //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+restaurantName"/"+restaurantLocation",{responseType:text}");
  // }


  // deleteRestaurant(restaurantId:Restaurant):Observable<any>
  // {
  //   return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+restaurantId);

  // //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/cafe/lanka,{responseType:text}");
  // // }


>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910
  deleteRestaurant(restaurantId:any):Observable<any>
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+ `${restaurantId}`);
  }

  findAllDishByRestaurantId(restaurantId:string):Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:9000/api/request/restaurant/"+`${restaurantId}`);
  }

  updateRestaurantWhenApprove(restaurant:Restaurant,status:string){
    return this.http.put("http://localhost:9000/api/request/restaurant/" +`${status}`,restaurant);
  }

  updateDishWhenApprove(restaurantId:string, dish:Dish, dishStatus:string){
    return this.http.put("http://localhost:9000/api/request/"+`${restaurantId}` +"/dish/" +`${dishStatus}`,dish)
  }

}
