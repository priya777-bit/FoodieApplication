import { Component } from '@angular/core';
import { FormBuilder, Validators ,FormGroup,FormControl} from '@angular/forms';
import { UserRequestService } from '../user-request.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {
  // registerForm = this.fb.group({
  //   userMailId: [null,Validators.required],
  //   userName: [null, Validators.required],
  //   userPassword: [null, Validators.required],
  //   userPhoneNo: [null, Validators.required],
  //   address2: null,
  //   city: [null, Validators.required],
  //   state: [null, Validators.required],
  //   postalCode: [null, Validators.compose([
  //     Validators.required, Validators.minLength(5), Validators.maxLength(5)])
  //   ],
  //   shipping: ['free', Validators.required]
  // });

  registerForm=new FormGroup(
    {
      userMailId:new FormControl('',Validators.required),
      userName:new FormControl('',Validators.required),
      userPassword: new FormControl(null, Validators.required),
      userPhoneNo: new FormControl(null, Validators.required),
      image:new FormGroup({
        image:new FormControl('')
      })
    });

  hasUnitNumber = false;

  constructor(private fb: FormBuilder,private userRequest:UserRequestService) {}

  public selectedFile:any;
  public event1:any;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;
  
  public  onFileChanged(event:any) {
    this.selectedFile = event.target.files[0];
    // this.registerForm.value.image=this.selectedFile;
    // console.log(this.registerForm.value.image);
  //   // let reader = new FileReader();
  //   // reader.readAsDataURL(event.target.files[0]);
  //   // reader.onload = (event2) => {
  //   //   this.imgURL = reader.result;
  // };
}

onSubmit(): void {
  
  const uploadImageData = new FormData();
  uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);

  const uploadData = new FormData();
  uploadData.append('uploadData', this.registerForm.value)

  // const data=this.registerForm.value;
  // console.log(data);
  // console.log(uploadImageData);
  this.userRequest.register(uploadImageData,uploadData).subscribe(()=>{
    // this.router.navigate(['/login']);
  })
}
}
