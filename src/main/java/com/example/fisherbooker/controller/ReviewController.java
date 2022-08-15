package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.ReviewService;
import com.example.fisherbooker.service.ShipService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	private ReviewService reviewservice;

	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewservice = reviewService;
	}

//	@GetMapping("/all/rating")
//	public ResponseEntity<List<Review>> getAllByAverageMark() {
//		List<Review> reviews = this.reviewservice.getAllByGrade();
//		return new ResponseEntity<>(reviews, HttpStatus.OK);
//	}

//		@GetMapping("/all/unpublished")
//		public ResponseEntity<List<Review>> getAllUnpublished() {
//			List<Review> reviews = this.reviewservice.getAllUnpublished();
//			return new ResponseEntity<>(reviews, HttpStatus.OK);
//		}
//		
//		@PutMapping("/publish/{ReviewId}")
//		public ResponseEntity<Boolean> publishReview(@PathVariable("ReviewId") Long ReviewID) {
//		
//			this.reviewservice.publish(ReviewID);
//			
//			return new ResponseEntity<>(true, HttpStatus.OK);
//		}	

//	@GetMapping("/delete/{ReviewId}")
//	public ResponseEntity<Boolean> deleteReview(@PathVariable("ReviewId") Long ReviewID) {
//		return new ResponseEntity<>(this.reviewservice.deleteReview(ReviewID), HttpStatus.OK);
//	}

	@PostMapping("/cottage/save")
	public ResponseEntity<Boolean> saveCottageReview(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createCottageReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PostMapping("/ship/save")
	public ResponseEntity<Boolean> saveShipReview(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createShipReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PostMapping("/adventure/save")
	public ResponseEntity<Boolean> save(@RequestBody CreateReviewDTO createReviewDTO) {
		this.reviewservice.createAdventureReview(createReviewDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
