package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReview;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.ReviewRepository;
import com.example.fisherbooker.repository.ShipRepository;

@Service
public class ReviewService {

	private ReviewRepository reviewRepository;
	private CottageRepository cottageRepository;
	private ClientRepository clientRepository;
	private ShipRepository shipRepository;
	private AdventureRepository adventureRepository;

	@Autowired
	public ReviewService(ReviewRepository reviewRepository, CottageRepository cottageRepository,
			ClientRepository clientRepository, ShipRepository shipRepository, AdventureRepository adventureRepository) {
		this.reviewRepository = reviewRepository;
		this.cottageRepository = cottageRepository;
		this.clientRepository = clientRepository;
		this.shipRepository = shipRepository;
		this.adventureRepository = adventureRepository;
	}

	public void createCottageReview(CreateReviewDTO createReviewDTO) {
		Cottage cottage = cottageRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		CottageReview cottageReview = new CottageReview(createReviewDTO, client, cottage);
		this.reviewRepository.save(cottageReview);
	}

	private Client getClient() {
		String clinetName = SecurityContextHolder.getContext().getAuthentication().getName();
		return this.clientRepository.findByName(clinetName);
	}
//	public Boolean deleteReview(Long review_id) {
//		this.rr.deleteById(review_id);
//		return true;
//	}
//
//	public List<Review> getAllByGrade() {
//		return this.rr.findByOrderByGrade();
//	}

	public void createShipReview(CreateReviewDTO createReviewDTO) {
		Ship ship = this.shipRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		ShipReview shipReview = new ShipReview(createReviewDTO, client, ship);
		this.reviewRepository.save(shipReview);
	}

	public void createAdventureReview(CreateReviewDTO createReviewDTO) {
		Adventure adventure = this.adventureRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		AdventureReview adventureReview = new AdventureReview(createReviewDTO, client, adventure);
		this.reviewRepository.save(adventureReview);
	}

//	public void publish(Long reviewID) {
//	Review r =	this.rr.findById(reviewID).get();
//	r.setPublished(true);
//	this.rr.save(r);
//		
//	}
//
//
//	public List<Review> getAllUnpublished() {
//		List<Review> sve = this.rr.findAll();
//		List<Review> neobjavljene = new ArrayList<Review>();
//		
//		 for(Review r : sve){
//			if(r.getPublished().equals(false)) 
//				neobjavljene.add(r);
//		 }	
//		return neobjavljene;
//	}

}
