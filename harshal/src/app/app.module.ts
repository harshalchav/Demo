import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FlightListComponent } from './components/flight/flight-list/flight-list.component';
import { CreateFlightComponent } from './components/flight/create-flight/create-flight.component';
import { FlightDetailsComponent } from './components/flight/flight-details/flight-details.component';

import { RegisterUserComponent } from './components/user/register-user/register-user.component';
import { LoginComponent } from './components/user/login/login.component';
import { UpdateFlightComponent } from './components/flight/update-flight/update-flight.component';
import { OtpVerificationComponent } from './components/otp-verification/otp-verification.component';
import { NgOtpInputModule } from 'ng-otp-input';



@NgModule({
  declarations: [
    AppComponent,
    FlightListComponent,
    CreateFlightComponent,
    FlightDetailsComponent,
   UpdateFlightComponent,
   RegisterUserComponent,
   LoginComponent,
   OtpVerificationComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,NgOtpInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
