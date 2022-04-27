package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.repository.PaymentRepository;

@Service
public class PaymentService {
 
	@Autowired
	PaymentRepository paymentRepository;
}
