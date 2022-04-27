package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Flight;
import com.cybage.model.Offer;
import com.cybage.repository.FlightRepository;
import com.cybage.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	public void addOffer(Offer offer) {
		offerRepository.save(offer);
		
	}

	public List<Offer> getOffer() {
		return offerRepository.findAll();
		
	}
	public Offer getOfferById(int offerId) {
		 return offerRepository.findById(offerId).orElse(null);
	 }
	
	public void deleteOfferById(int offerId) {
		List<Flight> flightList=flightRepository.FindAllByOffer(offerId);
		for (Flight flight : flightList) {
			flight.setOfferId(null);
			
		}
		offerRepository.deleteById(offerId);
	 }

	public void updateOffer(int offerId,Offer offer) {
		offerRepository.save(offer);
	
	}
}
