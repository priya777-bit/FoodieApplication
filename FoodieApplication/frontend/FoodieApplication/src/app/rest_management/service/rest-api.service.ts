import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  isRegister: boolean = false;
  isAddedDish : boolean = false;
  restData : any;

  constructor(private http: HttpClient) { }

   registerRestaurant(restaurant:any){
    this.isRegister = true;
    return this.http.post("http://localhost:8090/api/user/admin/restaurant/save",restaurant);
  }

  removeRestaurant(restaurantId:string){
    return this.http.delete("http://localhost:8090/api/user/admin/restaurant"+`${restaurantId}`);
  }

  addDishToRestaurant(restaurantId:string,dish:any){
    this.isAddedDish = true;
    return this.http.put("http://localhost:8090/api/user/admin/restaurant/"+`${restaurantId}`+"/dish",dish);
  }

}
