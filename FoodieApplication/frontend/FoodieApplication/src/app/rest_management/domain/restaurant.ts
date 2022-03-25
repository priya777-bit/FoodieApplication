import { Dish } from "./dish";

export class Restaurant {
    
    restaurantId:string
    restaurantName:string
    restaurantLocation:string
   // restaurantStatus:string
    dishList: Array<Dish>
  //static restaurantId: string;

    constructor(){
        this.restaurantId='',
        this.restaurantName='';
        this.restaurantLocation='';
        this.dishList=[];
    }

}
