import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderRequestService {

  orderUrl='http://localhost:9000/api/user/order/order/addToCart';
  getAllOrderUrl='http://localhost:9000/api/user/order/order/getUserOrder';
  addDishUrl='http://localhost:9000/api/user/order/addDishToOrder';
  removeOrderURL='http://localhost:9000/api/user/order/deleteOrder';

  orderId:any;

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

  emptyCart(orderId:any){
    return this.http.delete(`${this.removeOrderURL}/${orderId}`);
  }

}
