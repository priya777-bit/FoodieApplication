import { Restaurant } from "./restaurant";

export class Favourite {
    favouriteId: string;
    userMailId: string;
    restaurantList: Array<Restaurant>;

    constructor(){
        this.favouriteId='';
        this.userMailId='';
        this.restaurantList=[];
    }
}
