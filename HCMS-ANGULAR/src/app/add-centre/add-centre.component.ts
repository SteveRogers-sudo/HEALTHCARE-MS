import { Component, OnInit } from '@angular/core';
import { HttpClientService, DiagnosticCentre } from '../service.service';
@Component({
  selector: 'app-add-centre',
  templateUrl: './add-centre.component.html',
  styleUrls: ['./add-centre.component.css']
})
export class AddCentreComponent implements OnInit {
  result: any;
  user: DiagnosticCentre = new DiagnosticCentre("", "", []);
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }
  createcentre(): void {
    if (this.user.centreName == "") {
      window.alert("Please enter CentreName");
    }
    else {
      this.httpClientService.createcentre(this.user)
        .subscribe(data => {
          if (data) {
            alert("Centre added successfully.");
          } else {
            alert("Centre Name Already exist!!");
          }
        });
    }
  };


}
