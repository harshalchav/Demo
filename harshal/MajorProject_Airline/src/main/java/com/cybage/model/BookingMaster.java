package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking_master")
public class BookingMaster {
	
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int bookingId;
       
       @ManyToOne(cascade = CascadeType.ALL)
       @JoinColumn(name = "userId")
       private User userId;
       
       @ManyToOne(cascade = CascadeType.ALL)
       @JoinColumn(name = "flightId")
       private Flight flightId;
       
       @Column(nullable = false)
       private String status;

	public BookingMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingMaster(int bookingId, User userId, Flight flightId, String status) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.status = status;
	}
	
	

	public BookingMaster(User userId, Flight flightId, String status) {
		super();
		this.userId = userId;
		this.flightId = flightId;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Flight getFlightId() {
		return flightId;
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingMaster [bookingId=" + bookingId + ", userId=" + userId + ", flightId=" + flightId + ", status="
				+ status + "]";
	}

       
	
}
