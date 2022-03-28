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
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
  restName:string;
  restLocation:string;
  //restId:string;
  dishId:string;
<<<<<<< HEAD

=======
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba

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
