package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.DTO.AnswerReservationReviewDTO;
import com.example.fisherbooker.model.DTO.ApproveReviewDTO;
import com.example.fisherbooker.model.DTO.ReservationReviewDTO;
import com.example.fisherbooker.repository.ReservationReviewRepository;
import com.example.fisherbooker.service.ReservationReviewService;
import com.example.fisherbooker.model.AdventureReservationReview;
import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.ShipReservationReview;
import com.example.fisherbooker.model.ShipReview;


@Service
public class ReservationReviewServiceImpl implements ReservationReviewService {

	@Autowired
	private ReservationReviewRepository<CottageReservationReview> cottageReservationReviewRepository;
	@Autowired
	private ReservationReviewRepository<ShipReservationReview> shipReservationReviewRepository;
	@Autowired
	private ReservationReviewRepository<AdventureReservationReview> adventureReservationReviewRepository;
	@Autowired
	private ReservationReviewRepository reservationReviewRepository;


	
	@Override
	public List<AnswerReservationReviewDTO> getAll() {
		
		List<CottageReservationReview> cottagereviews = 
				this.cottageReservationReviewRepository.findAllCottages();
		List<ShipReservationReview> shipreviews =
				this.shipReservationReviewRepository.findAllShips();
		List<AdventureReservationReview> adventurereviews = 
				this.adventureReservationReviewRepository.findAllAdventures();

		
		List<AnswerReservationReviewDTO> unapproved =
				new ArrayList<AnswerReservationReviewDTO>();
		List<AnswerReservationReviewDTO> unapproved1 = 
				new ArrayList<AnswerReservationReviewDTO>();
		List<AnswerReservationReviewDTO> unapproved2 = 
				new ArrayList<AnswerReservationReviewDTO>();
		List<AnswerReservationReviewDTO> unapproved3 =
				new ArrayList<AnswerReservationReviewDTO>();

		for (CottageReservationReview cr : cottagereviews) {
			if(cr.getAnswered().equals(false)&&cr.getBadReview().equals(false))
				unapproved1.add(new AnswerReservationReviewDTO(cr));
		}

		for (ShipReservationReview shr : shipreviews) {
			if(shr.getAnswered().equals(false)&&shr.getBadReview().equals(false))
				unapproved2.add(new AnswerReservationReviewDTO(shr));
		}

		for (AdventureReservationReview ar : adventurereviews) {
			if(ar.getAnswered().equals(false)&&ar.getBadReview().equals(false))
				unapproved3.add(new AnswerReservationReviewDTO(ar));
		}

		unapproved.addAll(unapproved1);
		unapproved.addAll(unapproved2);
		unapproved.addAll(unapproved3);
		
		return unapproved;
	}
		
	
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
			this.reservationReviewRepository.save(review.toAdventureReview());
			break;
		}
		}
		return true;
	}


	@Override
	public ReservationReview findOne(String type, Long reservation_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(ReservationReview rr) {
		// TODO Auto-generated method stub
		;
		
	}


}
