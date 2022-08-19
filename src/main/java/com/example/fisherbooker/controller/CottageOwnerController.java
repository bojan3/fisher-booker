package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageOwnerDTO;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.CottageReservationService;

@RestController
@RequestMapping("/api/cottageOwner")
public class CottageOwnerController {

	private CottageOwnerService cottageOwnerService;
	private CottageReservationService cottageReservationService;

	@Autowired
	public CottageOwnerController(CottageOwnerService cottageOwnerService,
			CottageReservationService cottageReservationService) {
		super();
		this.cottageOwnerService = cottageOwnerService;
		this.cottageReservationService = cottageReservationService;
	}

	@GetMapping("/allCottagesByOwner")
	public ResponseEntity<Set<CottageDTO>> getAllCottagesByOwner() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<CottageDTO> cottages = this.cottageOwnerService.getAllCottagesByOwner(username);
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CottageOwnerDTO>> getAll() {
		List<CottageOwner> cottageowners = this.cottageOwnerService.getAll();

		List<CottageOwnerDTO> cottageownersDTO = new ArrayList<CottageOwnerDTO>();
		for (CottageOwner cottageowner : cottageowners) {
			// CottageOwnerDTO cottageownerDTO = new
			// CottageOwnerDTO(cottageowner.getAccount(),cottageowner.getCottages());
			CottageOwnerDTO cottageownerDTO = new CottageOwnerDTO();
			cottageownerDTO.setAccount(cottageowner.getAccount());
			// cottageownerDTO.setCottages(cottageowner.getCottages());
			cottageownerDTO.setID(cottageowner.getId());
			cottageownersDTO.add(cottageownerDTO);
		}
		return new ResponseEntity<>(cottageownersDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteInstructorByID(@RequestBody Long instructor_id) {
		this.cottageOwnerService.deleteOne(instructor_id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/reservations/{page}")
	public ResponseEntity<List<ReservationDetailsDTO>> getReservationsByCottageOwner(@PathVariable int page) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<ReservationDetailsDTO> dtos = this.cottageReservationService.getReservationsByCottageOwner(username, page);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("reservationNum")
	public ResponseEntity<Integer> getReservationNum() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		int number = this.cottageReservationService.getNumberOfReservations(username);
		return new ResponseEntity<>(number, HttpStatus.OK);
	}

}
