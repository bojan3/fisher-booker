package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.InstructorComplaintRepository;
import com.example.fisherbooker.repository.ShipComplaintRepository;

@Service
public class ShipComplaintService {

	public ShipComplaintRepository shipcomplaintrepository;

	@Autowired
	public ShipComplaintService(ShipComplaintRepository shr) {
		this.shipcomplaintrepository = shr;
	}

}