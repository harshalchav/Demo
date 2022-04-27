import { Component, OnInit } from '@angular/core';
import { User } from 'src/utility/user';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {
  user: User = new User();
  submitted = false;

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }

  newFlight(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService
    .registerUser(this.user).subscribe(data => {
      console.log(data)
      this.user = new User();
      this.gotoList();
    }, 
     error=> console.log(error));
  }

  onSubmit(registerUserForm: NgForm) {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/getFlightAll']);
  }
}
