import { Dish } from "./dish";
import { Image } from "./image";

export class Restaurant {

    restaurantId:string;
    restaurantName:string;
    restaurantLocation:string;
    image:Image[]=[];
    dishList:Dish[]=[];

    constructor()
    {
        this.restaurantId='';
        this.restaurantName='';
        this.restaurantLocation='';
        this.dishList=[];
    }
}
