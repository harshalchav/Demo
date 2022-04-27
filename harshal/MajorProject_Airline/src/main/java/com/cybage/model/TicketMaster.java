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
@Table(name="ticket_master")
public class TicketMaster {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int ticketId;
       
       @Column(nullable = false)
       private int seatNo;
       
       @ManyToOne(cascade = CascadeType.ALL)
       @JoinColumn(name = "bookingId")
       private BookingMaster bookingId; 
       
       @Column(nullable = false)
       private String passangerName;
       
       @Column(nullable = false)
       private int age;
       
       @Column(nullable = false)
       private String gender;
       
	public TicketMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketMaster(int ticketId, int seatNo, BookingMaster bookingId, String passangerName, int age,
			String gender) {
		super();
		this.ticketId = ticketId;
		this.seatNo = seatNo;
		this.bookingId = bookingId;
		this.passangerName = passangerName;
		this.age = age;
		this.gender = gender;
	}
	
	

	public TicketMaster(int seatNo, BookingMaster bookingId, String passangerName, int age, String gender) {
		super();
		this.seatNo = seatNo;
		this.bookingId = bookingId;
		this.passangerName = passangerName;
		this.age = age;
		this.gender = gender;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public BookingMaster getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingMaster bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "TicketMaster [ticketId=" + ticketId + ", seatNo=" + seatNo + ", bookingId=" + bookingId
				+ ", passangerName=" + passangerName + ", age=" + age + ", gender=" + gender + "]";
	}

       

}
