import { Image } from "./image";

export class Dish {
     
    dishId:string
    dishName:string
    dishType:string;
    image:Image[];

    constructor(){
        this.dishId='';
        this.dishName='';
        this.dishType='';
        this.image=[];
    }
}
