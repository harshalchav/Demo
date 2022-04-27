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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.AddFlightDto;
import com.cybage.exception.RecordNotFoundException;
import com.cybage.model.Flight;
import com.cybage.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody AddFlightDto flightDto)
	{
		flightService.addFlight(flightDto);
		return new ResponseEntity<>("Flight Added Succesfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/getFlightAll")
	public ResponseEntity<List<Flight> >getFlight()
	{
		List<Flight> flightList = flightService.getFlight();
		for (Flight flight : flightList) {
			System.out.println(flight);
		}
		
		return new ResponseEntity<List<Flight>>(flightList,HttpStatus.OK);
	}
	
	@GetMapping("/getFlightById/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable int flightId) throws RecordNotFoundException
	{
		Flight flight = flightService.getFlightById(flightId);
		
		if(flight==null)
		{
			throw new RecordNotFoundException("Flight not Found");
		}
		return new ResponseEntity<Flight>(flight,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteFlight/{flightid}")
	public ResponseEntity<String> deleteFlight(@PathVariable int flightid)
	{
		flightService.deleteFlightById(flightid);
		return new ResponseEntity<>("Flight deleted Succesfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateFlight/{flightId}")
	public ResponseEntity<String> updateFlight(@PathVariable int flightId,@RequestBody Flight flight)
	{
		flightService.updateFlight( flightId, flight);
		return new ResponseEntity<String>("Flight updated successfuly",HttpStatus.OK);
	}
}
