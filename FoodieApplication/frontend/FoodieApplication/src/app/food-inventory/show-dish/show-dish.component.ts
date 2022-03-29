import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { ActivatedRoute } from '@angular/router';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Dish } from '../modal/dish';

@Component({
  selector: 'app-show-dish',
  templateUrl: './show-dish.component.html',
  styleUrls: ['./show-dish.component.css']
})
export class ShowDishComponent {
 
  data2:Array<String>=[];

  dishes:any;
  data:any;

  ngOnInit(): void {
    // this.activatedRoute.paramMap.subscribe(data=>{
    //   let id=data.get('id') ??0;
    //   this.request.getDishes(id).subscribe(result=>{
    //     this.dishes=result;
    //     for(var i=0;i<result.length;i++)
    //     {
    //       this.getImage(result[i].dishId)
    //     }
        
    //   });
    // })
    
  }

  display():void{
    this.activatedRoute.paramMap.subscribe(data=>{
      let id=data.get('id') ??0;
      this.request.getDishes(id).subscribe(result=>{
        for(var i=0;i<result.length;i++)
        {
          this.getImage(result[i].dishId)
          this.dishes=result;
        }
        
      });
    })
    
  }
  getImage(id:any){
    this.request.getImages(id).subscribe(result=>{
      this.data=result;
    })
  }

  constructor(private activatedRoute:ActivatedRoute,private request:InventoryRequestService) 
  {
    
  }
}
