package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.service.CottageService;

@RestController
@RequestMapping("/api/cottage")
public class CottageController {
	
	public CottageService cottageService;
	
	@Autowired
	public CottageController(CottageService cottageService) {
		this.cottageService = cottageService;
	}
	
	/*@GeMapping("/all")
	public ResponseEntity<List<Cottage>> getAllByOwner(){
		
	}*/

}
