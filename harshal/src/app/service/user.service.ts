import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8082';

  constructor(private http:HttpClient) { }

  registerUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/registerUser`, user);
  }

  loginCheck(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/checklogin`, user);
  }


  goForValidation(otpCredentials:object):Observable<object>{
    return this.http.post(`${this.baseUrl}/checkOtpValidation`, otpCredentials);

  }

}
