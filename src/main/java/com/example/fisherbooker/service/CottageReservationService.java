package com.example.fisherbooker.service;

import java.sql.Timestamp;
import java.util.List;

import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;

public interface CottageReservationService {
	public List<Stats> getYearlyStats(String username, int year);
	
	public List<Stats> getMonthlyStats(String username, int year, int month);
	
	public List<Stats> getArbitrarilyStats(String username, Timestamp stardDate, Timestamp endDate);
	
	public List<Integer> getYears(String username);
	
	public List<DatePeriodDTO> getReservationDates(Long cottageId);
	
	public List<ReservationDetailsDTO> getReservationsByCottageOwner(String username, int page);
	
	public int getNumberOfReservations(String username);
}
