package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ReservationReview;

@Repository
public interface ReservationReviewRepository extends JpaRepository<ReservationReview, Long> {

}
