import { Component, OnInit } from '@angular/core';
import { DiagnosticCentre, HttpClientService } from '../service.service';

@Component({
  selector: 'app-centres',
  templateUrl: './centres.component.html',
  styleUrls: ['./centres.component.css']
})
export class CentresComponent implements OnInit {
  diagnosticCentres:DiagnosticCentre[];
  
  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getCentres().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
  }

handleSuccessfulResponse(response)
{
    this.diagnosticCentres=response;
}
deleteCentre(diagnosticCentre: DiagnosticCentre): void {
  this.httpClientService.deletecentre(diagnosticCentre.centreId)
    .subscribe( data => {
      this.diagnosticCentres = this.diagnosticCentres.filter(u => u !== diagnosticCentre);
    })
}
}
