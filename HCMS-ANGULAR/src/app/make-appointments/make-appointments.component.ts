import { Component, OnInit } from '@angular/core';
import { Test, DiagnosticCentre, Appointment, HttpClientService, DiagnosticCentres } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-make-appointments',
  templateUrl: './make-appointments.component.html',
  styleUrls: ['./make-appointments.component.css']
})
export class MakeAppointmentsComponent implements OnInit {

  selectedTest: Test;
  test_details: any
  checkTests: boolean = false
  centre: DiagnosticCentre
  tests: Test
  selectedCenterId: string;
  selectedDate: string
  dateCheck: boolean = false;
  userIdCheck: boolean = false;
  appointment: string;
  confirmation: boolean;

  user: DiagnosticCentres = new DiagnosticCentres("","","");
  tester: Test = new Test("", "");

  app: Appointment = new Appointment("", false, "", "", "")

  constructor(private httpClientService: HttpClientService, 
    private router: Router) { }

  ngOnInit(): void {
    // this.getAllCenters();
    this.httpClientService.displayCenters().subscribe(
      response => this.handleSuccessfulResponseCenter(response));
  }
  handleSuccessfulResponseCenter(response) {
    this.centre = response;
  }
  // getAllCenters() {
  //   //getting data of all Centers

  //   this.httpClientService.displayCenters().subscribe(
  //     response => this.handleSuccessfulResponseCenter(response),
  //   );
  // }
  onSelect(user: DiagnosticCentre) {
    this.selectedCenterId = user.centreId;
    this.httpClientService.displayTests(this.selectedCenterId).subscribe(
      response => this.handleSuccessfulResponseTest(response),
    );
    this.app.center = user.centreName;
  }

  handleSuccessfulResponseTest(response) {
    this.tests = response;
  }

  onTest(tester) {
    this.dateCheck = true;
    this.app.test = tester.testName;
  }

  onDate() {
    if (this.app.dateTimeSlot == "") {
      window.alert("Please select a valid date and time");

    } else {
      this.userIdCheck = true;
      this.app.approved = false;
    }
  }

  onConfirm() {
    console.log(this.app.userId.slice(0,1))
    console.log(this.app.userId.length)
    if (this.app.userId == "" || this.app.userId.length != 10 || this.app.userId.slice(0,1) != '9') {
      window.alert("please enter a valid Phone number")
    }
    else { 
      this.httpClientService.makeAppointment(this.app)
        .subscribe(data => {
          if (data) {
            this.dateCheck = false;
            this.userIdCheck = false;
            this.confirmation = true;
            alert("Appointment successfull!");
            alert("Check view appointments for your appointment status")
          } else {
            alert("user ID already exists!! This user already made an appointment");
          }
        });
    }
  }

 
  


}
