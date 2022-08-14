package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.CottageReservationDetailsDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.service.CottageReservationService;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {

	@Autowired
	private CottageReservationRepository cottageReservationRepository;

	public List<Stats> getYearlyStats(String username, int year) {
		return this.cottageReservationRepository.yearlyStats(username, year);
	}

	public List<Integer> getYears(String username) {
		return this.cottageReservationRepository.getYears(username);
	}

	public List<DatePeriodDTO> getReservationDates(Long cottageId) {
		return this.cottageReservationRepository.getReservationDates(cottageId);
	}
	
	public CottageReservation getReservationByDateAndCottage(Long id, Date date) {
		return this.cottageReservationRepository.getReservationByDateAndCottage(id, date);
	}
	
	public List<CottageReservationDetailsDTO> getReservationsByCottageOwner(String username) {
		List<CottageReservation> reservations = this.cottageReservationRepository.findByCottageCottageOwnerAccountUsername(username);
		List<CottageReservationDetailsDTO> dtos = new ArrayList<CottageReservationDetailsDTO>();
		for(CottageReservation reservation: reservations) {
			dtos.add(reservation.toDTO());
		}
		return dtos;
	}

}
