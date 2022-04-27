import { Component, OnInit } from '@angular/core';
import { FlightService } from 'src/app/service/flight.service';
import { Router } from '@angular/router';
import { Flight } from 'src/utility/flight';
import { Observable } from 'rxjs';
import { json } from 'express';


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.scss']
})
export class FlightListComponent implements OnInit {
  flights: any;


  constructor(private flightService: FlightService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.flightService.getFlightList().subscribe(data => {
      console.log(data);
      this.flights=data;
    }
);

   // console.log(this.flights);
    // this.flights.forEach(element => {
    //   console.log(element)
    // });
   
  }


  deleteFlight(id: number) {
    this.flightService.deleteFlight(id)
      .subscribe(data => {
          console.log(data);
          this.reloadData();

        },
        error => console.log(error));
  }

  FlightDetails(id: number){
    this.router.navigate(['details', id]);
  }
  

}
