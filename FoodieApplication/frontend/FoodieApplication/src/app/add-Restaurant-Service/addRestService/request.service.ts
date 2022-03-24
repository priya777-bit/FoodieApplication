import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../addRestModel/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http:HttpClient) { }

  addRestaurant(rest:Restaurant)
  {
    return this.http.post("http://localhost:9000/api/request/restaurant",rest);
  }

  getResturant():Observable<any>{
    return this.http.get<any>("http://localhost:9000/api/request/restaurant/find");
  }

  deleteRestaurant()
  {
    return this.http.delete<any>("http://localhost:9000/api/request/restaurant/delete");
  }
}
