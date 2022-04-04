import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDishComponent } from 'src/app/rest_management/add-dish/add-dish.component';
import { AddRestComponent } from 'src/app/rest_management/add-rest/add-rest.component';
import { ViewDishComponent } from '../rest_management/view-dish/view-dish.component';
import { ViewRestuarantComponent } from '../rest_management/view-restuarant/view-restuarant.component';
import { AdminNavBarComponent } from './admin-nav-bar/admin-nav-bar.component';

const routes: Routes = [
  {
     path:'',
    // component:AdminNavBarComponent,
    children: [
      {path:'addRest',component:AddRestComponent},
      {path:'addDish',component:AddDishComponent},
      {path:'restRequest',component:ViewRestuarantComponent},
      {path:'dishRequest',component:ViewDishComponent},
      {
        path: '',
        redirectTo: 'admin',
        pathMatch: "full"
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
