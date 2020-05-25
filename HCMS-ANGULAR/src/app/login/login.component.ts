import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    public loginservice: AuthenticationService) { }

  ngOnInit() {
  }
  checkLogin() {
    if (this.password == "" || this.username== "")                        
    { 
        window.alert("Please enter your Username and password"); 
        return false; 
    } 
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } 
    else if(this.loginservice.authenticateUser(this.username, this.password)
    ) {
      this.router.navigate(['/makeappointment'])
      this.invalidLogin = false
    }else
      this.invalidLogin = true
  }
  

}
