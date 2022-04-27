package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
