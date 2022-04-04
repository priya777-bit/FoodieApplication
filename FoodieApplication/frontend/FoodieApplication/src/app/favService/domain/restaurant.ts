import { Dish } from "./dish";
import { Image } from "./image";

export class Restaurant {

    restaurantId:string;
    restaurantName:string;
    restaurantLocation:string;
    image:Image[];
    dishList: Array<Dish>;

    constructor(){
        this.restaurantId='',
        this.restaurantName='';
        this.restaurantLocation='';
        this.image=[];
        this.dishList=[];
    }
}
