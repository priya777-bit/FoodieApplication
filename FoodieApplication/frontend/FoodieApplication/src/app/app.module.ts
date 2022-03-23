import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
<<<<<<< HEAD
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
import { ViewAllComponent } from './rest_management/view-all/view-all.component';
=======
import { UserRegisterComponent } from './user-register/user-register.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ReactiveFormsModule } from '@angular/forms';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';

import {HttpClientModule} from '@angular/common/http';
>>>>>>> ba7337d5ed5706a82ca52bdf42fef33629d96650

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    AddRestComponent,
    AddDishComponent,
    NavbarComponent,
    ViewAllComponent
=======
<<<<<<< HEAD
    SendRestaurantComponent,
    SendDishComponent
=======
    UserRegisterComponent
>>>>>>> 9ba26d499f4551cb43dc21cf2b336e06e10c97bf
>>>>>>> ba7337d5ed5706a82ca52bdf42fef33629d96650
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
<<<<<<< HEAD
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    HttpClientModule,
    MatSelectModule


=======
<<<<<<< HEAD
=======
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
>>>>>>> 9ba26d499f4551cb43dc21cf2b336e06e10c97bf
    ReactiveFormsModule,
    HttpClientModule
>>>>>>> ba7337d5ed5706a82ca52bdf42fef33629d96650
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas:[NO_ERRORS_SCHEMA]
})
export class AppModule { }
