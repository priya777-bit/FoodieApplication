import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FavService {

  // userMailId : string;
  favId:string;

  constructor(private http: HttpClient) { }

  // addToFavUrl="http://localhost:8087/api/user/users/favourite/addFavourite";
  // getAllFavUrl="http://localhost:8087/api/user/users/favourite/getFavourite/{userMailId}";

  addToFav(fav:any):Observable<any>{
    return this.http.post<any>("http://localhost:8087/api/user/users/favourite/addFavourite",fav);
  }

  // getAllFav(userMailId:string):Observable<Array<any>>{
  //   return this.http.get<Array<any>>(`${this.getAllFavUrl}/${userMailId}`);
  // }
}
