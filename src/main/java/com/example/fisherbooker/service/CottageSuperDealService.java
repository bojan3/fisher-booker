package com.example.fisherbooker.service;

import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;

public interface CottageSuperDealService {
	public Boolean add(AddSuperDealDTO deal);
	
	public void sendNotification(Long id, CottageSuperDeal superDeal);
}