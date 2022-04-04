import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';
import { SearchComponent } from './search-Service/search/search.component';
import { DashboardComponent } from './add-Restaurant-Service/dashboard/dashboard.component';
import { ViewRestuarantComponent } from './rest_management/view-restuarant/view-restuarant.component';
import { ViewDishComponent } from './rest_management/view-dish/view-dish.component';
import { AuthguardGuard } from './authguard.guard';
import { ProfileDashboardComponent } from './profile-dashboard/profile-dashboard.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { ShowRestaurantComponent } from './food-inventory/show-restaurant/show-restaurant.component';
import { ShowDishComponent } from './food-inventory/show-dish/show-dish.component';
import { GetAllFavComponent } from './favService/get-all-fav/get-all-fav.component';
import { GetFavDishComponent } from './favService/get-fav-dish/get-fav-dish.component';
import { CanLoadGuard } from './can-load.guard';



const routes: Routes = [
 // {path:'',component:DashboardComponent},
 {path: 'admin',loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),canLoad: [CanLoadGuard]},
  {path:"",component:ShowRestaurantComponent},
  {path:"dishList/:id",component:UserLoginComponent},
  {path:'rest',component:SendRestaurantComponent},
  {path:'dish',component:SendDishComponent},
  // {path:'addRest',component:AddRestComponent},
  // {path:'addDish',component:AddDishComponent},
  {path:'search',component:SearchComponent},
  // {path:'restRequest',component:ViewRestuarantComponent},
  // {path:'dishRequest',component:ViewDishComponent},
  {path:"login",component:UserLoginComponent},
  {path:"register",component:UserRegisterComponent},
  {path:"profile",component:ProfileDashboardComponent,canActivate:[AuthguardGuard]},
  //{path:"showRest",component:ShowRestaurantComponent,children:[],canActivate:[AuthguardGuard]},
  //{path:"showRest/dishList/:id",component:ShowDishComponent}
  {path:"showRest",component:ShowRestaurantComponent,canActivate:[AuthguardGuard]},
  {path:"showRest/dishList/:id",component:ShowDishComponent,canActivate:[AuthguardGuard]},
  {path:'getFav',component:GetAllFavComponent,canActivate:[AuthguardGuard]},
  {path:'getFav/dishList/:id',component:GetFavDishComponent,canActivate:[AuthguardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppRoutingModule { }
