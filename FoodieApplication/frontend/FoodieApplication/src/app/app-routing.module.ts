import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { ViewAllComponent } from './rest_management/view-all/view-all.component';

const routes: Routes = [
  {path:'addRest',component:AddRestComponent},
  {path:'addDish',component:AddDishComponent},
  {path:'find',component:ViewAllComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
