package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.service.CottageReservationService;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {

	@Autowired
	private CottageReservationRepository cottageReservationRepository;

	public List<Stats> getYearlyStats(String username, int year) {
		System.out.println("joho");
		System.out.println(username);
		System.out.println(year);
		return this.cottageReservationRepository.yearlyStats(username, year);
	}
	
	public List<Integer> getYears(String username){
		return this.cottageReservationRepository.getYears(username);
	}

}
