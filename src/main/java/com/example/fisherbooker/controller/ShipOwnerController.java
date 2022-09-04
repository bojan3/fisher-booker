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

import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.model.DTO.ShipOwnerDTO;
import com.example.fisherbooker.service.ShipOwnerService;
import com.example.fisherbooker.service.ShipReservationService;

@RestController
@RequestMapping("/api/shipOwner")
public class ShipOwnerController {

	private ShipOwnerService shipOwnerService;
	private ShipReservationService shipReservationService;

	@Autowired
	public ShipOwnerController(ShipOwnerService shipOwnerService, ShipReservationService shipReservationService) {
		super();
		this.shipOwnerService = shipOwnerService;
		this.shipReservationService = shipReservationService;
	}

	@GetMapping("/allShipsByOwner")
	public ResponseEntity<Set<ShipDTO>> getAllShipsByOwner() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<ShipDTO> ships = this.shipOwnerService.getAllShipsByOwner(username);
		return new ResponseEntity<>(ships, HttpStatus.OK);
	}
// PULL REQUEST
	@GetMapping("/all")
	public ResponseEntity<List<ShipOwnerDTO>> getAll() {
		List<ShipOwner> shipowners = this.shipOwnerService.getAll();
		List<ShipOwnerDTO> shipownersDTO = new ArrayList<ShipOwnerDTO>();
		for (ShipOwner shipowner : shipowners) {
			//ShipOwnerDTO shipownerDTO = ShipOwnerDTO.createShipOwnerDTO(shipowner);
			ShipOwnerDTO shipownerDTO = new  ShipOwnerDTO();
			shipownerDTO.account = shipowner.getAccount();
			shipownersDTO.add(shipownerDTO);
		}
		return new ResponseEntity<>(shipownersDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public ResponseEntity<Boolean> deleteInstructorByID(@RequestBody Long instructor_id){	
		this.shipOwnerService.deleteOne(instructor_id);	
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/reservations/{page}")
	public ResponseEntity<List<ReservationDetailsDTO>> getReservationsByCottageOwner(@PathVariable int page) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<ReservationDetailsDTO> dtos = this.shipReservationService.getReservationsByShipOwner(username, page);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("reservationNum")
	public ResponseEntity<Integer> getReservationNum() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		int number = this.shipReservationService.getNumberOfReservations(username);
		return new ResponseEntity<>(number, HttpStatus.OK);
	}
		

}
