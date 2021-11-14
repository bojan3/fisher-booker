package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.ShipOwnerRepository;

@Service
public class CottageOwnerService {
	
		public CottageOwnerRepository cottageownerrepository;

		@Autowired
		public CottageOwnerService(CottageOwnerRepository cottageownerRepository) {
			this.cottageownerrepository = cottageownerRepository;
		}
		
		
		
		
		
		
		
		
		
		
		
	}

