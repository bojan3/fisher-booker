package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.service.AdventureService;

@RestController
@RequestMapping("/api/adventure")
public class AdventureController {
public AdventureService adventureService;
	
	@Autowired
	public AdventureController(AdventureService adventureService) {
		this.adventureService = adventureService;
	}
	
}
