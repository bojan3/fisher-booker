package com.example.fisherbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.repository.AdventureOptionsRepository;
import com.example.fisherbooker.repository.AdventureRepository;

@Service
public class AdventureOptionsService {

	public AdventureOptionsRepository ar;
	@Autowired
	public AdventureOptionsService (AdventureOptionsRepository ar) {
		
		this.ar=ar;
		
	}
	
	
//	public void Save(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	
//	}


	public void saveAdventureOption(AdventureOption adventure) {
           ar.save(adventure);		
	}


	public List<AdventureOption> getAll() {
		return ar.findAll();
	}


//	public Adventure deleteById(Long id) {
    //    return ar.deleteAllById(id);	
	//}
		

		
		
		
	}
	
