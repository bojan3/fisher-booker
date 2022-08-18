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

	public AdventureReservationRepository arr;
	public AdventureRepository ar;
	@Autowired
	public AdventureReservationService (AdventureReservationRepository arr, AdventureRepository ar) {
		
		this.ar=ar;
		this.arr = arr;	
	}
	
	
	public void Save(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	
	}

	
	
	

	public void saveAdventureReservation(AdventureReservation adventure) {
           arr.save(adventure);		
	}


	public List<AdventureReservation> getAll() {
		return arr.findAll();
	}


	public void deleteById(Long id) {
    //    AdventureReservation adventurereservation =	this.arr.findById(id).get();
		
        //if(!adventurereservation.equals(null)) {
     //  Adventure adventure = adventurereservation.getAdventure();
        
      //  if(adventure.getAdventureReservation().remove(adventure)){
      //  adventure.setAdventureReservation(adventure.getAdventureReservation());
      //  this.ar.save(adventure);
       // }
		 this.arr.deleteById(id);
      //  }
	}


	public AdventureReservation getById(Long id) {
		return this.arr.getById(id);
	}
		
   public Optional<AdventureReservation> findOneById(Long id){
	   return arr.findById(id);
   }



public List<AdventureReservation> getAllByAdventure(Long adventureID) {
	List<AdventureReservation> sve = arr.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.adventure.getId().equals(adventureID)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}


public List<AdventureReservation> getAllByClient(Client client) {
	List<AdventureReservation> sve = arr.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.client.getAccount().getId().equals(client.account.getId())) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}

public List<AdventureReservation> getAllByInstructor(Long fishingInstructor) {
	List<AdventureReservation> sve = arr.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.getAdventure().getFishingInstructor().getId().equals(fishingInstructor)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}

public List<AdventureReservation> getAllByInstructorAccountUsername(String username) {
	List<AdventureReservation> sve = arr.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.getAdventure().getFishingInstructor().getAccount().getUsername().equals(username)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}




		
		
	}