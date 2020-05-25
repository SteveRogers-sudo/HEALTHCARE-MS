import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCentreComponent } from './add-centre/add-centre.component';
import { RemoveCentreComponent } from './remove-centre/remove-centre.component';
import { CentresComponent } from './centres/centres.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth-guard.service';
import { AddTestComponent } from './add-test/add-test.component';
import { RemoveTestComponent } from './remove-test/remove-test.component';
import { MakeAppointmentsComponent } from './make-appointments/make-appointments.component';
import { ApproveAppintmentsComponent } from './approve-appintments/approve-appintments.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';



const routes: Routes = [
  { path:'', component: AddCentreComponent,canActivate:[AuthGuardService]},
  { path:'removecentre', component: CentresComponent,canActivate:[AuthGuardService]},
  { path:'addtest', component: AddTestComponent,canActivate:[AuthGuardService]},
  { path:'removetest', component: RemoveTestComponent,canActivate:[AuthGuardService]},
  { path:'makeappointment', component: MakeAppointmentsComponent,canActivate:[AuthGuardService]},
  { path:'approveappointment', component: ApproveAppintmentsComponent,canActivate:[AuthGuardService]},
  { path:'viewappointment', component: ViewAppointmentsComponent,canActivate:[AuthGuardService]},
  { path: 'login', component: LoginComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
