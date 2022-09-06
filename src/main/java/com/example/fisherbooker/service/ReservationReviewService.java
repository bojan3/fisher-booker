package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.ShipReservationReview;
import com.example.fisherbooker.model.AdventureReservationReview;
import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.DTO.AnswerReservationReviewDTO;
import com.example.fisherbooker.model.DTO.ReservationReviewDTO;

public interface ReservationReviewService {
	public Boolean create(ReservationReviewDTO review);

	public List<AnswerReservationReviewDTO> getAll();

   
  // public <T> findOne(String type, Long reservation_id);

 //  public void saveA(CottageReservationReview rr);
 //  public void saveB(ShipReservationReview rr);
 //  public void saveC(AdventureReservationReview rr);
   
   public void save(ReservationReview rr);


public CottageReservationReview findOneCottageReservationReview(Long reservationId);

public AdventureReservationReview findOneAdventureReservationReview(Long reservationId);

public ShipReservationReview findOneShipReservationReview(Long reservationId);

public void save(AnswerReservationReviewDTO review);


}
