package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query(value = "SELECT * FROM flight_details WHERE offer_id = ?1", nativeQuery = true)
	List<Flight> FindAllByOffer(int offerId);
}
