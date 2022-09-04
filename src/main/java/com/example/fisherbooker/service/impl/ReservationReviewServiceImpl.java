package com.example.fisherbooker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.DTO.ReservationReviewDTO;
import com.example.fisherbooker.repository.ReservationReviewRepository;
import com.example.fisherbooker.service.ReservationReviewService;

@Service
public class ReservationReviewServiceImpl implements ReservationReviewService {

	@Autowired
	private ReservationReviewRepository reservationReviewRepository;

	public Boolean create(ReservationReviewDTO review) {
		switch (review.getType()) {
		case COTTAGE: {
			this.reservationReviewRepository.save(review.toCottageReview());
			break;
		}
		case SHIP: {
			this.reservationReviewRepository.save(review.toShipReview());
			break;
		}
		case ADVENTURE: {
			break;
		}
		}
		return true;
	}
}
