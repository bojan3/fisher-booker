package com.example.fisherbooker.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.AdventureReservationRepository;

@Service
public class AdventureReservationService {

	public AdventureReservationRepository ar;
	@Autowired
	public AdventureReservationService (AdventureReservationRepository ar) {
		
		this.ar=ar;
		
	}
	
	
	public void Save(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	
	}


	public void saveAdventureReservation(AdventureReservation adventure) {
           ar.save(adventure);		
	}


	public List<AdventureReservation> getAll() {
		return ar.findAll();
	}


	public AdventureReservation deleteById(Long id) {
        return ar.deleteAllById(id);	
	}


	public AdventureReservation getById(Long id) {
		return ar.getById(id);
	}
		
   public Optional<AdventureReservation> findOneById(Long id){
	   return ar.findById(id);
   }



public List<AdventureReservation> getAllByAdventure(Long adventureID) {
	List<AdventureReservation> sve = ar.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.adventure.getId().equals(adventureID)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}


public List<AdventureReservation> getAllByClient(Client client) {
	List<AdventureReservation> sve = ar.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.client.getAccount().getId().equals(client.account.getId())) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}

public List<AdventureReservation> getAllByInstructor(FishingInstructor fishingInstructor) {
	List<AdventureReservation> sve = ar.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.adventure.fishingInstructor.getAccount().getId().equals(fishingInstructor.account.getId())) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}






		
		
	}