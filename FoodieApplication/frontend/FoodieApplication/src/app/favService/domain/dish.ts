import { Image } from "./image";

export class Dish {
     
    dishId:string
    dishName:string
    image:Image[];

    constructor(){
        this.dishId='';
        this.dishName='';
        this.image=[];
    }
}
