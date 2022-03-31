<<<<<<< HEAD
import { Image } from "src/app/rest_management/domain/image";
=======
import { Image } from "./image";
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b

export class Dish {

    restaurantId:string
    dishId:string;
    dishName:string;
    dishType:string;
<<<<<<< HEAD
    image:Image[];
=======
    image:Image[]=[];
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b

    constructor()
    {
        this.restaurantId='';
        this.dishId='';
        this.dishName='';
        this.dishType='';
        this.image=[];
    }
}
