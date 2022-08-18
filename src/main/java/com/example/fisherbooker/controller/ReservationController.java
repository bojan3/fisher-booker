package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.DTO.AddReservationDTO;
import com.example.fisherbooker.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
	
	@Autowired
	private ReservationService reservationSerivce;
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody AddReservationDTO reservation) {
		this.reservationSerivce.add(reservation);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
