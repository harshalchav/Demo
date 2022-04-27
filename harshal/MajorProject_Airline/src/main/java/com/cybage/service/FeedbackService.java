package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Feedback;
import com.cybage.model.Flight;
import com.cybage.model.Offer;
import com.cybage.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	public void addFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		
	}

	public List<Feedback> getFeedback() {
		return feedbackRepository.findAll();
		
	}
	public Feedback getFeedbackById(int feedbackId) {
		 return feedbackRepository.findById(feedbackId).orElse(null);
	 }
	
	public void deleteFeedbackById(int feedbackId) {
		feedbackRepository.deleteById(feedbackId);
	 }

	public void updateFeedback(int feedbackId,Feedback feedback) {
		feedbackRepository.save(feedback);
	
	}
}
