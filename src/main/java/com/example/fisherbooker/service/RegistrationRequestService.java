package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.RegistrationRequestRepository;

@Service
public class RegistrationRequestService {

	public RegistrationRequestRepository RegistrationRequestRep;
	
	@Autowired
	public RegistrationRequestService(RegistrationRequestRepository r) {
		this.RegistrationRequestRep = r;
		
	}
	
	
}
