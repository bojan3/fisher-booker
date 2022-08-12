package com.example.fisherbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.GlobalNumber;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.AdventureReservationRepository;
import com.example.fisherbooker.repository.GlobalNumberRepository;

@Service
public class GlobalNumberService {

	private GlobalNumberRepository gnr;
	 
	@Autowired
	public GlobalNumberService (GlobalNumberRepository gnr) {
		this.gnr = gnr;	
	}
	
	public GlobalNumber GetByID(Long id) {
		return this.gnr.findById(id).get();
		
	}

	public void Save(GlobalNumber gn) {
		// TODO Auto-generated method stub
		this.gnr.save(gn);
		
	}
	
}
