package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.repository.ShipRepository;
import com.example.fisherbooker.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

	public ShipRepository shipRepository;

	@Autowired
	public ShipServiceImpl(ShipRepository shipRepository) {
		this.shipRepository = shipRepository;
	}

	public Boolean saveShip(Ship ship) {
		this.shipRepository.save(ship);
		return true;
	}

	public List<Ship> getAll() {
		return this.shipRepository.findAll();
	}

	public void deleteShip(Long id) {
		// TODO Auto-generated method stub
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

	public Boolean checkIfOwnerHasShip(String username, Long shipId) {
		List<Ship> ships = this.shipRepository.findByShipOwnerAccountUsername(username);
		for(Ship ship : ships) {
			System.out.println(ship.getShipOwner());
			if (ship.getId().equals(shipId)){
				return true;
			}
		}
		return false;
	}
}
