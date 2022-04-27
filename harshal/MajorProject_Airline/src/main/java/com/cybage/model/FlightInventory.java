package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight_inventory")
public class FlightInventory {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int flightInventoryId;
      
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "flightId", referencedColumnName = "flightId")
      private Flight flightId;
	  
	  @Column(nullable = false)
      private int availableseats;
	  
	  @Column(nullable = false)
      private int bookedSeats;
      
      
      
	public FlightInventory() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FlightInventory(int flightInventoryId, Flight flightId, int availableseats, int bookedSeats) {
		super();
		this.flightInventoryId = flightInventoryId;
		this.flightId = flightId;
		this.availableseats = availableseats;
		this.bookedSeats = bookedSeats;
	}
	
	


	public FlightInventory(Flight flightId, int availableseats, int bookedSeats) {
		super();
		this.flightId = flightId;
		this.availableseats = availableseats;
		this.bookedSeats = bookedSeats;
	}



	public int getFlightInventoryId() {
		return flightInventoryId;
	}

	public void setFlightInventoryId(int flightInventoryId) {
		this.flightInventoryId = flightInventoryId;
	}

	public Flight getFlightId() {
		return flightId;
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}
	
	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}



	@Override
	public String toString() {
		return "FlightInventory [flightInventoryId=" + flightInventoryId + ", flightId=" + flightId
				+ ", availableseats=" + availableseats + ", bookedSeats=" + bookedSeats + "]";
	}
	
	

      
      

	     

}
