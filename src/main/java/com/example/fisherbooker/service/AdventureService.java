package com.example.fisherbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
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


	public void saveAdventure(Adventure adventure) {
           ar.save(adventure);		
	}


	public List<Adventure> getAll() {
		return ar.findAll();
	}

	public List<Adventure> getAllByName(){
		return ar.findByOrderByName();
	}
	
	public List<Adventure> getAllByPrice(){
		return ar.findByOrderByPrice();
	}
	
	public List<Adventure> getAllByCapacity(){
		return ar.findByOrderByCapacityDesc();
	}
	
	public Adventure deleteById(Long id) {
        return ar.deleteAllById(id);	
	}
		
	
		
		
		
	}
	
	

