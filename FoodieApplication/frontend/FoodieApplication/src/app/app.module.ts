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
import { ViewAllComponent } from './rest_management/view-all/view-all.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { MatRadioModule } from '@angular/material/radio';
import { SendRestaurantComponent } from './add-Restaurant-Service/send-restaurant/send-restaurant.component';
import { SendDishComponent } from './add-Restaurant-Service/send-dish/send-dish.component';

@NgModule({
  declarations: [
    AppComponent,
    AddRestComponent,
    AddDishComponent,
    NavbarComponent,
    ViewAllComponent,
    SendRestaurantComponent,
    SendDishComponent,
    UserRegisterComponent,
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
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas:[NO_ERRORS_SCHEMA,CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
