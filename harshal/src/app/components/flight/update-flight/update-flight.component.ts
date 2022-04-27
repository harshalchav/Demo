import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/utility/flight';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';


@Component({
  selector: 'app-update-component',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.scss']
})
export class UpdateFlightComponent implements OnInit {

  flightId!: number;
  flight!: Flight;

  constructor(private route: ActivatedRoute,private router: Router,
    private flightService: FlightService) { }

  ngOnInit(): void {
    this.flight = new Flight();

    this.flightId = this.route.snapshot.params['flightId'];

    this.flightService.getFlight(this.flightId)
      .subscribe(data => {
        console.log(data)
        this.flight = data;
      }, error => console.log(error));
  }

  updateFlight() {
    this.flightService.updateFlight(this.flightId, this.flight)
      .subscribe(data => {
        console.log(data);
        this.flight = new Flight();
        this.gotoList();
      },error => console.log(error));
  }

  onSubmit() {
    this.updateFlight();
  }

  gotoList() {
    this.router.navigate(['/getFlightAll']);
  }
}
