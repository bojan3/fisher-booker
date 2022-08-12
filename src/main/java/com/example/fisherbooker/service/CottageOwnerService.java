package com.example.fisherbooker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {
	
	private CottageOwnerRepository cottageOwnerRepository;
	private AccountRepository accrep;
	
	@Autowired
	public CottageOwnerService(CottageOwnerRepository cottageOwnerRepository, AccountRepository accrep) {
		super();
		this.cottageOwnerRepository = cottageOwnerRepository;
		this.accrep = accrep;
	}
	
	public Set<CottageDTO> getAllCottagesByOwner(String username){
		CottageOwner owner = this.cottageOwnerRepository.findOneByAccountUsername(username).orElse(null);
		System.out.println("account " + owner);
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
	
	public void deleteOne(Long cottageowner_id) {
		CottageOwner co =this.cottageOwnerRepository.findById(cottageowner_id).get();
		System.out.println(co);
	//	long acc_id = fi.getAccount().getId();		
	//	Account acc = co.getAccount();
	//	Set<Adventure> avanture = fi.getAdventure();
		System.out.println("brisanje vikendica odavde");
		System.out.println(co);

		//co.removeAllCottage();
		//for (Adventure a : fi.getAdventure()){		
		//}
		System.out.println(co);
	
		System.out.println("skidanje adrese");
		
	//	acc.setAddress(null);
	//	this.accrep.save(acc);  
		
	//	co.setAccount(null);
		System.out.println("posle skinutog naloga");
		System.out.println(co);
		System.out.println("///////////////////////////////////////////////");
		System.out.println("nalog koji se brise iz baze:");
	//	System.out.println(acc);
		System.out.print(co.getCottages());
	//	this.cottageOwnerRepository.save(co);
    	//this.accrep.delete(acc);    
		this.cottageOwnerRepository.delete(co);	
	}
	

}
