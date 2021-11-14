package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.AdventureRepository;

@Service
public class AdventureService {

	public AdventureRepository ar;
	@Autowired
	public AdventureService (AdventureRepository ar) {
		
		this.ar=ar;
		
	}
	
	
}
