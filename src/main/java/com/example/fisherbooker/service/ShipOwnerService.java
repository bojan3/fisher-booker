package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.ShipOwnerRepository;


@Service
public class ShipOwnerService {
	public ShipOwnerRepository shipownerrepository;

	@Autowired
	public ShipOwnerService(ShipOwnerRepository shipownerRepository) {
		this.shipownerrepository = shipownerRepository;
	}
}
