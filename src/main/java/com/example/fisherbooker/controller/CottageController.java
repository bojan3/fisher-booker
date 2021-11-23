package com.example.fisherbooker.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

//	@PostMapping("/add/{ownerId}")
//	public ResponseEntity<List<Cottage>> getAllByOwner(@RequestBody){
//		
//	}

}
