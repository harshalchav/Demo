package com.cybage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.RecordNotFoundException;
import com.cybage.model.Offer;
import com.cybage.service.OfferService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OfferController {

	@Autowired
	OfferService offerService;
	
	@PostMapping("/addOffer")
	public ResponseEntity<String> addOffer(@RequestBody Offer offer)
	{
		offerService.addOffer(offer);
		return new ResponseEntity<>("Offer Added Succesfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/getOfferAll")
	public ResponseEntity<List<Offer> >getOffer()
	{
		List<Offer> offerList = offerService.getOffer();
		return new ResponseEntity<List<Offer>>(offerList,HttpStatus.OK);
	}
	
	@GetMapping("/getOfferById/{id}")
	public ResponseEntity<Offer> getOfferById(@PathVariable int offerId) throws RecordNotFoundException
	{
		Offer offer = offerService.getOfferById(offerId);
		
		if(offer==null)
		{
			throw new RecordNotFoundException("offer not Found");
		}
		return new ResponseEntity<Offer>(offer,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteOffer/{id}")
	public ResponseEntity<String> deleteOffer(@PathVariable int id)
	{
		offerService.deleteOfferById(id);
		return new ResponseEntity<>("Offer deleted Succesfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateOffer/{offerId}")
	public ResponseEntity<String> updateOffer(@PathVariable int offerId,@RequestBody Offer offer)
	{
		offerService.updateOffer( offerId, offer);
		return new ResponseEntity<String>("Offer updated successfuly",HttpStatus.OK);
	}
	
}
