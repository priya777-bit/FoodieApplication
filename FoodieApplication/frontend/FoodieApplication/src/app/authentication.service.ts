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

  logIn(){
    this.isLoggedIn=true;
    this.authStatusListener.next(true);  
  }
  logOut(){
    this.isLoggedIn=false;
    this.authStatusListener.next(false);  
  }

  getAuthStatusListener(){
    return this.authStatusListener.asObservable();
  }

}
