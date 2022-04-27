import { Component, OnInit, Input } from '@angular/core';
import { FlightService } from 'src/app/service/flight.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Flight } from 'src/utility/flight';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.scss']
})
export class FlightDetailsComponent implements OnInit {

  flightId!: number;
  flight!: Flight;

  constructor(private route: ActivatedRoute,private flightService: FlightService,
    private router: Router) { 

    }

  ngOnInit(): void {
    this.flight = new Flight();

    this.flightId = this.route.snapshot.params['flightId'];
    
    this.flightService.getFlight(this.flightId)
      .subscribe(data => {
        console.log(data)
        this.flight = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['/updateFlight/${flightId}']);
  }

}
