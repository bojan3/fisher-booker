package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.ShipDTO;

public interface ShipService {
	public Boolean saveShip(Ship ship);
	
	public Ship getById(Long id);

	public List<Ship> getAll();

	public void deleteShip(Long id);

	public List<Ship> getAllByName();

	public List<Ship> getAllByAverageMark();

	public List<Ship> getAllByRentPrice();

	public List<Ship> getAllByCapacity();

	public List<Ship> getAllByOwnerUsername(String username);

	public Boolean checkIfOwnerHasShip(String username, Long shipId);

	public Boolean checkIfShipHasReservation(Long id);
}
