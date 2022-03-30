import { Image } from "src/app/rest_management/domain/image";

export class Dish {

    restaurantId:string
    dishId:string;
    dishName:string;
    dishType:string;
    image:Image[];

    constructor()
    {
        this.restaurantId='';
        this.dishId='';
        this.dishName='';
        this.dishType='';
        this.image=[];
    }
}
