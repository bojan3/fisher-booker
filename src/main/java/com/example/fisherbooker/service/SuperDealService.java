package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

public interface SuperDealService {
	public Boolean add(AddSuperDealDTO deal);
	
	public void sendNotification(Long id, CottageSuperDeal superDeal);
	
	public List<DatePeriodDTO> getDates(RealEstateType type, Long id);
}