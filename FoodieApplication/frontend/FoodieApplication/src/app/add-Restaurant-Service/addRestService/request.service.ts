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
=======
  dishId:string;
>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf

  addRestaurant(rest:Restaurant)
  {
    return this.http.post("http://localhost:9000/api/request/restaurant",rest);
  }

<<<<<<< HEAD
  addDish(restaurantId:string,addDish:any)
  {
    return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",addDish);
=======
  addDish(restaurantId:string,dish:Dish)
  {
    return this.http.put("http://localhost:8081/api/request/"+restaurantId+"/dish",dish);
>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
  }

  getResturant():Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:9000/api/request/restaurant/find");
  }

<<<<<<< HEAD
=======
  findByRestaurantNameAndRestaurantLocation(restaurantName:string,restaurantLocation:string):Observable<any>{
    // return this.http.get<any>("http://localhost:9000/api/request/restaurant/"+`${restaurantName}`+"/"+`${restaurantLocation}`);
    return this.http.get<any>("http://localhost:9000/api/request/restaurant/cafe/lanka,{responseType:text}");
  }

>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
  deleteRestaurant(restaurantId:Restaurant):Observable<any>
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+restaurantId);
  }

}
