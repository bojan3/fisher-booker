package com.example.fisherbooker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.service.CottageOwnerService;

@RestController
@RequestMapping("/api/cottage")
public class CottageOwnerController {
	
	private CottageOwnerService cottageOwnerService;

	@Autowired
	public CottageOwnerController(CottageOwnerService cottageOwnerService) {
		super();
		this.cottageOwnerService = cottageOwnerService;
	}
	
	@GetMapping("/allCottagesByOwner/{id}")
	public ResponseEntity<Set<Cottage>> getAllCottagesByOwner(@PathVariable Long id){
		Set<Cottage> cottages = this.cottageOwnerService.getAllCottagesByOwner(id);
		return new ResponseEntity<>(cottages, HttpStatus.OK);
	}
	

}
