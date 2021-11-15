package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.repository.AdventureRepository;

@Service
public class AdventureService {

	public AdventureRepository ar;
	@Autowired
	public AdventureService (AdventureRepository ar) {
		
		this.ar=ar;
		
	}
	
	
	public void Save(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	
	
		
		
		
		
		
	
	}
		

		
		
		
	}
	
	

