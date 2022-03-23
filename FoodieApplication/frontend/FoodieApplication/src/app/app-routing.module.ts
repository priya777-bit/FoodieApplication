import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';

const routes: Routes = [
  {path:'',component:SendRestaurantComponent},
  {path:'dish',component:SendDishComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
