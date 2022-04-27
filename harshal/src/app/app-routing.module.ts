import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightListComponent } from './components/flight/flight-list/flight-list.component';
import { CreateFlightComponent } from './components/flight/create-flight/create-flight.component';
import { FlightDetailsComponent } from './components/flight/flight-details/flight-details.component';

import { RegisterUserComponent } from './components/user/register-user/register-user.component';
import { UpdateFlightComponent } from './components/flight/update-flight/update-flight.component';
import { LoginComponent } from './components/user/login/login.component';
import { OtpVerificationComponent } from './components/otp-verification/otp-verification.component';

const routes: Routes = [
  { path: '', redirectTo: 'flights', pathMatch: 'full' },
  { path: 'getFlightAll', component: FlightListComponent },
  { path: 'addFlight', component: CreateFlightComponent },
  { path: 'getFlightById/:flightId', component: FlightDetailsComponent },
  { path: 'details/:flightId', component: UpdateFlightComponent },
  { path: 'registerUser', component: RegisterUserComponent },
  { path: 'login', component: LoginComponent },
  {
    path:'otpVerification/:userEmail',component:OtpVerificationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
