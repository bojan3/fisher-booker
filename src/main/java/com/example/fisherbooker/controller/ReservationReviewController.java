package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.DTO.ReservationReviewDTO;
import com.example.fisherbooker.service.ReservationReviewService;

@RestController
@RequestMapping("api/reservationReview")
public class ReservationReviewController {

	@Autowired
	private ReservationReviewService reservationReviewService;
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody ReservationReviewDTO review) {
		this.reservationReviewService.create(review);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
