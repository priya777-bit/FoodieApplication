import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './modal/login';
import { User } from './modal/user';

@Injectable({
  providedIn: 'root'
})
export class UserRequestService {

  constructor(private http:HttpClient) { }

  mailId:any;
  show:boolean;

  registerURL="http://localhost:9000/api/user/registerUser";
  imgURL="http://localhost:9000/api/user/userImage";
  loginURL="http://localhost:9000/api/userAuthentication/login";
  getProfileURL="http://localhost:9000/api/user/users/getUserProfile"
  getDataURL="http://localhost:9000/api/userAuthentication/getData";

  register(uploadImageData:any):Observable<any>
  {
    console.log(uploadImageData);
   // return this.http.post(this.registerURL , uploadImageData, {headers : new HttpHeaders({ 'Content-Type': 'application/json' })});
    
   // console.log(uploadData);
    return this.http.post<any>(this.registerURL,uploadImageData);
  }

  uploadImage(file:File):Observable<any>
  {
    var uploadImageData = new FormData();
    uploadImageData.append('file', file);
    return this.http.post<any>(this.imgURL,uploadImageData);
  }

  login(data:Login):Observable<Login>
  {
    return this.http.post<Login>(this.loginURL,data);
  }

  getData():Observable<Array<Login>>
  {
    return this.http.get<Array<Login>>(this.getDataURL);
  }

  getProfile():Observable<any>{
    return this.http.get<any>(`${this.getProfileURL}/${this.mailId}`);
  }

}
