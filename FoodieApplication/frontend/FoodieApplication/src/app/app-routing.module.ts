import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { ViewAllComponent } from './rest_management/view-all/view-all.component';

const routes: Routes = [
  {path:'addRest',component:AddRestComponent},
  {path:'addDish',component:AddDishComponent},
  {path:'find',component:ViewAllComponent}
=======
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';

const routes: Routes = [
  {path:'',component:SendRestaurantComponent},
  {path:'dish',component:SendDishComponent}
>>>>>>> ba7337d5ed5706a82ca52bdf42fef33629d96650
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
