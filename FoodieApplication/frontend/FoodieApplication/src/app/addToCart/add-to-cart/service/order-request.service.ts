import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderRequestService {

  orderUrl='http://localhost:8088/api/user/users/order/order/addToCart';
  getAllOrderUrl='http://localhost:8088/api/user/users/order/order/getUserOrder';
  addDishUrl='http://localhost:8088/api/user/users/order/addDishToOrder';

  constructor(private http:HttpClient) {  }

  addToOrder(order:any):Observable<any>{
    return this.http.post<any>(this.orderUrl,order);
  }

  getAllOrder(userMailId:string):Observable<Array<any>>{
    return this.http.get<Array<any>>(`${this.getAllOrderUrl}/${userMailId}`);
  }

  addOrderDish(orderId:string,restaurantId:any,dish:any){
    return this.http.post(`${this.addDishUrl}/${orderId}/${restaurantId}`+"/dish",dish);
  }

}
