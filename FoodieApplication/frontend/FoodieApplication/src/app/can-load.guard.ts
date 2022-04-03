import { Injectable } from '@angular/core';
import { CanLoad, Route, Router, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class CanLoadGuard implements CanLoad {

  constructor(private authService:AuthenticationService,private router:Router)
  {

  }


  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.checkIsUserAdmin('admin');
  }

  checkIsUserAdmin(url: string) {
    if(this.authService.isUserAdmin) 
    return this.authService.isUserAdmin;
    this.authService.redirectURL = url;
    console.log("hi");
    alert("Only Admin User Can Access");
    return this.router.parseUrl('');  
  }
}
