package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.repository.BookingMasterRepository;

@Service
public class BookingMasterService {

	@Autowired
	BookingMasterRepository bookingMasterRepository;
}
