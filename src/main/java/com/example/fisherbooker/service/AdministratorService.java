package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.AdministratorRepository;
import com.example.fisherbooker.repository.CottageRepository;

@Service
public class AdministratorService {
	public AdministratorRepository adminRepository;
	

	@Autowired
	public AdministratorService(AdministratorRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
}
