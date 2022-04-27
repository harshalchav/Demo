package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.service.TicketMasterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TicketMasterController {

	@Autowired
	TicketMasterService ticketMasterService;
}
