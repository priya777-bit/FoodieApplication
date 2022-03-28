import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  isLoggedIn:boolean=false;
  redirectURL:String="";

  logIn(){
    this.isLoggedIn=true;
  }
  logOut(){
    this.isLoggedIn=false;
  }
}
