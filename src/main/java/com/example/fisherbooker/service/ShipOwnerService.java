package com.example.fisherbooker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.repository.ShipOwnerRepository;


@Service
public class ShipOwnerService {
	public ShipOwnerRepository shipOwnerRepository;

	@Autowired
	public ShipOwnerService(ShipOwnerRepository shipOwnerRepository) {
		this.shipOwnerRepository = shipOwnerRepository;
	}
	
	public Set<ShipDTO> getAllShipsByOwner(String username){
		ShipOwner owner = this.shipOwnerRepository.findOneByAccountUsername(username).orElse(null);
		return this.createShipDTOs(owner.getShips());
	}
	
	public Set<ShipDTO> createShipDTOs(Set<Ship> ships){
		Set<ShipDTO> shipDTOs = new HashSet<ShipDTO>();
		for (Ship ship : ships) {
			shipDTOs.add(ShipDTO.createShipDTO(ship));
		}
		return shipDTOs;
	}
	
	public List<ShipOwner> getAll() {
		// TODO Auto-generated method stub
		return this.shipOwnerRepository.findAll();
	}
}
