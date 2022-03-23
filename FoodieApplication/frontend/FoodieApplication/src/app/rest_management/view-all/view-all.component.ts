import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/add-Restaurant-Service/addRestModel/restaurant';
import { RequestService } from 'src/app/add-Restaurant-Service/addRestService/request.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  restaurant:Restaurant[]=[];

  constructor(private addservice: RequestService) { 
  }

  ngOnInit(): void {
    this.addservice.getResturant().subscribe(response=>{
      console.log(response);
    })
  }

  delete(e:any){

  }
  Add(e:any){

  }

}
