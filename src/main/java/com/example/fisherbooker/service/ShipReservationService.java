package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;

public interface ShipReservationService {

	public List<ReservationDetailsDTO> getReservationsByShipOwner(String username, int page);
	public int getNumberOfReservations(String username);
	
}
