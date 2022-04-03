import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { UserRequestService } from '../user-request.service';
import { Login } from '../modal/login';
import { User } from '../modal/user';
import { AuthenticationService } from '../authentication.service';


@Component({
  selector: 'app-profile-dashboard',
  templateUrl: './profile-dashboard.component.html',
  styleUrls: ['./profile-dashboard.component.css']
})
export class ProfileDashboardComponent {
  
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  data?:any;
  userName?:any;

  constructor(private breakpointObserver: BreakpointObserver,private request:UserRequestService,private authServe:AuthenticationService) {}

  ngOnInit() {
    this.request.getProfile().subscribe(res=>{
      this.data=res;
      this.retrieveResonse = res.image;
      this.base64Data = this.retrieveResonse.picByte;
      this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
      // this.authServe.logIn();
    })
 }
}
