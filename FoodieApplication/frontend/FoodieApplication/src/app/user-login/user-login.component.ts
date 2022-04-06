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
    userPassword: [null, Validators.required],
    loginType:[null, Validators.required],
    secretKey:[null, Validators.required]
  });

  data:any;
  loginType: any;
  types: string[] = ['Admin User', 'Normal User'];
  isAdmin:Boolean=false;
  constructor(private fb: FormBuilder,private request:UserRequestService,private authServe:AuthenticationService,private router:Router,private fav: FavService) {}

  ngOnInit(){
    const data=this.loginForm.value;
    if(data.loginType=='admin')
    {
      this.isAdmin=true;
    }
    else
    {
      this.isAdmin=false;
    }
  }

  onSubmit(): void {
    const data=this.loginForm.value;
    this.request.loginType=data.loginType;
    this.request.getData().subscribe(data1=>{
      for(var i=0;i<data1.length;i++)
      {
        if(data.userMailId==data1[i].userMailId && data.userPassword==data1[i].userPassword)
      {
        this.request.login(data).subscribe(response=>{
        this.data=response;
        this.request.token=this.data.token;
        console.log(this.data.token);
        this.authServe.loginUser(this.data.token);
        this.request.mailId=data.userMailId;
        const value=this.authServe.logIn(data.loginType);
        //this.request.mailId=this.fav.userMailId;
        if(value===this.authServe.logIn(data.loginType))
        {
        this.router.navigate(["/showRest"]);
      }
      else
      {
        alert("Invalid Credentials..");
      }
        });
      }
      }
      })
    }
}
