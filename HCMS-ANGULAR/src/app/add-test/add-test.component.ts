import { Component, OnInit } from '@angular/core';
import { HttpClientService, DiagnosticCentres } from '../service.service';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  user: DiagnosticCentres = new DiagnosticCentres("","","");
  centersList: any;
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(){
     
     this.getCenterNames();
  }
  createTest(): void {
    if(this.user.testName=="" || this.user.centreName==""){
      alert("Test Name and Center Name can't be empty")
    }
else{
    this.httpClientService.createTest(this.user)
        .subscribe(data => {
          if(data){
          alert("added successfully.");
          }else{
            alert("Test Already exist!!");
          }
        });

  };
  
  }
  getCenterNames(): any {

    let cntname = new Array();
  
   return  this.httpClientService.getCenterNames()
    .subscribe( data => {
      data.forEach(element => {
        cntname.push(element.centreName);
      });
      this.centersList = cntname;
    });
  }

}
