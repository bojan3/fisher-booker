package com.example.fisherbooker.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.repository.ShipOwnerRepository;


@Service
public class ShipOwnerService {
	public ShipOwnerRepository shipownerrepository;

	@Autowired
	public ShipOwnerService(ShipOwnerRepository shipownerRepository) {
		this.shipownerrepository = shipownerRepository;
	}


	public List<ShipOwner> getAll() {
		// TODO Auto-generated method stub
		return this.shipownerrepository.findAll();
	}
}
