package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.FlightInventory;

@Repository
public interface FlightInventoryRepository extends JpaRepository<FlightInventory, Integer> {

}
