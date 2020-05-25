import { Component, OnInit } from '@angular/core';
import { Appointment, Test, DiagnosticCentre, HttpClientService } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-approve-appintments',
  templateUrl: './approve-appintments.component.html',
  styleUrls: ['./approve-appintments.component.css']
})
export class ApproveAppintmentsComponent implements OnInit {

  app:Appointment;
  test:Test;
  center:DiagnosticCentre;
  status:string;
  appointment:string;

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


  onClick(app){
    console.log(app);
    app.approved=true;
    console.log(app);
    this.appService.approveAppointment(app).subscribe((data) =>this.appointment = data);

  }

statusCheck(){
  if (this.app.approved=false){
    status="awaiting confirmation"
}else {
status="Appointment confirmed!"
}
}

}
