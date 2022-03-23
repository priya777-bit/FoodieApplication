import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
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
}
