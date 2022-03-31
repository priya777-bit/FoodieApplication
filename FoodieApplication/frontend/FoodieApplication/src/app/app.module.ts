import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { AddRestComponent } from './rest_management/add-rest/add-rest.component';
import { AddDishComponent } from './rest_management/add-dish/add-dish.component';
import {MatSelectModule} from '@angular/material/select';
import { NavbarComponent } from './rest_management/navbar/navbar.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { MatRadioModule } from '@angular/material/radio';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';
import { DashboardComponent } from './add-Restaurant-Service/dashboard/dashboard.component';
import { SearchComponent } from './search-Service/search/search.component';
import { NavComponent } from './search-Service/nav/nav.component';
import { ViewDishComponent } from './rest_management/view-dish/view-dish.component';
import { ViewRestuarantComponent } from './rest_management/view-restuarant/view-restuarant.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { LayoutModule } from '@angular/cdk/layout';
import { UserLoginComponent } from './user-login/user-login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { ProfileDashboardComponent } from './profile-dashboard/profile-dashboard.component';
import { ShowRestaurantComponent } from './food-inventory/show-restaurant/show-restaurant.component';
import { ShowDishComponent } from './food-inventory/show-dish/show-dish.component';
import { GetAllFavComponent } from './favService/get-all-fav/get-all-fav.component';
<<<<<<< HEAD
=======
import { AddFavComponent } from './favService/add-fav/add-fav.component';
>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910

@NgModule({
  declarations: [
    AppComponent,
    AddRestComponent,
    AddDishComponent,
    NavbarComponent,
    SendRestaurantComponent,
    SendDishComponent,
    UserRegisterComponent,
    DashboardComponent,
    SearchComponent,
    NavComponent,
    ViewDishComponent,
    ViewRestuarantComponent,
    UserLoginComponent,
    ProfileDashboardComponent,
    NavBarComponent,
    ShowRestaurantComponent,
    ShowDishComponent,
<<<<<<< HEAD
    GetAllFavComponent
=======
    GetAllFavComponent,
    ShowDishComponent,
    AddFavComponent


>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    HttpClientModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    HttpClientModule,
    MatGridListModule,
    MatMenuModule,
    LayoutModule,
    MatSidenavModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas:[NO_ERRORS_SCHEMA,CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
