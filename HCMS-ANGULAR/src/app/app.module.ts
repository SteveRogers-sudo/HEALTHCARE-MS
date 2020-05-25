import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCentreComponent } from './add-centre/add-centre.component';
import { RemoveCentreComponent } from './remove-centre/remove-centre.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CentresComponent } from './centres/centres.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RemoveTestComponent } from './remove-test/remove-test.component';
import { AddTestComponent } from './add-test/add-test.component';
import { ApproveAppintmentsComponent } from './approve-appintments/approve-appintments.component';
import { MakeAppointmentsComponent } from './make-appointments/make-appointments.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCentreComponent,
    RemoveCentreComponent,
    CentresComponent,
    HeaderComponent,
    LoginComponent,
    RemoveTestComponent,
    AddTestComponent,
    ApproveAppintmentsComponent,
    MakeAppointmentsComponent,
    ViewAppointmentsComponent,
    AddAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
