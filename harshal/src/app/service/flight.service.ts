import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Flight } from 'src/utility/flight';
import { catchError,filter } from 'rxjs/operators'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private baseUrl = 'http://localhost:8082';

  constructor(private http:HttpClient) { }



  getFlight(flightId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getFlightById/${flightId}`);
  }

  createFlight(flight: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addFlight`, flight);
  }

  updateFlight(flightId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/updateFlight/${flightId}`, value);
  }

  deleteFlight(flightId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteFlight/${flightId}`, { responseType: 'text' });
  }

  getFlightList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getFlightAll`);
  }
}
