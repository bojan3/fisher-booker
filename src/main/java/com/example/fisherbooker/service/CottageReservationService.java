package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.CottageReservationDetailsDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

public interface CottageReservationService {
	public List<Stats> getYearlyStats(String username, int year);
	
	public List<Integer> getYears(String username);
	
	public List<DatePeriodDTO> getReservationDates(Long cottageId);
	
	public List<CottageReservationDetailsDTO> getReservationsByCottageOwner(String username);
}
