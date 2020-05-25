import { Component, OnInit } from '@angular/core';
import { DiagnosticCentres, HttpClientService } from '../service.service';

@Component({
  selector: 'app-remove-test',
  templateUrl: './remove-test.component.html',
  styleUrls: ['./remove-test.component.css']
})
export class RemoveTestComponent implements OnInit {

  diagnosticCentres:DiagnosticCentres[];

  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit() {
   this.httpClientService.getCentre().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
  }

handleSuccessfulResponse(response)
{
    this.diagnosticCentres=response;
}
deleteTest(diagnosticCentre: DiagnosticCentres): void {
  console.log(this.diagnosticCentres);
  this.httpClientService.deleteTest(diagnosticCentre.testId)
    .subscribe( data => {
      this.diagnosticCentres = this.diagnosticCentres.filter(u => u !== diagnosticCentre);
    })
}

}
