package com.example.fisherbooker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.CottageOwner;
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

//	public Boolean Update(Adventure adventure) {
//		return this.ar.update(adventure);
//	}
	
	
	public Adventure saveAdventure(Adventure adventure) {
          return this.ar.save(adventure);		
	}


	public List<Adventure> getAll() {
		return ar.findAll();
	}


	public Adventure deleteById(Long id) {
        return ar.deleteAllById(id);	
	}


	public Adventure getById(Long id) {
		return ar.getById(id);
	}
		
   public Optional<Adventure> findOneById(Long id){
	   return ar.findById(id);
   }

public List<Adventure> getAllByName() {
	// TODO Auto-generated method stub
	return ar.findByOrderByName();
}
	
public List<Adventure> getAllByRentPrice() {
	// TODO Auto-generated method stub
	return ar.findByOrderByPrice();
}

public List<Adventure> getAllByAverageMark() {
	// TODO Auto-generated method stub
	return ar.findByOrderByName();
}


public List<Adventure> getAllByCapacity() {
	// TODO Auto-generated method stub
	return ar.findByOrderByName();
}




public Boolean checkIfOwnerHasAdventure(String username, Long adventureId) {
	List<Adventure> adventures = this.ar.findByFishingInstructorAccountUsername(username);
	for(Adventure adventure : adventures) {
		System.out.println(adventure.getFishingInstructor());
		if (adventure.getId().equals(adventureId)){
			return true;
		}
	}
	return false;
}














}
	
	

