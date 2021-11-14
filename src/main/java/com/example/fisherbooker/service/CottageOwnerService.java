package com.example.fisherbooker.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {
	
	private CottageOwnerRepository cottageOwnerRepository;

	@Autowired
	public CottageOwnerService(CottageOwnerRepository cottageOwnerRepository) {
		super();
		this.cottageOwnerRepository = cottageOwnerRepository;
	}
	
	public Set<Cottage> getAllCottagesByOwner(Long id){
		CottageOwner owner = this.cottageOwnerRepository.findOneById(id).orElse(null);
		System.out.println(this.cottageOwnerRepository.findAll());
		return owner.getCottages();
	}
	

}
