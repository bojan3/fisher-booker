package com.example.fisherbooker.service.impl;

import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageSuperDealRepository;
import com.example.fisherbooker.service.CottageSuperDealService;

@Service
public class CottageSuperDealImpl implements CottageSuperDealService {
	private CottageSuperDealRepository cottageSuperDealRepository;
	private CottageOptionRepository cottageOptionRepository;
	public CottageSuperDealImpl(CottageSuperDealRepository cottageSuperDealRepository,
			CottageOptionRepository cottageOptionRepository) {
		this.cottageSuperDealRepository = cottageSuperDealRepository;
		this.cottageOptionRepository = cottageOptionRepository;
	}
	
	public Boolean add(AddSuperDealDTO deal) {
		CottageSuperDeal newDeal = deal.toModel();
		for(Long i: deal.getOptions()) {
			CottageOption option = this.cottageOptionRepository.findById(i).orElse(null);
			System.out.println(i);
			if(option != null) {
				System.out.println("added");
				newDeal.addOption(option);
				option.addSuperDeal(newDeal);
			}
		}
		this.cottageSuperDealRepository.save(newDeal);
		return true;
	}
}
