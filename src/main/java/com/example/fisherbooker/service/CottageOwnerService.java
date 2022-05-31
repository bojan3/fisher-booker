package com.example.fisherbooker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {
	
	private CottageOwnerRepository cottageOwnerRepository;

	@Autowired
	public CottageOwnerService(CottageOwnerRepository cottageOwnerRepository) {
		super();
		this.cottageOwnerRepository = cottageOwnerRepository;
	}
	
	public Set<CottageDTO> getAllCottagesByOwner(String username){
		CottageOwner owner = this.cottageOwnerRepository.findOneByAccountUsername(username).orElse(null);
		return this.createCottageDTOs(owner.getCottages());
	}
	
	public Set<CottageDTO> createCottageDTOs(Set<Cottage> cottages){
		Set<CottageDTO> cottageDTOs = new HashSet<CottageDTO>();
		for (Cottage cottage : cottages) {
			cottageDTOs.add(CottageDTO.createCottageDTO(cottage));
		}
		return cottageDTOs;
	}
	
	public List<CottageOwner> getAll(){
		return this.cottageOwnerRepository.findAll();
	}

	public void save(CottageOwner cottageowner) {
		
		this.cottageOwnerRepository.save(cottageowner);
		
	}
	

}
