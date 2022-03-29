import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dish } from '../modal/dish';

@Injectable({
  providedIn: 'root'
})
export class InventoryRequestService {

  constructor(private http:HttpClient) { }

  getURL='http://localhost:9000/api/inventory/getAllData';
  getDishesURL='http://localhost:9000/api/inventory/getDishesData';
  getImageURL='http://localhost:9000/api/inventory/restaurant';

  getdata():Observable<Array<any>>
  {
    return this.http.get<Array<any>>(this.getURL);
  }

  getDishes(id:any):Observable<Array<Dish>>
  {
    return this.http.get<Array<Dish>>(`${this.getDishesURL}/${id}`);
  }

  getImages(id:any):Observable<any>
  {
    return this.http.get<any>(`${this.getImageURL}/${id}.jpg`);
  }

}
