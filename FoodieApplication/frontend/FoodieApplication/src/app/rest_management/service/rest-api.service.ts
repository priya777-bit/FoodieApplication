import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  isRegister: boolean = false;
  isAddedDish : boolean = false;
<<<<<<< HEAD
  restId:string;
=======

  restId:string;

>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b
  restName:string;
  restLocation:string;
  dishId:string;
<<<<<<< HEAD
=======

>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b

  constructor(private http: HttpClient) { }

   registerRestaurant(restaurant:any):Observable<any>{
    this.isRegister = true;
    return this.http.post("http://localhost:8090/api/user/admin/restaurant/save",restaurant);
  }

  removeRestaurant(restaurantId:string){
    return this.http.delete("http://localhost:8090/api/user/admin/restaurant/"+`${restaurantId}`);
  }

  addDishToRestaurant(restaurantId:string,dish:any):Observable<any>{
    this.isAddedDish = true;
    return this.http.put("http://localhost:8090/api/user/admin/restaurant/"+`${restaurantId}`+"/dish",dish);
  }

  findAllRestaurant():Observable<Array<any>>{
    return this.http.get<Array<any>>("http://localhost:8090/api/user/admin/restaurant/find");
  }

}
