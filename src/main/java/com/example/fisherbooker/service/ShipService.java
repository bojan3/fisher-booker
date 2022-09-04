package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.DTO.AddShipDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;

public interface ShipService {
	public Boolean saveShip(AddShipDTO ship);

	public void delete(Long id);
	
	public Ship getById(Long id);

	public List<Ship> getAll();

	public void deleteShip(Long id);

	public List<Ship> getAllByName();

	public List<Ship> getAllByAverageMark();

	public List<Ship> getAllByRentPrice();

	public List<Ship> getAllByCapacity();

	public List<Ship> getAllByOwnerUsername(String username);

	public Boolean checkIfOwnerHasShip(String username, Long shipId);

	public List<ShipDTO> deleteShipDTO(Long id);

	public Boolean checkIfShipHasReservation(Long id);

	public List<Ship> getAllSorted(String type, String order);

	public List<ShipOption> getOptions(Long shipId);

	public Boolean checkOwnership(Long id);
}
