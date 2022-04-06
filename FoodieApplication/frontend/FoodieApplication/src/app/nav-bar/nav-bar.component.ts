import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { BehaviorSubject, Observable, Subscription } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { UserRequestService } from '../user-request.service';

import * as $ from 'jquery'

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Web)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

    backgroundUrl="/assets/bg_image.jpg"
    backgroundUrl1="/assets/food-footer.jpg"

    private authListenerSubs: Subscription; 
    userIsAuthenticated:any;
    private isUserAdminSubs:Subscription;
    adminIsAuthenticated:any;

  constructor(private breakpointObserver: BreakpointObserver,private authService:AuthenticationService,private router:Router,private request:UserRequestService) {}

  LoginStatus$=new BehaviorSubject<boolean>(null);

  ngOnInit(){

    this.authListenerSubs = this.authService.getAuthStatusListener().subscribe(isAuthenticated=>{  
      this.userIsAuthenticated = isAuthenticated
    });  

    this.isUserAdminSubs=this.authService.getAdminStatusListener().subscribe(isAuthenticated=>{
      this.adminIsAuthenticated=isAuthenticated
    })
  }

  ngOnDestroy(){
    this.authListenerSubs.unsubscribe();
    this.isUserAdminSubs.unsubscribe();
    
  }
    

  logout():void{
    this.authService.logOut();
    this.router.navigate(["/login"]);
  }

}
