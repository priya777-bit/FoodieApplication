import { Component } from '@angular/core';
import { Image } from 'src/app/favService/domain/image';
import { Restaurant } from 'src/app/favService/domain/restaurant';
import { OrderRequestService } from './service/order-request.service';
import { UserRequestService } from 'src/app/user-request.service';
import { Order } from './domain/order';
import { InventoryRequestService } from 'src/app/food-inventory/service/inventory-request.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css']
})
export class AddToCartComponent {

  order:Order[];
  rest: Restaurant[];
  image:Image[];

  ngOnInit(): void {
    this.orderService.getAllOrder(this.user.mailId).subscribe(data=>{
      this.order = data;
      console.log(data);
      this.order.forEach(r=>{
        this.rest=r.restaurantList;
        this.orderService.orderId=r.orderId;
        //this.restuarent.emit();
        console.log(r.restaurantList);
        this.rest.forEach(data=>{
          console.log(data.restaurantId);
          this.request.getImages(data.restaurantId).subscribe(i=>{
            data.image=i
            data.dishList.forEach(dish=>{
              this.request.getImages(dish.dishId).subscribe(i=>{
                dish.image=i;
              })
            })
          })
        })
      })
      console.log("order" + JSON.stringify(this.order));
    })

  }
  emptyCart(){
    this.orderService.emptyCart(this.orderService.orderId).subscribe(()=>{
      this.toaster.success("Dishes Removed !!!")
    })
  }

  increamentQTY(id:any, quantity:any): void {
    const payload = {
      productId: id,
      quantity,
    };
  }

   constructor(private orderService:OrderRequestService,private user:UserRequestService,private request:InventoryRequestService,private toaster:ToastrService)  {}
}
