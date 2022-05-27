package com.example.fisherbooker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.repository.ClientRepository;

@Service
public class ClientService {
	
	public ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return this.clientRepository.findAll();
	}

	public Optional<Client> findOneById(Long client_id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(client_id);
	}

	public Object getById(Long client_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public List<Client> getAll(){
//		return clientRepository.getAll();
//	}
}
