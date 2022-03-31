import { Restaurant } from "src/app/rest_management/domain/restaurant";


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
