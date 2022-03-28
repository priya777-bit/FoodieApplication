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

=======
  dishId:string;
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba

  addRestaurant(rest:Restaurant)
  {
    return this.http.post("http://localhost:9000/api/request/restaurant",rest);
  }

<<<<<<< HEAD

  // addDish(restaurantId:string,addDish:any)
  // {
  //   return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",addDish);
  // }

  addDish(restaurantId:string,dish:Dish)
  {
    return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",dish);

=======
  addDish(restaurantId:string,addDish:any)
  {
    return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",addDish);
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
  }

  getResturant():Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:9000/api/request/restaurant/find");
  }

  // findByRestaurantNameAndRestaurantLocation(restaurantName:string,restaurantLocation:string):Observable<any>{
  //   // return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+`${restaurantName}`+"/"+`${restaurantLocation}`);
<<<<<<< HEAD
  //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+restaurantName"/"+restaurantLocation",{responseType:text}");
  // }


  deleteRestaurant(restaurantId:Restaurant):Observable<any>
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+restaurantId);
=======
  //   return this.http.get<any>("http://localhost:9000/api/request/restaurant/cafe/lanka,{responseType:text}");
  // }

  deleteRestaurant(restaurantId:any):Observable<any>
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+ `${restaurantId}`);
  }

  findAllDishByRestaurantId(restaurantId:any):Observable<any>{
    return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+`${restaurantId}`);
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
  }

}
