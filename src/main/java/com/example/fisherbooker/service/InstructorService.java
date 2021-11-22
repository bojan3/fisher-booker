package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.InstructorRepository;

@Service
public class InstructorService {

	public InstructorRepository instructorrepository;

	@Autowired
	public InstructorService(InstructorRepository instructorRepository) {
		this.instructorrepository = instructorRepository;
	}
	
}
