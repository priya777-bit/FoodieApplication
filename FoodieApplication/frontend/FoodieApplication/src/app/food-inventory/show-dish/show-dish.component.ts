import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { ActivatedRoute } from '@angular/router';
import { InventoryRequestService } from '../service/inventory-request.service';

@Component({
  selector: 'app-show-dish',
  templateUrl: './show-dish.component.html',
  styleUrls: ['./show-dish.component.css']
})
export class ShowDishComponent {
 
  dishes:any;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(data=>{
      let id=data.get('id') ??0;
      console.log(id);
      this.request.getDishes(id).subscribe(result=>{
        this.dishes=result;
        console.log(this.dishes);
      });
    })
  }

  constructor(private activatedRoute:ActivatedRoute,private request:InventoryRequestService) 
  {
    
  }
}
