import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Login } from 'src/utility/login';
import { User } from 'src/utility/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  data1:any;
  submitted = false;

  constructor(private userService: UserService,
    private router: Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  newFlight(): void {
    this.submitted = false;
    this.user = new User();
  }

  loginCheck() {
    this.userService
    .loginCheck(this.user).subscribe(data => {
      console.log(data);
      this.data1=data;
      this.gotoList();
    },
     error=> console.log(error));
  }

  public resolved(captchaResponse: string) { 
    console.log(`Resolved captcha with response: ${captchaResponse}`); // Write your logic here about once human verified what action you want to perform 
    }

  onSubmit(loginUserForm: NgForm) {
    this.submitted = true;
    this.loginCheck();
  }

  gotoList() {
    this.router.navigate(['/otpVerification',this.data1.userEmail]);
  }
}

