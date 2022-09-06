package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.AdventureReservationReview;
import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.ShipReservationReview;
import com.example.fisherbooker.model.DTO.AnswerReservationReviewDTO;
import com.example.fisherbooker.model.DTO.ReservationReviewDTO;
import com.example.fisherbooker.model.EmailContexts.NewPenalEmailContext;
import com.example.fisherbooker.service.ClientService;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.ReservationReviewService;

@RestController
@RequestMapping("api/reservationReview")
public class ReservationReviewController {

	@Autowired
	private ReservationReviewService reservationReviewService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody ReservationReviewDTO review) {
		this.reservationReviewService.create(review);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AnswerReservationReviewDTO>> getAll() {
		List<AnswerReservationReviewDTO> response =	this.reservationReviewService.getAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/penal")
	public ResponseEntity<Boolean> penal(@RequestBody AnswerReservationReviewDTO review) {	
		Boolean response = false;
		try {
			if(clientService.penal(review.getClientUsername()))
			{
				response = true;		
				this.reservationReviewService.save(review);
				
				try {					
					NewPenalEmailContext newpenalOwner = new NewPenalEmailContext();
					newpenalOwner.init(review);
					newpenalOwner.setTo(review.getOwnerEmail());
					emailService.sendMail(newpenalOwner);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				
				try {	
					NewPenalEmailContext newpenalClient = new NewPenalEmailContext();
					newpenalClient.init(review);
					newpenalClient.setTo(review.getClientEmail());
					emailService.sendMail(newpenalClient);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				
				
			}
		} catch (Exception e) {
			System.out.println("клијент је већ кажњен");}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestBody AnswerReservationReviewDTO review) {	
		Boolean response = false;
		
//		try {
//			switch (review.getType()) {
//			case "COTTAGE":
//				CottageReservationReview crr = this.reservationReviewService.findOneCottageReservationReview(review.getReservationId());
//				System.out.println(crr);
////				crr.setAnswered(true);
//			//	this.reservationReviewService.saveA(crr);
//				response = true;
///				
//			case "ADVENTURE":
///				AdventureReservationReview arr = this.reservationReviewService.findOneAdventureReservationReview(review.getReservationId());
//				System.out.println(arr);
///				arr.setAnswered(true);
//			//	this.reservationReviewService.saveB(arr);
//				response = true;
//				
//			case "SHIP":
//					ShipReservationReview shrr = this.reservationReviewService.findOneShipReservationReview(review.getReservationId());
//					System.out.println(shrr);
//					shrr.setAnswered(true);
//					//this.reservationReviewService.saveC(shrr);					}
//					response = true;
//				}
//			}	
//			catch(Exception e) {
//				e.getMessage();
//			}	
		
		this.reservationReviewService.save(review);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
