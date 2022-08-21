package com.example.fisherbooker.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.service.CottageReservationService;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {
	
	private final int perPage = 5;

	@Autowired
	private CottageReservationRepository cottageReservationRepository;

	public List<Stats> getYearlyStats(String username, int year) {
		return this.cottageReservationRepository.yearlyStats(username, year);
	}
	
	public List<Stats> getMonthlyStats(String username, int year, int month) {
		return this.cottageReservationRepository.monthlyStats(username, year, month);
	}
	
	public List<Stats> getArbitrarilyStats(String username, Timestamp startDate, Timestamp endDate) {
		return this.cottageReservationRepository.arbitrarilyStats(username, startDate, endDate);
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
	
	public List<ReservationDetailsDTO> getReservationsByCottageOwner(String username, int page) {
		Pageable pageObj = PageRequest.of(page, this.perPage);
		List<CottageReservation> reservations = this.cottageReservationRepository.findByCottageCottageOwnerAccountUsernameOrderByStartDateDesc(username, pageObj);
		List<ReservationDetailsDTO> dtos = new ArrayList<ReservationDetailsDTO>();
		for(CottageReservation reservation: reservations) {
			dtos.add(reservation.toDTO());
		}
		return dtos;
	}
	
	public int getNumberOfReservations(String username) {
		List<CottageReservation> reservations = this.cottageReservationRepository.findByCottageCottageOwnerAccountUsernameOrderByStartDateDesc(username);
		return reservations.size();
	}

}
