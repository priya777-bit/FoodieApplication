import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { FavService } from '../favService/service/fav.service';
import { UserRequestService } from '../user-request.service';
import { ToastrService } from 'ngx-toastr';
import { CustomvalidationService } from '../customvalidation.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  loginForm = this.fb.group({
    userMailId: ['', Validators.compose([Validators.required, this.customValidator.emailPatternValidator()])],
    userPassword: ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
    loginType:[null, Validators.required],
    secretKey:[null, Validators.required]
  });

  data:any;
  loginType: any;
  types: string[] = ['Admin User', 'Normal User'];
  isAdmin:Boolean=false;
  constructor(private fb: FormBuilder,private request:UserRequestService,private authServe:AuthenticationService,private router:Router,private fav: FavService,private toastr: ToastrService,private customValidator:CustomvalidationService) {}

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
    var flag=0;
    this.request.loginType=data.loginType;
    this.request.getData().subscribe(data1=>{
      for(var i=0;i<data1.length;i++)
      {
        if(data.userMailId==data1[i].userMailId && data.userPassword==data1[i].userPassword)
      {
        flag=1;
        this.request.login(data).subscribe(response=>{
        this.data=response;
        this.request.token=this.data.token;
        console.log(this.data.token);
        this.authServe.loginUser(this.data.token);
        this.request.mailId=data.userMailId;
        const value=this.authServe.logIn(data.loginType); // null
        //this.request.mailId=this.fav.userMailId;
        if(value) // logic needs to be changed.
        {
        this.toastr.success('Welcome '+data.userMailId);
        this.router.navigate(["/showRest"]);
        }
      })
      }
        }
      })

      // if(flag==0)
      // {
      //   alert("Invalid UserName or Password");
      // }
      }

      // else
      //   // {
      //   //   alert("Invalid UserName or Password");
      //   //   break;
      //   // }
      }
