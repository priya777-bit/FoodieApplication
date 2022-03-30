import { Image } from "./image";

export class Dish {

    restaurantId:string
    dishId:string;
    dishName:string;
    dishType:string;
    image:Image[]=[];

    constructor()
    {
        this.restaurantId='';
        this.dishId='';
        this.dishName='';
        this.dishType='';
    }
}
