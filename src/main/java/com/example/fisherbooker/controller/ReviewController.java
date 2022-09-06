package com.example.fisherbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.DTO.ApproveReviewDTO;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReview;
import com.example.fisherbooker.model.DTO.ApproveReviewDTO;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	private ReviewService reviewservice;

	@Autowired
	private EmailService emailservice;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewservice = reviewService;
	}

//	@GetMapping("/all/rating")
//	public ResponseEntity<List<Review>> getAllByAverageMark() {
//		List<Review> reviews = this.reviewservice.getAllByGrade();
//		return new ResponseEntity<>(reviews, HttpStatus.OK);
//	}

	@GetMapping("/all/unpublished")
	public ResponseEntity<List<ApproveReviewDTO>> getAllUnpublished() {
		List<ApproveReviewDTO> reviews = this.reviewservice.getAllUnpublished();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@PutMapping("/publish/{ReviewId}")
	public ResponseEntity<Boolean> publishReview(@PathVariable("ReviewId") Long ReviewID) {

		Boolean response = false;
		
		try {	
			AdventureReview ar = this.reviewservice.getAdventureReview(ReviewID);
			Account acc = ar.getAdventure().getFishingInstructor().getAccount();
			this.reviewservice.sendNewReviewEmail(acc,ar);
			response = true;

		}
		
		catch(Exception err) {
			System.out.print("not an adventure");
			System.out.println(err);
		}
		try {
			ShipReview ar = this.reviewservice.getShipReview(ReviewID);
			Account acc = ar.getShip().getShipOwner().getAccount();
			this.reviewservice.sendNewReviewEmail(acc,ar);
			response = true;


		}
		catch(Exception err) {
			System.out.print("not a ship");
			System.out.println(err);
		}
		
		try {
			
			CottageReview cr = this.reviewservice.getCottageReview(ReviewID);
			Account acc = cr.getCottage().getCottageOwner().getAccount();
			this.reviewservice.sendNewReviewEmail(acc,cr);
			response = true;


		}
		catch (Exception e) {
			System.out.print("not a cottage");
			System.out.println(e);
		}
		finally {
			
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
		
		
		
	}

	@GetMapping("/delete/{ReviewId}")
	public ResponseEntity<Boolean> deleteReview(@PathVariable("ReviewId") Long ReviewID) {
		return new ResponseEntity<>(this.reviewservice.deleteReview(ReviewID), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/cottage/save")
	public ResponseEntity<Boolean> saveCottageReview(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createCottageReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/ship/save")
	public ResponseEntity<Boolean> saveShipReview(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createShipReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/adventure/save")
	public ResponseEntity<Boolean> save(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createAdventureReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
