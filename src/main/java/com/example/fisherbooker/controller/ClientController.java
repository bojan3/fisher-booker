package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.DTO.ClientDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageOwnerDTO;
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
		System.out.println(clientsDTO);
		return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
	}
}
