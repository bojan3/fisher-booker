package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriod;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;

@Service
public class StatsServiceImpl {

	private CottageReservationRepository cottageReservationRepository;
	private ShipReservationRepository shipReservationRepository;

	@Autowired
	StatsServiceImpl(CottageReservationRepository cottageReservationRepository,
			ShipReservationRepository shipReservationRepository) {
		this.cottageReservationRepository = cottageReservationRepository;
		this.shipReservationRepository = shipReservationRepository;
	}

	public List<Stats> getYearlyStats(String username, int year, RealEstateType type) {
		switch (type) {
		case COTTAGE: {
			return this.cottageReservationRepository.yearlyStats(username, year);
		}
		case SHIP: {
			return this.shipReservationRepository.yearlyStats(username, year);
		}
		}
		return null;
	}
	
	public List<Stats> getMonthlyStats(String username, int year, int month, RealEstateType type) {
		switch(type ) {
		case COTTAGE: {
			return this.cottageReservationRepository.monthlyStats(username, year, month);
		}
		case SHIP: {
			return this.shipReservationRepository.monthlyStats(username, year, month);
		}
		}
		return null;
	}
	
	public List<Stats> getArbitrarilyStats(String username, DatePeriod period, RealEstateType type) {
		System.out.println("start " + period.getStartDate());
		System.out.println("end " + period.getEndDate());
		switch(type ) {
		case COTTAGE: {
			return this.cottageReservationRepository.arbitrarilyStats(username, period.getStartDate(), period.getEndDate());
		}
		case SHIP: {
			return this.shipReservationRepository.arbitrarilyStats(username, period.getStartDate(), period.getEndDate());
		}
		}
		return null;
	}
	
	public List<Integer> getYears(String username) {
		return this.cottageReservationRepository.getYears(username);
	}

}
