package com.example.fisherbooker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.DTO.ReservationReviewDTO;
import com.example.fisherbooker.repository.CottageReservationReviewRepository;
import com.example.fisherbooker.service.ReservationReviewService;

@Service
public class ReservationReviewServiceImpl implements ReservationReviewService {

	@Autowired
	private CottageReservationReviewRepository cottageReviewRepository;

	public Boolean create(ReservationReviewDTO review) {
		switch (review.getType()) {
		case COTTAGE: {
			this.cottageReviewRepository.save(review.toCottageReview());
			break;
		}
		case SHIP: {
			break;
		}
		case ADVENTURE: {
			break;
		}
		}
		return true;
	}
}
