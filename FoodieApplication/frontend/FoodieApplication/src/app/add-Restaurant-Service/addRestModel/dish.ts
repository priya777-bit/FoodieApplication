import { Restaurant } from "./restaurant";

export class Dish {

    restaurantId:Restaurant
    dishId:string;
    dishName:string;
    dishType:string;

    constructor()
    {
        this.restaurantId=new Restaurant();
        this.dishId='';
        this.dishName='';
        this.dishType='';
    }
}
