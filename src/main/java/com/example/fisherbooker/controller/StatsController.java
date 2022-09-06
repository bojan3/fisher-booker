package com.example.fisherbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriod;
import com.example.fisherbooker.model.DTO.RatingDTO;
import com.example.fisherbooker.service.impl.StatsServiceImpl;

@RestController
@RequestMapping(value = "/api/stats", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatsController {

	@Autowired
	private StatsServiceImpl statsService;

	@GetMapping("/{type}/yearly/{year}")
	public ResponseEntity<List<Stats>> getYearlyStats(@PathVariable RealEstateType type, @PathVariable int year) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.statsService.getYearlyStats(username, year, type);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}

	@GetMapping("{type}/monthly/{year}/{month}")
	public ResponseEntity<List<Stats>> getMonthlyStats(@PathVariable RealEstateType type, @PathVariable int year,
			@PathVariable int month) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.statsService.getMonthlyStats(username, year, month, type);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}

	@PostMapping("{type}/arbitrarily")
	public ResponseEntity<List<Stats>> getArbitrarilyStats(@PathVariable RealEstateType type,
			@RequestBody DatePeriod period) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Stats> stats = this.statsService.getArbitrarilyStats(username, period, type);
		System.out.println(stats);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}

	@GetMapping("{type}/years")
	public ResponseEntity<List<Integer>> getYears(@PathVariable RealEstateType type) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		List<Integer> years = this.statsService.getYears(username, type);

		return new ResponseEntity<>(years, HttpStatus.OK);
	}
	
	@GetMapping("{type}/ratings")
	public ResponseEntity<List<RatingDTO>> getRatings(@PathVariable RealEstateType type) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		List<RatingDTO> ratings = this.statsService.getRatings(username, type);

		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

}
