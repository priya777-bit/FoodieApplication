import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InventoryRequestService } from '../service/inventory-request.service';
import { Map } from '../modal/map';
import { List } from '../modal/list';
import { Dish } from '../modal/dish';
import { Observable } from 'rxjs';
import { Image } from '../modal/image';

@Component({
  selector: 'app-show-dish',
  templateUrl: './show-dish.component.html',
  styleUrls: ['./show-dish.component.css']
})
export class ShowDishComponent {
 
  // data2:Array<String>=[];

  
  // data:Dish[]=[];
  data:Dish[];
  // myArray: any; 
  //  map = new Map;
  //  list=new List;
   data2:Image[];
  //  dataDisp:Dish[];
  //  imagDisp:Image[];



  ngOnInit(): void{
    this.activatedRoute.paramMap.subscribe(data=>{
      let id=data.get('id') ??0;
      this.request.getDishes(id).subscribe(result1=>
        {
        result1.forEach((element: Dish) => {
          this.request.getImages(element.dishId).subscribe(result=>{
            this.data2=result;
            element.image=result;
            console.log(element);
            console.log(result1);
            this.data=result1;
          })  
        });  
      });
    })
    
  }
  constructor(private activatedRoute:ActivatedRoute,private request:InventoryRequestService) 
  {
    
  }
}
