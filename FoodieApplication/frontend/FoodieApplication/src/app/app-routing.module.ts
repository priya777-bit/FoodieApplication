import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';
import { ViewRestuarantComponent } from './rest_management/view-restuarant/view-restuarant.component';
import { ViewDishComponent } from './rest_management/view-dish/view-dish.component';

const routes: Routes = [
  // {path:'',component:SendRestaurantComponent},
  // {path:'dish',component:SendDishComponent},
  {path:'addRest',component:AddRestComponent},
  {path:'addDish',component:AddDishComponent},
  {path:'restRequest',component:ViewRestuarantComponent},
  {path:'dishRequest',component:ViewDishComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppRoutingModule { }
