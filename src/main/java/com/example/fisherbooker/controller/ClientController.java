package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.ClientDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageOwnerDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.ClientService;
import com.example.fisherbooker.service.CottageOwnerService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	public ClientService clientService;
	

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<ClientDTO>> getAll(){
		List<Client> clients = this.clientService.getAll();
		List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for(Client client : clients) {
			ClientDTO clientDTO = ClientDTO.createClientDTO(client);
			clientsDTO.add(clientDTO);
		}
		return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/cottage/{cottageId}")
	public ResponseEntity<Boolean> subscribeToCottage(@PathVariable Long cottageId, @RequestBody Long accountId){
		this.clientService.subscribeToCottage(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/ship/{cottageId}")
	public ResponseEntity<Boolean> subscribeToShip(@PathVariable Long cottageId, @RequestBody Long accountId){
		this.clientService.subscribeToShip(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping("subscribe/instructor/{cottageId}")
	public ResponseEntity<Boolean> subscribeToInstructor(@PathVariable Long cottageId, @RequestBody Long accountId){
		this.clientService.subscribeToInstructor(cottageId, accountId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/{accountId}")
	public ResponseEntity<ClientDTO> getClientByAccount(@PathVariable Long accountId){
		Client client = this.clientService.getClientByAccountId(accountId); 
		ClientDTO clientDTO = new ClientDTO(client);
		return new ResponseEntity<>(clientDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/cottage/{accountId}")
	public ResponseEntity<List<CottageDTO>> getCottageSubscriptions(@PathVariable Long accountId){
		List<CottageDTO> cottages = this.clientService.getCottageSubscriptions(accountId); 		
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/instructor/{accountId}")
	public ResponseEntity<List<FishingInstructorDTO>> getInstructorSubscriptions(@PathVariable Long accountId){
		List<FishingInstructorDTO> instructors = this.clientService.getInstructorSubscriptions(accountId); 		
		return new ResponseEntity<>(instructors, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/subscriptions/ship/{accountId}")
	public ResponseEntity<List<ShipDTO>> getShipSubscriptions(@PathVariable Long accountId){
		List<ShipDTO> ship = this.clientService.getShipSubscriptions(accountId); 		
		return new ResponseEntity<>(ship, HttpStatus.OK);
	}
}
