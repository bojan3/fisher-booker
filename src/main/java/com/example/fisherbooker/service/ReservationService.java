package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.DTO.AddReservationDTO;
import com.example.fisherbooker.model.DTO.CreateSuperDealReservation;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

public interface ReservationService {
	
	public List<DatePeriodDTO> getDates(RealEstateType type, Long id);
	
	public Boolean addByClient(AddReservationDTO reservation);
	
	public Boolean addByOwner(AddReservationDTO reservation);
	
	public Boolean addingProcedure(AddReservationDTO reservation, Client c);

	public Boolean addByClientSuperDeal(CreateSuperDealReservation superDealReservation);

}
