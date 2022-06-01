package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.service.CottageService;
import com.example.fisherbooker.service.FishingInstructorService;

@RestController
@RequestMapping("/api/instructor")
public class FishingInstructorController {

	public FishingInstructorService FishingInstructorService;

	@Autowired
	public FishingInstructorController(FishingInstructorService FishingInstructorService) {
		this.FishingInstructorService = FishingInstructorService;
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<FishingInstructorDTO>> getAll(){
		List<FishingInstructor> fishinginstructors = this.FishingInstructorService.getAll();
		List<FishingInstructorDTO> FishingInstructorsDTO = new ArrayList<FishingInstructorDTO>();
		for(FishingInstructor fishinginstructor : fishinginstructors) {
			FishingInstructorDTO fishinginstructorDTO = FishingInstructorDTO.createFishingInstructorDTO(fishinginstructor);
			FishingInstructorsDTO.add(fishinginstructorDTO);
		}
		return new ResponseEntity<>(FishingInstructorsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/all/byName")
	public ResponseEntity<List<FishingInstructorDTO>> getAllOrderByName(){
		List<FishingInstructor> fishinginstructors = this.FishingInstructorService.getAllOrderByName();
		List<FishingInstructorDTO> FishingInstructorsDTO = new ArrayList<FishingInstructorDTO>();
		for(FishingInstructor fishinginstructor : fishinginstructors) {
			FishingInstructorDTO fishinginstructorDTO = FishingInstructorDTO.createFishingInstructorDTO(fishinginstructor);
			FishingInstructorsDTO.add(fishinginstructorDTO);
		}
		return new ResponseEntity<>(FishingInstructorsDTO, HttpStatus.OK);
	}
	

}
	
	
	

