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
@Table(name="payment")
public class Payment {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PaymentId;
	 
	@Column(nullable = false)
	private int CardNo;
	
	@Column(nullable = false)
	private String CardType;
	
	@Column(nullable = false)
	private String PaymentStatus;  
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private BookingMaster bookingId;
	
	@Column(nullable = false)
	private double transactionAmount;
	
	public Payment(int paymentId, int cardNo, String cardType, String paymentStatus, BookingMaster bookingId,
			double transactionAmount) {
		super();
		PaymentId = paymentId;
		CardNo = cardNo;
		CardType = cardType;
		PaymentStatus = paymentStatus;
		this.bookingId = bookingId;
		this.transactionAmount = transactionAmount;
	}
	
	

	public Payment(int cardNo, String cardType, String paymentStatus, BookingMaster bookingId,
			double transactionAmount) {
		super();
		CardNo = cardNo;
		CardType = cardType;
		PaymentStatus = paymentStatus;
		this.bookingId = bookingId;
		this.transactionAmount = transactionAmount;
	}



	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}

	public int getCardNo() {
		return CardNo;
	}

	public void setCardNo(int cardNo) {
		CardNo = cardNo;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public BookingMaster getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingMaster bookingId) {
		this.bookingId = bookingId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Payment [PaymentId=" + PaymentId + ", CardNo=" + CardNo + ", CardType=" + CardType + ", PaymentStatus="
				+ PaymentStatus + ", bookingId=" + bookingId + ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	

}
