package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.DTO.AnswerReservationReviewDTO;
import com.example.fisherbooker.model.DTO.ReservationReviewDTO;

public interface ReservationReviewService {
	public Boolean create(ReservationReviewDTO review);

	public List<AnswerReservationReviewDTO> getAll();

   
   public ReservationReview findOne(String type, Long reservation_id);

public void save(ReservationReview rr);


}
