package com.cybage.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="select * from user_details  where user_email =?1 and password =?2",nativeQuery = true)
	//@Query(value="select rollid,emailid from blooddonationdb.user where emailid = ?1 and password = ?2",nativeQuery = true)
	public Optional<User> checkLogin(String userEmail,String password);
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
//	  @Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.email = ?2")
//	    @Modifying
//	    public void updateFailedAttempts(int failAttempts, String email);
	@Query("SELECT u FROM User u WHERE u.userEmail = ?1")
    public User findByUserEmail(String email);
}
