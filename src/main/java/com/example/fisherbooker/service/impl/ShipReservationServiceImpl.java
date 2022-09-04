package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.service.ShipReservationService;

@Service
public class ShipReservationServiceImpl implements ShipReservationService {
	
	private final int perPage = 5;

	@Autowired
	private ShipReservationRepository shipReservationRepository;
	
	public List<ReservationDetailsDTO> getReservationsByShipOwner(String username, int page) {
		Pageable pageObj = PageRequest.of(page, this.perPage);
		List<ShipReservation> reservations = this.shipReservationRepository.findByShipShipOwnerAccountUsernameOrderByStartDateDesc(username, pageObj);
		List<ReservationDetailsDTO> dtos = new ArrayList<ReservationDetailsDTO>();
		for(ShipReservation reservation: reservations) {
			dtos.add(reservation.toDTO());
		}
		return dtos;
	}
	
	public int getNumberOfReservations(String username) {
		List<ShipReservation> reservations = this.shipReservationRepository.findByShipShipOwnerAccountUsernameOrderByStartDateDesc(username);
		return reservations.size();
	}

}
