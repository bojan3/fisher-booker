package com.example.fisherbooker.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.DTO.AddShipDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.model.DTO.ShipDTO;

public interface ShipService {
	public Boolean saveShip(AddShipDTO ship);

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
	
	public Boolean uploadImage(Long id, MultipartFile image) throws IOException;
	
	public Boolean deleteImage(Long id);

	public List<Ship> searchShips(SearchFilter searchFilter);

	public List<String> getShipLocations();
}
