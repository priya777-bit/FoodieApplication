import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRequestService {

  constructor(private http:HttpClient) { }

  registerURL="http://localhost:9000/api/user/registerUser";

  register(uploadImageData:any,uploadData:any):Observable<any>
  {
    console.log(uploadImageData);
    console.log(uploadData);
    return this.http.post<any>(this.registerURL,uploadImageData,uploadData);
  }
}
