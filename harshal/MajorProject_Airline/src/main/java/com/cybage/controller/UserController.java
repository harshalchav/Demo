package com.cybage.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.UserDto;
import com.cybage.model.User;
import com.cybage.model.otpCredentials;
import com.cybage.service.EmailService;
import com.cybage.service.OtpService;
import com.cybage.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	EmailService emailService;
	@Autowired
	OtpService otpService;
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user, HttpServletRequest request)
	{
		if(user.getRole()!= 0|| !user.getUserName().isEmpty() || !user.getUserEmail().isEmpty() || !user.getPassword().isEmpty() || 
				!user.getDob().isEmpty() || !user.getContaactNo().isEmpty() || !user.getGender().isEmpty() || !user.getContaactNo().isEmpty())
		{
			userService.registerUser(user,getSiteURL(request));
			return new ResponseEntity<>("User Added Succesfully",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Please Enter All the Information ",HttpStatus.NOT_ACCEPTABLE); 

	}
	
	@GetMapping("/getUserAll")
	public ResponseEntity<List<User> >getUser()
	{
		List<User> userList = userService.getUser();
		for (User user : userList) {
			System.out.println(user);
		}
		
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@PostMapping("/checklogin")
	public ResponseEntity<User> checkLogin(@RequestBody UserDto user)
	{
		System.out.println(user);
//		 if (user != null) {
//	            if (user.isEnabled() && user.isAccountNonLocked()) {
//	                if (user.getFailedAttempt() < userService.MAX_FAILED_ATTEMPTS - 1) {
//	                    userService.increaseFailedAttempts(user);
//	                } else {
//	                    userService.lock(user);
//	                    exception = new LockedException("Your account has been locked due to 3 failed attempts."
//	                            + " It will be unlocked after 24 hours.");
//	                }
//	            } else if (!user.isAccountNonLocked()) {
//	                if (userService.unlockWhenTimeExpired(user)) {
//	                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
//	                }
//	            }
//	             
//	        }
		
		Optional<User> user1=userService.checkLogin(user.getUserEmail(),user.getPassword());
		if(user1.isPresent()) {
			int otp=otpService.generateOTP(user.getUserEmail());
			String message="Your Otp is "+otp;
	//emailService.sendEmail(user.getUserEmail(),message);
			try {
				userService.sendOtp(user.getUserEmail(), message);
			} catch (UnsupportedEncodingException | MessagingException e) {
			
				e.printStackTrace();
			}
			 return new ResponseEntity<>(user1.get(),HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/checkOtpValidation")
	public ResponseEntity<?> checkOtpValidation(@RequestBody otpCredentials otpCred )
	{
		System.out.println(otpCred);
	int savedOtp=otpService.getOtp(otpCred.getEmail());
	if(savedOtp==otpCred.getOtp()) {
		//otpService.clearOTP(email);
		User user=userService.getUserByEmail(otpCred.getEmail());
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	return new ResponseEntity<>("please enter valid otp",HttpStatus.EXPECTATION_FAILED);
		
	
	}
	
	  private String getSiteURL(HttpServletRequest request) {
	        String siteURL = request.getRequestURL().toString();
	        return siteURL.replace(request.getServletPath(), "");
	    }  
	  @GetMapping("/verify")
	  public String verifyUser(@Param("code") String code) {
	      if (userService.verify(code)) {
	    	  System.out.println("user verified");
	          return "verify_success";
	      } else {
	    	  System.out.println("user not verified");
	          return "verify_fail";
	      }
	  }
}

