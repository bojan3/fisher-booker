package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.AdventureReservationRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;

@Service
public class FishingInstructorService {

	public FishingInstructorRepository fishinginstructorrepository;
	public AccountRepository accountrepository;
	public AdventureRepository adventurerepository;
	public AdventureReservationRepository adventurereservationrepository;

	@Autowired
	public FishingInstructorService(FishingInstructorRepository instructorRepository, AccountRepository accountrepository, AdventureRepository adventurerepository, AdventureReservationRepository adventurereservationrepository) {
		this.fishinginstructorrepository = instructorRepository;
		this.accountrepository = accountrepository;
		this.adventurerepository = adventurerepository;
		this.adventurereservationrepository = adventurereservationrepository;
	}
	
	public Boolean saveFishingInstructor(FishingInstructor f) {
		this.fishinginstructorrepository.save(f);
		return true;
	}
	
	public List<FishingInstructor> getAll(){
		return this.fishinginstructorrepository.findAll();
	}
	
	public FishingInstructor getById(Long id){
		return this.fishinginstructorrepository.getById(id);
	}

	public Set<AdventureDTO> getAllAdventuresByOwnerID(Long id) {
		FishingInstructor owner = this.fishinginstructorrepository.findOneById(id).orElse(null);
		return this.createCottageDTOs(owner.getAdventure());
	}
	
	
	public Set<AdventureDTO> getAllAdventuresByOwnerUsername(String username) {
		FishingInstructor owner = this.fishinginstructorrepository.findByAccountUsername(username).orElse(null);
		return this.createCottageDTOs(owner.getAdventure());
	}

	public List<FishingInstructor> getAllOrderByName() {
		
		return this.fishinginstructorrepository.findByOrderByAccountName();
	}
	
	
	
	
	public Set<AdventureDTO> createCottageDTOs(Set <Adventure> cottages){
		Set<AdventureDTO> cottageDTOs = new HashSet<AdventureDTO>();
		for (Adventure cottage : cottages) {
			cottageDTOs.add(AdventureDTO.createAdventureDTO(cottage));
		}
		return cottageDTOs;
	}

	public Optional<FishingInstructor> findOneById(Long id) {
		return this.fishinginstructorrepository.findById(id);
	}

	public void save(FishingInstructor fishinginstructor) {
		this.fishinginstructorrepository.save(fishinginstructor);		
	}
	
	public void deleteOne(Long instructor_id) {
		FishingInstructor fi =this.fishinginstructorrepository.findById(instructor_id).get();
		Set<Adventure> adventures = fi.getAdventure();
		for(Adventure ad : adventures) {
			ad.setIsDeleted(true);
			this.adventurerepository.save(ad);
	}
		
		Account acc = fi.getAccount();
		acc.setDeleted(true);
		this.accountrepository.save(acc);
	}

	public void deleteOne2(Long instructor_id) {
		System.out.println("instructor service method deleteOne");
		FishingInstructor fi =this.fishinginstructorrepository.findOneById(instructor_id).get();
	//	System.out.println(fi);
	//	long acc_id = fi.getAccount().getId();		
	//	Account acc = fi.getAccount();
	//	Set<Adventure> avanture = fi.getAdventure();
	//	System.out.println("ulazak u iteracije");
	//	System.out.println(fi);
	//	fi.removeAllAdventure();
		//for (Adventure a : fi.getAdventure()){		
		//}
		
	//	acc.setAddress(null);
	//	this.accountrepository.save(acc);  
	//	fi.setAccount(null);
		//fi.setBiography(null);
		System.out.println(fi);
	//	System.out.println(acc);

		
		//this.fishinginstructorrepository.save(fi);
    	//this.accountrepository.delete(acc);    
		this.fishinginstructorrepository.delete(fi);	
	}
}
