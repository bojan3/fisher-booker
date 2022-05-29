package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Ship;

public interface ShipService {
	public Boolean saveShip(Ship ship);

	public List<Ship> getAll();

	public void deleteShip(Long id);

	public List<Ship> getAllByName();

	public List<Ship> getAllByAverageMark();

	public List<Ship> getAllByRentPrice();

	public List<Ship> getAllByCapacity();
	
	public Boolean checkIfOwnerHasShip(String username, Long shipId);
}
