package com.cybage.model;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="offer_details")
public class Offer {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int offerId;
       
       @Column(nullable = false)
       private String validity;
       
       @Column(nullable = false)
       private double discount;
       
       @Column(nullable = false)
       private String limitedOffer;
       
       @Column(nullable = false)
       private String offerCode;
       
       @Column(nullable = false)
       private int noOfUseAllowed;
    

       
	

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Offer(int offerId, String validity, double discount, String limitedOffer, String offerCode,
			int noOfUseAllowed) {
		super();
		this.offerId = offerId;
		this.validity = validity;
		this.discount = discount;
		this.limitedOffer = limitedOffer;
		this.offerCode = offerCode;
		this.noOfUseAllowed = noOfUseAllowed;
		}




	public Offer(String validity, double discount, String limitedOffer, String offerCode, int noOfUseAllowed) {
		super();
		this.validity = validity;
		this.discount = discount;
		this.limitedOffer = limitedOffer;
		this.offerCode = offerCode;
		this.noOfUseAllowed = noOfUseAllowed;
	}
	
	
//	public Offer(int offerId, String validity, double discount, String limitedOffer, String offerCode,
//			int noOfUseAllowed, List<Flight> flight) {
//		super();
//		this.offerId = offerId;
//		this.validity = validity;
//		this.discount = discount;
//		this.limitedOffer = limitedOffer;
//		this.offerCode = offerCode;
//		this.noOfUseAllowed = noOfUseAllowed;
//		this.flight = flight;
//	}
//	
//	
//
//
//	public Offer(String validity, double discount, String limitedOffer, String offerCode, int noOfUseAllowed,
//		List<Flight> flight) {
//	super();
//	this.validity = validity;
//	this.discount = discount;
//	this.limitedOffer = limitedOffer;
//	this.offerCode = offerCode;
//	this.noOfUseAllowed = noOfUseAllowed;
//	this.flight = flight;
//}


	public int getOfferId() {
		return offerId;
	}
	

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getLimitedOffer() {
		return limitedOffer;
	}


	public void setLimitedOffer(String limitedOffer) {
		this.limitedOffer = limitedOffer;
	}


	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public int getNoOfUseAllowed() {
		return noOfUseAllowed;
	}
	public void setNoOfUseAllowed(int noOfUseAllowed) {
		this.noOfUseAllowed = noOfUseAllowed;
	}


	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", validity=" + validity + ", discount=" + discount + ", limitedOffer="
				+ limitedOffer + ", offerCode=" + offerCode + ", noOfUseAllowed=" + noOfUseAllowed + "]";
	}
    
	

//	public List<Flight> getFlight() {
//		return flight;
//	}
//
//
//	public void setFlight(List<Flight> flight) {
//		this.flight = flight;
//	}


//	@Override
//	public String toString() {
//		return "Offer [offerId=" + offerId + ", validity=" + validity + ", discount=" + discount + ", limitedOffer="
//				+ limitedOffer + ", offerCode=" + offerCode + ", noOfUseAllowed=" + noOfUseAllowed + ", flight="
//				+ flight + "]";
//	}

	

	
 
        


}
