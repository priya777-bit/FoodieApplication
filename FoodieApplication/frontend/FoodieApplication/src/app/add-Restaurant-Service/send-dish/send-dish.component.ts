import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from '../addRestModel/restaurant';

@Component({
  selector: 'app-send-dish',
  templateUrl: './send-dish.component.html',
  styleUrls: ['./send-dish.component.css']
})
export class SendDishComponent implements OnInit {

  selected='';
  constructor() {
    this.selected = '--'
    this.restaurant=[];
   }

  addDish!:FormGroup;

  @Input()
  restaurant:Restaurant[];
  
  update(e:any){
    this.selected = e.target.value
  }

  ngOnInit(): void {
    this.addDish = new FormGroup({
      restaurantId:new FormControl('',Validators.required),
      dishName:new FormControl('',Validators.required),
      dishType:new FormControl('',Validators.required)
    })
  }

  get dishName()
  {
    return this.addDish.get('dishName');
  }

  get dishType()
  {
    return this.addDish.get('dishType');
  }

  sendDish(){}

}

