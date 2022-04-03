import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { FavService } from '../favService/service/fav.service';
import { UserRequestService } from '../user-request.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  loginForm = this.fb.group({
    userMailId: [null, Validators.required],
    userPassword: [null, Validators.required]
  });

  data:any;
  constructor(private fb: FormBuilder,private request:UserRequestService,private authServe:AuthenticationService,private router:Router,private fav: FavService) {}

  onSubmit(): void {
    const data=this.loginForm.value;
    this.request.getData().subscribe(data1=>{
      for(var i=0;i<data1.length;i++)
      {
        if(data.userMailId==data1[i].userMailId && data.userPassword==data1[i].userPassword)
      {
        this.request.login(data).subscribe(response=>{
        console.log(response);
        this.data=response;
        this.request.token=this.data.token;
        console.log(this.data.token);
        this.authServe.loginUser(null);
        this.request.mailId=data.userMailId;
        console.log("id",this.request.mailId)
        const value=this.authServe.logIn(data.userMailId);
        console.log(value);
        //this.request.mailId=this.fav.userMailId;
        if(value)
        {
        this.router.navigate(["/showRest"]);
        }
      })
      }
      }
    })
  }
}
