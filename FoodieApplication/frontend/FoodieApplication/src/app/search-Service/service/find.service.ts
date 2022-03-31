import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';

@Injectable({
  providedIn: 'root'
})
export class FindService {

  res:Restaurant[]=[];

  constructor(private http:HttpClient) { }

  getByRestaurantName(restaurantName:string):Observable<Array<any>>
  {
    return this.http.get<Array<any>>("http://localhost:8084/api/v1/search/rest/"+restaurantName);
  }

  getByDishName(dishName:string):Observable<Array<any>>
  {
    return this.http.get<Array<any>>("http://localhost:8084/api/v1/search/dish/"+dishName);
  }

  getImage(filename:string):Observable<any>
  {
    return this.http.get<any>("http://localhost:9000/api/inventory/restaurant/"+filename+".jpg");
  }
}
