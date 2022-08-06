package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.service.CottageSuperDealService;

@RestController
@RequestMapping("/api/cottageSuperDeal")
public class CottageSuperDealController {
	
	@Autowired
	private CottageSuperDealService cottageSuperDealService;
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody AddSuperDealDTO deal) {
		this.cottageSuperDealService.add(deal);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
