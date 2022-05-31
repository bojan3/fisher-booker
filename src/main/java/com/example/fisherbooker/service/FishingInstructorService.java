package com.example.fisherbooker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.repository.FishingInstructorRepository;

@Service
public class FishingInstructorService {

	public FishingInstructorRepository fishinginstructorrepository;

	@Autowired
	public FishingInstructorService(FishingInstructorRepository instructorRepository) {
		this.fishinginstructorrepository = instructorRepository;
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
}
