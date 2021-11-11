package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.CottageRepository;

@Service
public class CottageService {
	
	public CottageRepository cottageRepository;

	@Autowired
	public CottageService(CottageRepository cottageRepository) {
		this.cottageRepository = cottageRepository;
	}
	
	/*public List<Cottage> getAllByOwner(){
		
	}*/
}
