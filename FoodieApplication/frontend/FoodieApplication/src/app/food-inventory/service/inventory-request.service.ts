import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryRequestService {

  constructor(private http:HttpClient) { }

  getURL='http://localhost:9000/api/inventory/getAllData';
  getDishesURL='http://localhost:9000/api/inventory/getDishesData';

  getdata():Observable<Array<any>>
  {
    return this.http.get<Array<any>>(this.getURL);
  }

  getDishes(id:any):Observable<Array<any>>
  {
    return this.http.get<Array<any>>(`${this.getDishesURL}/${id}`);
  }

}
