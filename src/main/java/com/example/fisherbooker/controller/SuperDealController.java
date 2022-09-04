package com.example.fisherbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.service.SuperDealService;

@RestController
@RequestMapping("/api/superDeal")
public class SuperDealController {
	
	@Autowired
	private SuperDealService cottageSuperDealService;
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody AddSuperDealDTO deal) {
		this.cottageSuperDealService.add(deal);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/dates/{type}/{id}")
	public ResponseEntity<List<DatePeriodDTO>> getDates(@PathVariable RealEstateType type, @PathVariable Long id) {
		List<DatePeriodDTO> dates = this.cottageSuperDealService.getDates(type, id);
		return new ResponseEntity<>(dates, HttpStatus.OK);
	}
}
