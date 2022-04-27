package com.cybage.service;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;


import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	UserRepository userRepository;
	public static final int MAX_FAILED_ATTEMPTS = 3;
    
    private static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
	public void registerUser(User user,String siteURL) {
		user.setLocked("unlocked");
		user.setRole(2);
		 String randomCode = RandomString.make(64);
		    user.setVerificationCode(randomCode);
		    user.setEnabled(false);
		     
		    //repo.save(user);
		     
		    try {
				sendVerificationEmail(user, siteURL);
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		userRepository.save(user);
		
	}
	
	public List<User> getUser() {
		return userRepository.findAll();
		
	}
	
	
	public Optional<User> checkLogin(String userEmail,String password)
	{
		Optional<User> user= userRepository.checkLogin(userEmail, password);
		
		if(user != null)
		{
		   System.out.println(user);
		   return user;
		}
		
		System.out.println(user);
		return null;
	}
	 private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
	  String toAddress = user.getUserEmail();
		    String content = "Dear [[name]],<br>"
		            + "Please click the link below to verify your registration:<br>"
		            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
		            + "Thank you,<br>"
		            + "Your company name.";
		     
		    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    String subject = "Verify your account";
    helper.setFrom("Trng1@evolvingsols.com", "AirlineBookingSystem");
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getUserName());
    String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
		     
    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    javaMailSender.send(message);


	 }
	 public boolean verify(String verificationCode) {
		    User user = userRepository.findByVerificationCode(verificationCode);
		     
		    if (user == null || user.isEnabled()) {
		        return false;
		    } else {
		        user.setVerificationCode(null);
		        user.setEnabled(true);
		        userRepository.save(user);
		         
		        return true;
		    }
		     
		}
	 
	 
	//functionalities for lock and unlock
//	  public void increaseFailedAttempts(User user) {
//	        int newFailAttempts = user.getFailedAttempt() + 1;
//	        userRepository.updateFailedAttempts(newFailAttempts, user.getUserEmail());
//	    }
//	     
//	    public void resetFailedAttempts(String email) {
//	    	userRepository.updateFailedAttempts(0, email);
//	    }
	     
//	    public void lock(User user) {
//	        user.setAccountNonLocked(false);
//	        user.setLockTime(new Date(LOCK_TIME_DURATION));
//	         
//	        userRepository.save(user);
//	    }
//	     
//	    public boolean unlockWhenTimeExpired(User user) {
//	        long lockTimeInMillis = user.getLockTime().getTime();
//	        long currentTimeInMillis = System.currentTimeMillis();
//	         
//	        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
//	            user.setAccountNonLocked(true);
//	            user.setLockTime(null);
//	            user.setFailedAttempt(0);
//	             
//	            userRepository.save(user);
//	             
//	            return true;
//	        }
//	         
//	        return false;
//	    }
	 
	 
	 
	 
	 public void sendOtp(String userEmail,String otpMessage) throws UnsupportedEncodingException, MessagingException {
		  String toAddress =userEmail;
		    String content = "Dear [[name]],<br>"
		            + "please find your otp below<br>"
		            + "<br>[[otp]] <br>"
		            + "Thank you,<br>";
		          
		     
		    MimeMessage message = javaMailSender.createMimeMessage();
  MimeMessageHelper helper = new MimeMessageHelper(message);
  String subject = "Verify your account";
  helper.setFrom("Trng1@evolvingsols.com", "AirlineBookingSystem");
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", userEmail);
  String otp =otpMessage;
		     
  content = content.replace("[[otp]]", otp);
	     
	    helper.setText(content, true);
	     
	    javaMailSender.send(message);
	 }
	 
	 
	 public User getUserByEmail(String email) {
		 return userRepository.findByUserEmail(email);
	 }
}
