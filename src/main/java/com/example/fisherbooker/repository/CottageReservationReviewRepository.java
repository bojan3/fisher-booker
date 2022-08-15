package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageReservationReview;

@Repository
public interface CottageReservationReviewRepository  extends JpaRepository<CottageReservationReview, Long> {

}
