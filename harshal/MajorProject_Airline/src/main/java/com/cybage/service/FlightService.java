package com.cybage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dto.AddFlightDto;
import com.cybage.model.Flight;
import com.cybage.model.Offer;
import com.cybage.repository.FlightRepository;
import com.cybage.repository.OfferRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	OfferRepository offerRepository;
	
	
	public void addFlight(AddFlightDto flightDto) {
		System.out.println(flightDto);
	Offer offer=offerRepository.findById(flightDto.getOfferId()).orElse(null);
	Flight flight = new Flight();
	BeanUtils.copyProperties(flightDto, flight);
	flight.setOfferId(offer);
		flightRepository.save(flight);
		
	}

	public List<Flight> getFlight() {
		return flightRepository.findAll();
		
	}
	public Flight getFlightById(int flightId) {
		 return flightRepository.findById(flightId).orElse(null);
	 }
	
	public void deleteFlightById(int flightId) {
		flightRepository.deleteById(flightId);
	 }

	public void updateFlight(int flightId,Flight flight) {
		flightRepository.save(flight);
	
	}
}
