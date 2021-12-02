package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.repository.CottageRepository;

@Service
public class CottageService {
	
	public CottageRepository cottageRepository;

	@Autowired
	public CottageService(CottageRepository cottageRepository) {
		this.cottageRepository = cottageRepository;
	}
	
	public Boolean saveCottage(Cottage cottage) {
		this.cottageRepository.save(cottage);
		return true;
	}
	
}
