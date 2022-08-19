package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReview;
import com.example.fisherbooker.model.DTO.ApproveReviewDTO;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.ReviewRepository;
import com.example.fisherbooker.repository.ShipRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository<CottageReview> cottagereviewRepository;

	@Autowired
	private ReviewRepository<ShipReview> shipreviewRepository;

	@Autowired
	private ReviewRepository<AdventureReview> adventurereviewRepository;

	@Autowired
	private CottageRepository cottageRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ShipRepository shipRepository;

	@Autowired
	private AdventureRepository adventureRepository;

	@Autowired
	public ReviewService(ReviewRepository<CottageReview> cottagereviewrepository,
			ReviewRepository<ShipReview> shipreviewrepository,
			ReviewRepository<AdventureReview> adventurereviewrepository, CottageRepository cottageRepository,
			ClientRepository clientRepository, ShipRepository shipRepository, AdventureRepository adventureRepository) {
		this.adventurereviewRepository = adventurereviewrepository;
		this.cottagereviewRepository = cottagereviewrepository;
		this.shipreviewRepository = shipreviewrepository;
		this.cottageRepository = cottageRepository;
		this.clientRepository = clientRepository;
		this.shipRepository = shipRepository;
		this.adventureRepository = adventureRepository;
	}

	public void createCottageReview(CreateReviewDTO createReviewDTO) {
		Cottage cottage = cottageRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		CottageReview cottageReview = new CottageReview(createReviewDTO, client, cottage);
		this.cottagereviewRepository.save(cottageReview);
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
		this.shipreviewRepository.save(shipReview);
	}

	public void createAdventureReview(CreateReviewDTO createReviewDTO) {
		Adventure adventure = this.adventureRepository.getOne(createReviewDTO.getReviewEntityId());
		Client client = getClient();
		AdventureReview adventureReview = new AdventureReview(createReviewDTO, client, adventure);
		this.adventurereviewRepository.save(adventureReview);
	}

	public void publish(Long reviewID) {
	try {	
		AdventureReview ar = this.adventurereviewRepository.findById(reviewID).get();
		ar.setApproved(true);
		this.adventurereviewRepository.save(ar);
	}
	
	catch(Exception err) {
		System.out.print("not a adventure");
		System.out.println(err);
	}
	try {
		CottageReview cr = this.cottagereviewRepository.findById(reviewID).get();
		cr.setApproved(true);
		this.cottagereviewRepository.save(cr);
	}
	catch(Exception err) {
		System.out.print("not a cottage");
		System.out.println(err);
	}
	
	try {
		
		ShipReview shr = this.shipreviewRepository.findById(reviewID).get();
		shr.setApproved(true);
		this.shipreviewRepository.save(shr);
	}
	catch (Exception e) {
		System.out.print("not ship");
		System.out.println(e);
	}
	
		

	}

	public List<ApproveReviewDTO> getAllUnpublished() {
		List<CottageReview> cottagereviews = this.cottagereviewRepository.findAllCottages();
		List<ShipReview> shipreviews = this.shipreviewRepository.findAllShips();
		List<AdventureReview> adventurereviews = this.adventurereviewRepository.findAllAdventures();

		List<ApproveReviewDTO> unapproved = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved1 = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved2 = new ArrayList<ApproveReviewDTO>();
		List<ApproveReviewDTO> unapproved3 = new ArrayList<ApproveReviewDTO>();

		for (CottageReview cr : cottagereviews) {
			if (cr.getApproved().equals(false))
				unapproved1.add(new ApproveReviewDTO(cr));
		}

		for (ShipReview shr : shipreviews) {
			if (shr.getApproved().equals(false))
				unapproved2.add(new ApproveReviewDTO(shr));
		}

		for (AdventureReview ar : adventurereviews) {
			if (ar.getApproved().equals(false))
				unapproved3.add(new ApproveReviewDTO(ar));
		}

		unapproved.addAll(unapproved1);
		unapproved.addAll(unapproved2);
		unapproved.addAll(unapproved3);
		return unapproved;
	}

}
