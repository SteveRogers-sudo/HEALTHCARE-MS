import { Component, OnInit } from '@angular/core';
import { HttpClientService, DiagnosticCentre } from '../service.service';
@Component({
  selector: 'app-remove-centre',
  templateUrl: './remove-centre.component.html',
  styleUrls: ['./remove-centre.component.css']
})
export class RemoveCentreComponent implements OnInit {
  user: DiagnosticCentre = new DiagnosticCentre("", "", []);
  diagnosticCentres: DiagnosticCentre[];

  constructor(
    private httpClientService: HttpClientService
  ) { }
  ngOnInit() {
  }
  deletecentre(user: DiagnosticCentre): void {
    if (this.user.centreId == "") {
      window.alert("Please enter CentreId");
    }
    else {
      this.httpClientService.deletecentre(user.centreId)
        .subscribe(data => {
          alert("Center removed successfully.");
        })
    }
  }
}
