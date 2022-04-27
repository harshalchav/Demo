package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.repository.TicketMasterRepository;

@Service
public class TicketMasterService {
 
	@Autowired
	TicketMasterRepository ticketMasterRepository;
	
}
