package com.example.fisherbooker.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.service.CottageReservationService;

@RestController
@RequestMapping(value = "/api/stats", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatsController {

	@Autowired
	private CottageReservationService cottageReservationService;

	@GetMapping("/{type}/yearly/{year}")
	public ResponseEntity<List<Stats>> getYearlyStats(@PathVariable RealEstateType type, @PathVariable int year) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.cottageReservationService.getYearlyStats(username, year);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}
	
	@GetMapping("{type}/monthly/{year}/{month}")
	public ResponseEntity<List<Stats>> getMonthlyStats(@PathVariable RealEstateType type, @PathVariable int year, @PathVariable int month) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.cottageReservationService.getMonthlyStats(username, year, month);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}
	
	@GetMapping("{type}/arbitrarily/{startdDate}/{endDate}")
	public ResponseEntity<List<Stats>> getArbitrarilyStats(@PathVariable RealEstateType type, @PathVariable Timestamp startDate, @PathVariable Timestamp endDate) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.cottageReservationService.getArbitrarilyStats(username, startDate, endDate);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}
	
	@GetMapping("/years")
	public ResponseEntity<List<Integer>> getYears() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Integer> years = this.cottageReservationService.getYears(username);
		return new ResponseEntity<>(years, HttpStatus.OK);
	}

}
