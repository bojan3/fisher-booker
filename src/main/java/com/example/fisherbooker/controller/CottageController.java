package com.example.fisherbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.service.CottageService;

@RestController
@RequestMapping("/api/cottage")
public class CottageController {
	
	public CottageService cottageService;
	
	@Autowired
	public CottageController(CottageService cottageService) {
		this.cottageService = cottageService;
	}
	
	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
	@PostMapping("/add/{ownerId}")
	public ResponseEntity<Boolean> getAllByOwner(@RequestBody Cottage cottage){
		this.cottageService.saveCottage(cottage);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Cottage>> getAll(){
		List<Cottage> cottages = this.cottageService.getAll();
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}
	
	

}
