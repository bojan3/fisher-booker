package com.example.fisherbooker.controller;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.DTO.AddReservationDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

	@Autowired
	private ReservationService reservationSerivce;

	@PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/createByClient")
	public ResponseEntity<Boolean> createByClient(@RequestBody AddReservationDTO reservation) {
		Boolean response = false;
		try {
			response = this.reservationSerivce.addByClient(reservation);
		} catch (OptimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	@PostMapping("/createByOwner")
	public ResponseEntity<Boolean> createByOwner(@RequestBody AddReservationDTO reservation) {
		Boolean response = false;
		try {
			response = this.reservationSerivce.addByOwner(reservation);
		} catch (OptimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/dates/{type}/{id}")
	public ResponseEntity<List<DatePeriodDTO>> getDates(@PathVariable RealEstateType type, @PathVariable Long id) {
		List<DatePeriodDTO> dates = this.reservationSerivce.getDates(type, id);
		return new ResponseEntity<>(dates, HttpStatus.OK);
	}

}
