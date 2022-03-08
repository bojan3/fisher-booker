package com.example.fisherbooker.service;

import java.util.List;
import java.util.Set;

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
	
	public List<Cottage> getAllbyName(){
		return this.cottageRepository.findByOrderByName();	
	}

	public List<Cottage> getAllbyPrice(){
		return this.cottageRepository.findByOrderByPricePerDay();	
	}
	
	public Cottage getById(Long id) {
		return this.cottageRepository.findById(id).orElse(null);
	}
	
	public List<Cottage> getAllbyRate(){
		return this.cottageRepository.findByOrderByAverageMarkDesc();	
	}
	
}
