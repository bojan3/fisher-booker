package com.example.fisherbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.repository.FishingInstructorRepository;

@Service
public class FishingInstructorService {

	public FishingInstructorRepository FishingInstructorRepository;

	@Autowired
	public FishingInstructorService(FishingInstructorRepository instructorRepository) {
		this.FishingInstructorRepository = instructorRepository;
	}
	
	public Boolean saveFishingInstructor(FishingInstructor f) {
		this.FishingInstructorRepository.save(f);
		return true;
	}
	
	public List<FishingInstructor> getAll(){
		return this.FishingInstructorRepository.findAll();
	}
	
	public FishingInstructor getById(Long id){
		return this.FishingInstructorRepository.getById(id);
	}
	
	
	
	
	
	
	
}
