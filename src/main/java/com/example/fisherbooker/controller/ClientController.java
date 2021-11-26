package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	public ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
}
