package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.repository.FlightInventoryRepository;

@Service
public class FlightInventoryService {

	@Autowired
	FlightInventoryRepository flightInventoryRepository;
	
}
