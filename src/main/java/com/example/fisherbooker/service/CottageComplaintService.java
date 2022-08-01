package com.example.fisherbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.fisherbooker.repository.CottageComplaintRepository;

public class CottageComplaintService {

	public CottageComplaintRepository cottagecomplaintrepository;

	@Autowired
	public CottageComplaintService(CottageComplaintRepository ctr) {
		this.cottagecomplaintrepository = ctr;
	}

}

