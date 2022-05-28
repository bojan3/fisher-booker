package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageOwnerDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.service.CottageOwnerService;

@RestController
@RequestMapping("/api/cottageOwner")
public class CottageOwnerController {
	
	private CottageOwnerService cottageOwnerService;

	@Autowired
	public CottageOwnerController(CottageOwnerService cottageOwnerService) {
		super();
		this.cottageOwnerService = cottageOwnerService;
	}
	
	@GetMapping("/allCottagesByOwner")
	public ResponseEntity<Set<CottageDTO>> getAllCottagesByOwner(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<CottageDTO> cottages = this.cottageOwnerService.getAllCottagesByOwner(username);
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CottageOwnerDTO>> getAll(){
		List<CottageOwner> cottageowners = this.cottageOwnerService.getAll();
		List<CottageOwnerDTO> cottageownersDTO = new ArrayList<CottageOwnerDTO>();
		for(CottageOwner cottageowner : cottageowners) {
			CottageOwnerDTO cottageownerDTO = CottageOwnerDTO.createCottageOwnerDTO(cottageowner);
			cottageownersDTO.add(cottageownerDTO);
		}
		return new ResponseEntity<>(cottageownersDTO, HttpStatus.OK);
	}
	
	
	
	
	
	
}
