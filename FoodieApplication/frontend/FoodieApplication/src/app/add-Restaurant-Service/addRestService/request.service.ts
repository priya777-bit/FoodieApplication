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

  addRestaurant(rest:Restaurant)
  {
    return this.http.post("http://localhost:9000/api/request/restaurant",rest);
  }

  addDish(restaurantId:string,addDish:any)
  {
    return this.http.put("http://localhost:9000/api/request/"+restaurantId+"/dish",addDish);
  }

  getResturant():Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:9000/api/request/restaurant/find");
  }

  deleteRestaurant(restaurantId:Restaurant):Observable<any>
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/"+restaurantId);
  }

}
