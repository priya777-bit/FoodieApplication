import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {
  private isAuthenticated = false;  
  private authStatusListener = new Subject<boolean>();  
  private adminStatusListener = new Subject<boolean>();  
  
  constructor() { }
  isLoggedIn:boolean=false;
  redirectURL:String="";
  isUserAdmin: boolean = false;


  loginUser(token: any) {
    console.log("token "+token);
    if (token) 
    {
    localStorage.setItem("token", token);
    return true;
    }
    else
    {
      console.log("in else");
      return false;
    }
    
  }

  logIn(code:any){
    let token = localStorage.getItem("token");
    console.log("token "+token);
    console.log(code);
    console.log(this.isUserAdmin);
    this.isUserAdmin = code.startsWith('admin');
    console.log(this.isUserAdmin);
    if(token) 
    {
      if(this.isUserAdmin){
        this.isLoggedIn=true;
        this.adminStatusListener.next(true);
        return true;
      }
      else
      {
        console.log("in else");
        this.isLoggedIn=true;
        this.authStatusListener.next(true);
        return true;
      }

      // this.isLoggedIn=false;
      // return false;

    }
    else 
    {
      console.log("in else false");
      this.isLoggedIn=false;
      this.adminStatusListener.next(false);
      return false;
    }
   
  }
  logOut(){
    localStorage.removeItem("token");
    localStorage.clear();
    this.isLoggedIn=false;
    this.authStatusListener.next(false);  
    this.adminStatusListener.next(false);  
    this.isUserAdmin =false;
    console.log(this.isUserAdmin);
  }

  getAuthStatusListener(){
    return this.authStatusListener.asObservable();
  }

  getAdminStatusListener(){
    return this.adminStatusListener.asObservable();
  }

}
