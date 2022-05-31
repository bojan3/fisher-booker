package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.repository.ShipRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

	private ShipRepository shipRepository;
	private ShipReservationRepository shipReservationRepository;

	@Autowired
	public ShipServiceImpl(ShipRepository shipRepository, ShipReservationRepository shipReservationRepository) {
		this.shipRepository = shipRepository;
		this.shipReservationRepository = shipReservationRepository;
	}

	public Boolean saveShip(Ship ship) {
		this.shipRepository.save(ship);
		return true;
	}

	public List<Ship> getAll() {
		return this.shipRepository.findAll();
	}

	public void deleteShip(Long id) {
		this.shipRepository.deleteById(id);
	}

	public List<Ship> getAllByName() {
		return this.shipRepository.findByOrderByName();
	}

	public List<Ship> getAllByAverageMark() {
		return this.shipRepository.findByOrderByAverageMarkDesc();
	}

	public List<Ship> getAllByRentPrice() {
		return this.shipRepository.findByOrderByRentPrice();
	}

	public List<Ship> getAllByCapacity() {
		return this.shipRepository.findByOrderByCapacityDesc();
	}
	
	public List<Ship> getAllByOwnerUsername(String username){
		return this.shipRepository.findByShipOwnerAccountUsername(username);
	}

	public Boolean checkIfOwnerHasShip(String username, Long shipId) {
		List<Ship> ships = this.shipRepository.findByShipOwnerAccountUsername(username);
		for (Ship ship : ships) {
			System.out.println(ship.getShipOwner());
			if (ship.getId().equals(shipId)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean checkIfShipHasReservation(Long id) {
		List<ShipReservation> reservations = this.shipReservationRepository.findByShipId(id);
		return !reservations.isEmpty();
	}
}
