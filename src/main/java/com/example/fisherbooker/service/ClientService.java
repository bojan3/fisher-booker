package com.example.fisherbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.repository.ClientRepository;

@Service
public class ClientService {
	
	public ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		
	}
	
//	public List<Client> getAll(){
//		return clientRepository.getAll();
//	}
}
