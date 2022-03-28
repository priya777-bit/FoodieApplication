import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { InventoryRequestService } from '../service/inventory-request.service';

@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})
export class ShowRestaurantComponent {

  
  restuarents: any;
  
  constructor(private breakpointObserver: BreakpointObserver,private request:InventoryRequestService) {}

  ngOnInit(){
    this.request.getdata().subscribe(result=>{
      this.restuarents=result;
    })
  }

}
