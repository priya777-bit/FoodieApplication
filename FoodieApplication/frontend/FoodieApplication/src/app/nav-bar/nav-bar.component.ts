import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { BehaviorSubject, Observable, Subscription } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { UserRequestService } from '../user-request.service';

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

    private authListenerSubs: Subscription; 
    userIsAuthenticated:any;
    isUserAdmin:boolean=false;

  constructor(private breakpointObserver: BreakpointObserver,private authService:AuthenticationService,private router:Router,private request:UserRequestService) {}

  LoginStatus$=new BehaviorSubject<boolean>(null);

  ngOnInit(){
    // this.authService.globalStateChanged.subscribe(state=>{
    //   this.LoginStatus$.next(state.logIn)
    // })
    this.authListenerSubs = this.authService.getAuthStatusListener().subscribe(isAuthenticated=>{  
      this.userIsAuthenticated = isAuthenticated
    });  

    this.isUserAdmin=this.authService.isUserAdmin;
  }

  ngOnDestroy(){
    this.authListenerSubs.unsubscribe();
  }
    

  logout():void{
    this.authService.logOut();
    this.router.navigate(["/login"]);
  }

}
