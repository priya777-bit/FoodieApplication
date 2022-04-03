import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {
  private isAuthenticated = false;  
  private authStatusListener = new Subject<boolean>();  
  
  constructor() { }
  isLoggedIn:boolean=false;
  redirectURL:String="";
  isUserAdmin: boolean = false;


  loginUser(token: any) {
    console.log(token);
    localStorage.setItem("token", token);
    return true;
  }

  logIn(code:any){
    let token = localStorage.getItem("token");
    console.log(token);
    console.log(code);
    console.log(this.isUserAdmin);
    this.isUserAdmin = code.startsWith('admin');
    console.log(this.isUserAdmin);
    if (token ==null || token ==undefined|| token == '' ) {
      this.isLoggedIn=false;
      console.log("in if");
      return false;
    }
    else {
      console.log("in else");
      this.isLoggedIn=true;
      this.authStatusListener.next(true);
      return true;
    }
  }
  logOut(){
    localStorage.removeItem("token");
    this.isLoggedIn=false;
    this.authStatusListener.next(false);  
    this.isUserAdmin =false;
    console.log(this.isUserAdmin);
  }

  getAuthStatusListener(){
    return this.authStatusListener.asObservable();
  }

}
