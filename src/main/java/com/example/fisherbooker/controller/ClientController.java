package com.example.fisherbooker.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.DTO.AdventureReservationDTO;
import com.example.fisherbooker.model.DTO.ClientDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageReservationDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.model.DTO.ShipReservationDTO;
import com.example.fisherbooker.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	public ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/allClients")
	public ResponseEntity<List<ClientDTO>> getAll() {
		List<Client> clients = this.clientService.getAll();
		List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for (Client client : clients) {
			//ClientDTO clientDTO = new ClientDTO(client); //ClientDTO.createClientDTO(client);
			ClientDTO clientDTO = ClientDTO.createClientDTO(client);
			clientsDTO.add(clientDTO);
		}
		return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public ResponseEntity<Boolean> deleteClientByID(@RequestBody Long client_id){	
		System.out.println("delete instructor with id:"+client_id);
		this.clientService.deleteOne(client_id);	
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/cottage/{cottageId}")
	public ResponseEntity<Boolean> subscribeToCottage(@PathVariable Long cottageId, @RequestBody Long accountId) {
		this.clientService.subscribeToCottage(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/ship/{cottageId}")
	public ResponseEntity<Boolean> subscribeToShip(@PathVariable Long cottageId, @RequestBody Long accountId) {
		this.clientService.subscribeToShip(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/instructor/{cottageId}")
	public ResponseEntity<Boolean> subscribeToInstructor(@PathVariable Long cottageId, @RequestBody Long accountId) {
		this.clientService.subscribeToInstructor(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/{accountId}")
	public ResponseEntity<ClientDTO> getClientByAccount(@PathVariable Long accountId) {
		Client client = this.clientService.getClientByAccountId(accountId);
		ClientDTO clientDTO = new ClientDTO(client);
		return new ResponseEntity<>(clientDTO, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/cottage/{accountId}")
	public ResponseEntity<List<CottageDTO>> getCottageSubscriptions(@PathVariable Long accountId) {
		List<CottageDTO> cottages = this.clientService.getCottageSubscriptions(accountId);
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/instructor/{accountId}")
	public ResponseEntity<List<FishingInstructorDTO>> getInstructorSubscriptions(@PathVariable Long accountId) {
		List<FishingInstructorDTO> instructors = this.clientService.getInstructorSubscriptions(accountId);
		return new ResponseEntity<>(instructors, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/ship/{accountId}")
	public ResponseEntity<List<ShipDTO>> getShipSubscriptions(@PathVariable Long accountId) {
		List<ShipDTO> ship = this.clientService.getShipSubscriptions(accountId);
		return new ResponseEntity<>(ship, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("unsubscribe/cottage/{cottageId}")
	public ResponseEntity<Boolean> unsubscribeToCottage(@PathVariable Long cottageId, @RequestBody Long accountId) {
		this.clientService.unsubscribeToCottage(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("unsubscribe/ship/{shipId}")
	public ResponseEntity<Boolean> unsubscribeToShip(@PathVariable Long shipId, @RequestBody Long accountId) {
		this.clientService.unsubscribeToShip(shipId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("unsubscribe/instructor/{instructorId}")
	public ResponseEntity<Boolean> unsubscribeToInstructor(@PathVariable Long instructorId,
			@RequestBody Long accountId) {
		this.clientService.unsubscribeToInstructor(instructorId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

//	rezervacije koje nisu prosle
	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/reservation/adventure/{accountId}")
	public ResponseEntity<List<AdventureReservationDTO>> getAdventureReservations(@PathVariable Long accountId) {
		List<AdventureReservationDTO> adventureReservationDTOs = this.clientService.getAdventureReservations(accountId);
		return new ResponseEntity<>(adventureReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/finishedreservation/adventure/{accountId}")
	public ResponseEntity<List<AdventureReservationDTO>> getFinishedAdventureReservations(
			@PathVariable Long accountId) {
		List<AdventureReservationDTO> adventureReservationDTOs = this.clientService
				.getFinishedAdventureReservations(accountId);
		return new ResponseEntity<>(adventureReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/reservation/ship/{accountId}")
	public ResponseEntity<List<ShipReservationDTO>> getShipReservations(@PathVariable Long accountId) {
		List<ShipReservationDTO> shipReservationDTOs = this.clientService.getShipReservations(accountId);
		return new ResponseEntity<>(shipReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/finishedreservation/ship/{accountId}")
	public ResponseEntity<List<ShipReservationDTO>> getFinishedShipReservations(@PathVariable Long accountId) {
		List<ShipReservationDTO> shipReservationDTOs = this.clientService.getFinishedShipReservations(accountId);
		return new ResponseEntity<>(shipReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/reservation/cottage/{accountId}")
	public ResponseEntity<List<CottageReservationDTO>> getCottageReservations(@PathVariable Long accountId) {
		List<CottageReservationDTO> cottageReservationDTOs = this.clientService.getCottageReservations(accountId);
		return new ResponseEntity<>(cottageReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/finishedreservation/cottage/{accountId}")
	public ResponseEntity<List<CottageReservationDTO>> getFinishedCottageReservations(@PathVariable Long accountId) {
		List<CottageReservationDTO> cottageReservationDTOs = this.clientService
				.getFisnihedCottageReservations(accountId);
		return new ResponseEntity<>(cottageReservationDTOs, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@DeleteMapping("/reservation/ship/delete/{accountId}")
	public ResponseEntity<Boolean> deleteShipReservations(@PathVariable Long accountId,
			@RequestBody Long shipReservationId) {
		this.clientService.deleteShipReservation(accountId, shipReservationId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@DeleteMapping("/reservation/cottage/delete/{accountId}")
	public ResponseEntity<Boolean> deleteCottageReservations(@PathVariable Long accountId,
			@RequestBody Long cottageReservationId) {
		this.clientService.deleteCottageReservation(accountId, cottageReservationId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@DeleteMapping("/reservation/adventure/delete/{accountId}")
	public ResponseEntity<Boolean> deleteAdventureReservations(@PathVariable Long accountId,
			@RequestBody Long adventureReservationId) {
		this.clientService.deleteAdventureReservation(accountId, adventureReservationId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("cottagecomplaint/{cottageId}/{accountId}")
	public ResponseEntity<Boolean> createCottageComplaint(@PathVariable Long cottageId, @PathVariable Long accountId,
			@RequestBody String text) {
		this.clientService.createCottageComplaint(cottageId, accountId, text);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("instructorcomplaint/{adventureId}/{accountId}")
	public ResponseEntity<Boolean> createInstructorComplaint(@PathVariable Long adventureId, @PathVariable Long accountId,
			@RequestBody String text) {
		this.clientService.createInstructorComplaint(adventureId, accountId, text);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('CLIENT')")	
	@PutMapping("shipcomplaint/{shipId}/{accountId}")
	public ResponseEntity<Boolean> createShipComplaint(@PathVariable Long shipId, @PathVariable Long accountId,
			@RequestBody String text) {
		this.clientService.createShipComplaint(shipId, accountId, text);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
