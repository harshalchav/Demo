package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="flight_details")
public class Flight {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int flightId;
       
       @Column(nullable = false)
       private String flightName;
       
       @Column(nullable = false)
       private String source;
       
       @Column(nullable = false)
       private String destination;
       
       @Column(nullable = false)
       private String arrivalTime;
       
       @Column(nullable = false)
       private String departueTime;
       
       @Column(nullable = false)
       private String arrivalDate;
       
       @Column(nullable = false)
       private String departureDate;
       
       @Column(nullable = false)
       private String flightStatus;
       
       @Column(nullable = false)
       private int capacity;
       
       @Column(nullable = false)
       private String refundable;
       
       @Column(nullable = false)
       private int stops;
       
       @Column(nullable = false)
       private int rating;
      
       @ManyToOne( cascade=CascadeType.MERGE )
       @JoinColumn(name = "offerId", nullable = true)
       private Offer offerId;
      
       @Column(nullable = false)
       private int economySeats;
       
       @Column(nullable = false)
       private int bussnessSeats;
       
       @Column(nullable = false)
       private int premiumSeats;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Flight(String flightName, String source, String destination, String arrivalTime, String departueTime,
			String arrivalDate, String departureDate, String flightStatus, int capacity, String refundable, int stops,
			int rating, Offer offerId, int economySeats, int bussnessSeats, int premiumSeats) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departueTime = departueTime;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.flightStatus = flightStatus;
		this.capacity = capacity;
		this.refundable = refundable;
		this.stops = stops;
		this.rating = rating;
		this.offerId = offerId;
		this.economySeats = economySeats;
		this.bussnessSeats = bussnessSeats;
		this.premiumSeats = premiumSeats;
	}
	
	

	public Flight(int flightId, String flightName, String source, String destination, String arrivalTime,
			String departueTime, String arrivalDate, String departureDate, String flightStatus, int capacity,
			String refundable, int stops, int rating, Offer offerId, int economySeats, int bussnessSeats,
			int premiumSeats) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departueTime = departueTime;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.flightStatus = flightStatus;
		this.capacity = capacity;
		this.refundable = refundable;
		this.stops = stops;
		this.rating = rating;
		this.offerId = offerId;
		this.economySeats = economySeats;
		this.bussnessSeats = bussnessSeats;
		this.premiumSeats = premiumSeats;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartueTime() {
		return departueTime;
	}

	public void setDepartueTime(String departueTime) {
		this.departueTime = departueTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getRefundable() {
		return refundable;
	}

	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Offer getOfferId() {
		return offerId;
	}

	public void setOfferId(Offer offerId) {
		this.offerId = offerId;
	}

	public int getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}

	public int getBussnessSeats() {
		return bussnessSeats;
	}

	public void setBussnessSeats(int bussnessSeats) {
		this.bussnessSeats = bussnessSeats;
	}

	public int getPremiumSeats() {
		return premiumSeats;
	}

	public void setPremiumSeats(int premiumSeats) {
		this.premiumSeats = premiumSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", source=" + source + ", destination="
				+ destination + ", arrivalTime=" + arrivalTime + ", departueTime=" + departueTime + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + ", flightStatus=" + flightStatus + ", capacity="
				+ capacity + ", refundable=" + refundable + ", stops=" + stops + ", rating=" + rating + ", offerId="
				+ offerId + ", economySeats=" + economySeats + ", bussnessSeats=" + bussnessSeats + ", premiumSeats="
				+ premiumSeats + "]";
	}
	
	

	
//	
//	public Flight(int flightId, String flightName, String source, String destination, String arrivalTime,
//			String departueTime, String arrivalDate, String departureDate, String flightStatus, int capacity,
//			String refundable, int stops, int rating, int economySeats, int bussnessSeats, int premiumSeats) {
//		super();
//		this.flightId = flightId;
//		this.flightName = flightName;
//		this.source = source;
//		this.destination = destination;
//		this.arrivalTime = arrivalTime;
//		this.departueTime = departueTime;
//		this.arrivalDate = arrivalDate;
//		this.departureDate = departureDate;
//		this.flightStatus = flightStatus;
//		this.capacity = capacity;
//		this.refundable = refundable;
//		this.stops = stops;
//		this.rating = rating;
//		this.economySeats = economySeats;
//		this.bussnessSeats = bussnessSeats;
//		this.premiumSeats = premiumSeats;
//	}
//

	



	







	
	

	
	 
	
       
       
}

