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
@Table(name="feedback")
public class Feedback {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int feedbackId;
       
       @Column(nullable = false)
       private String remarks;
       
       @Column(nullable = false)
       private String date;
       
       @OneToOne(cascade = CascadeType.MERGE)
 	   @JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
       private BookingMaster bookingId;
       
       @Column(nullable = false)
       private int rating;
	
       
       public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Feedback(int feedbackId, String remarks, String date, BookingMaster bookingId, int rating) {
		super();
		this.feedbackId = feedbackId;
		this.remarks = remarks;
		this.date = date;
		this.bookingId = bookingId;
		this.rating = rating;
	}
	
	


	public Feedback(String remarks, String date, BookingMaster bookingId, int rating) {
		super();
		this.remarks = remarks;
		this.date = date;
		this.bookingId = bookingId;
		this.rating = rating;
	}


	public int getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public BookingMaster getBookingId() {
		return bookingId;
	}


	public void setBookingId(BookingMaster bookingId) {
		this.bookingId = bookingId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", remarks=" + remarks + ", date=" + date + ", bookingId="
				+ bookingId + ", rating=" + rating + "]";
	}

	
       
       

}
