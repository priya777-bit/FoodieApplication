import { Dish } from "./dish";

export class Restaurant {

    restaurantId:string;
    restaurantName:string;
    restaurantLocation:string;
    dishList:Dish[]=[];

    constructor()
    {
        this.restaurantId='';
        this.restaurantName='';
        this.restaurantLocation='';
        this.dishList=[];
    }
}
