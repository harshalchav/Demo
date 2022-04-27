import { json } from 'express';

import { Observable } from 'rxjs';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/utility/user';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-otp-verification',
  templateUrl: './otp-verification.component.html',
  styleUrls: ['./otp-verification.component.scss']
})
export class OtpVerificationComponent implements OnInit {
userEmail:string="";
user:User=new User()
otp: string="";
otpCredentials={};
showOtpComponent = true;
@ViewChild("ngOtpInput", { static: false }) ngOtpInput: any; config = { allowNumbersOnly: true, length: 6, isPasswordInput: false, disableAutoFocus: false, placeholder: "*", inputStyles: { width: "50px", height: "50px", }, };

  constructor(private activatedRoute:ActivatedRoute,private rout:Router,private userService: UserService) {

   }


  ngOnInit(): void {

    this.userEmail= this.activatedRoute.snapshot.params['userEmail'];

  }
  onOtpChange(otp:any){
    this.otp=otp;

  }
  goForValidation(){
this.otpCredentials={email:this.userEmail,otp:this.otp}
    this.userService
    .goForValidation(this.otpCredentials).subscribe(data => {
      console.log(data);
      localStorage.setItem("userDetails",JSON.stringify(data))
    },
     error=> console.log(error));
  }


}
