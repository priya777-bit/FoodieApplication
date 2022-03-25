import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { ViewAllComponent } from './rest_management/view-all/view-all.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';

const routes: Routes = [
<<<<<<< HEAD
  {path:'',component:SendRestaurantComponent},
  {path:'dish',component:SendDishComponent},
  // {path:'addRest',component:AddRestComponent},
  // {path:'addDish',component:AddDishComponent},
  // {path:'find',component:ViewAllComponent}
=======
  // {path:'',component:SendRestaurantComponent},
  // {path:'dish',component:SendDishComponent},
  {path:'addRest',component:AddRestComponent},
  {path:'addDish',component:AddDishComponent},
  {path:'find',component:ViewAllComponent}


>>>>>>> 9c4ba12d7f397fea4d823ba6e6d7d0c5084800bf
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppRoutingModule { }
