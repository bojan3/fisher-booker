package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.InstructorComplaintRepository;

@Service
public class InstructorComplaintService {

	
	public InstructorComplaintRepository instructorcomplaintrepository;

	@Autowired
	public InstructorComplaintService(InstructorComplaintRepository icr) {
		this.instructorcomplaintrepository = icr;
	}

}
