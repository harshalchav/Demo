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
import com.cybage.model.Feedback;
import com.cybage.service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback)
	{
		feedbackService.addFeedback(feedback);
		return new ResponseEntity<>("Feedback Added Succesfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/getFeedbackAll")
	public ResponseEntity<List<Feedback> >getFeedback()
	{
		List<Feedback> feedbackList = feedbackService.getFeedback();
		return new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.OK);
	}
	
	@GetMapping("/getFeedbackById/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int feedbackId) throws RecordNotFoundException
	{
		Feedback feedback = feedbackService.getFeedbackById(feedbackId);
		
		if(feedback==null)
		{
			throw new RecordNotFoundException("Feedback not Found");
		}
		return new ResponseEntity<Feedback>(feedback,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteFeedback/{feedbackId}")
	public ResponseEntity<String> deleteFeedback(@PathVariable int feedbackId)
	{
		feedbackService.deleteFeedbackById(feedbackId);
		return new ResponseEntity<>("Feedback deleted Succesfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateFeedback/{feedbackId}")
	public ResponseEntity<String> updateFeedback(@PathVariable int feedbackId,@RequestBody Feedback feedback)
	{
		feedbackService.updateFeedback( feedbackId, feedback);
		return new ResponseEntity<String>("Feedback updated successfuly",HttpStatus.OK);
	}
}
