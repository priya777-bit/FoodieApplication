import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-image',
  templateUrl: './upload-image.component.html',
  styleUrls: ['./upload-image.component.css']
})
export class UploadImageComponent implements OnInit {

  image:File;
  resData:any;
  selectedFile:any=null;

  constructor(private http:HttpClient) {
    
   }

  ngOnInit(): void {
  }

  onFileSelected(event:any)
  {
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);
  }

  uploadImage()
  {
    const payload = new FormData();

    payload.append('image',this.selectedFile,this.selectedFile.name);

    this.http.post("http://localhost:9000/api/request/restaurant/files"
    ,payload,
    // {headers:{'Content-Type':'multipart/formdata'}}
    )

    .subscribe((data:any)=>{
      this.resData = data;
      console.log(this.resData);
    })
  }

}
