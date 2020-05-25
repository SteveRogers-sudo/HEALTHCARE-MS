import { Component, OnInit } from '@angular/core';
import { Appointment, Test, DiagnosticCentre, HttpClientService } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css']
})
export class ViewAppointmentsComponent implements OnInit {
  app:Appointment;
  test:Test;
  center:DiagnosticCentre;
  status:string;

  constructor(private appService:HttpClientService,private router: Router) { }

  ngOnInit(): void {
    this.getAllAppointments();
  }


  getAllAppointments() {
    //getting data of all appointments

    console.log(this.app)
    this.appService.displayAppointments().subscribe(
     response =>this.handleSuccessfulResponseCenter(response),
    );
  }
  handleSuccessfulResponseCenter(response)
  {
     this.app=response;
  }

statusCheck(){
  if (this.app.approved=false){
    status="awaiting confirmation"
}else {
status="Your Appointment is scheduled!"
}
}


}
