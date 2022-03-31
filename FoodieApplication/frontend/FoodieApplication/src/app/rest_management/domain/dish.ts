import { Image } from '../domain/image';

export class Dish {

    dishId:string
    dishName:string
    dishType:string
    restaurantId:string
    image:Image[];

    constructor(){
        this.dishId='';
        this.dishName='';
        this.dishType='';
        this.restaurantId='';
        this.image=[];
    }
}
