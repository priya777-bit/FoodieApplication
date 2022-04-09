import { Restaurant } from "src/app/rest_management/domain/restaurant";
export class Order {
    
    orderId: string;
    userMailId: string;
    quantity:any;
    restaurantList: Array<Restaurant>;

    constructor(){
        this.orderId='';
        this.userMailId='';
        this.restaurantList=[];
    }

}
