import { Component, OnInit } from '@angular/core';
import { DiagnosticCentres,HttpClientService, Test, DiagnosticCentre } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {
  diagnosticCentres: DiagnosticCentre[];
  centre: DiagnosticCentres = new DiagnosticCentres("","","");
  test: Test = new Test("","");
  centersList: any;
  testList: any;
  
  constructor(
    private httpClientService: HttpClientService, 
    private router : Router) { }   

  ngOnInit(): void {
    //get all centres
    this.httpClientService.getCenterNames().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }
  handleSuccessfulResponse(response)
{
    this.diagnosticCentres=response;
}
  // onSelect(centre: DiagnosticCentres): {
  //   this.selectedCenterId = centre.centreId;
  //   this.httpClientService.displayTests(this.selectedCenterId).subscribe(
  //     response => this.handleSuccessfulResponseTest(response),
  //   );
  //   this.app.center = user.centreName;

  // }
  // getCenterNames(): any {

  //   let cntname = new Array();
  
  //  return  this.httpClientService.getCenterNames()
  //   .subscribe( data => {data.forEach(element => {
  //       cntname.push(element.centreName);
  //     });
  //     this.centersList = cntname;
  //   });
  // }
}
