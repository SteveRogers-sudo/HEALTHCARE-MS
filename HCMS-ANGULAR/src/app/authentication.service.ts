import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  authenticate(username, password) {
    if (username === "admin" && password === "admin") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }
  //Added
  authenticateUser(username, password) {
    if (username === "user" && password === "user") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(user != null)
    return (user != null)
  }
  //Added
  isUsersLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(user != null)
    if (user == 'admin') {
      return 'admin'
    }
    else if(user == 'user'){
      return 'user'
    }
  }

}