package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipSuperDeal;
import com.example.fisherbooker.model.EmailContexts.SuperDealNotificationEmailContext;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageSuperDealRepository;
import com.example.fisherbooker.repository.ShipOptionRepository;
import com.example.fisherbooker.repository.ShipSuperDealRepository;
import com.example.fisherbooker.service.CottageSuperDealService;
import com.example.fisherbooker.service.EmailService;

@Service
public class CottageSuperDealImpl implements CottageSuperDealService {

	@Autowired
	private EmailService emailService;

	private CottageSuperDealRepository cottageSuperDealRepository;
	private ShipSuperDealRepository shipSuperDealRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ShipOptionRepository shipOptionRepository;
	private ClientRepository clientRepository;

	public CottageSuperDealImpl(CottageSuperDealRepository cottageSuperDealRepository,
			ShipSuperDealRepository shipSuperDealRepository, CottageOptionRepository cottageOptionRepository,
			ShipOptionRepository shipOptionRepository, ClientRepository clientRepository) {
		this.cottageSuperDealRepository = cottageSuperDealRepository;
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
		this.shipSuperDealRepository = shipSuperDealRepository;
		this.shipOptionRepository = shipOptionRepository;
	}

	public Boolean add(AddSuperDealDTO deal) {
		switch (deal.getType()) {
		case SHIP: {
			ShipSuperDeal newDeal = deal.toShipModel();
			for (Long i : deal.getOptions()) {
				ShipOption option = this.shipOptionRepository.findById(i).orElse(null);
				if (option != null) {
					newDeal.addOption(option);
				}
			}
			this.shipSuperDealRepository.save(newDeal);
			break;
		}
		case COTTAGE: {
			CottageSuperDeal newDeal = deal.toCottageModel();
			for (Long i : deal.getOptions()) {
				CottageOption option = this.cottageOptionRepository.findById(i).orElse(null);
				if (option != null) {
					newDeal.addOption(option);
				}
			}
			this.cottageSuperDealRepository.save(newDeal);
			break;
		}
		}

//		this.sendNotification(deal.getRealEstateId(), newDeal);
		return true;
	}

	public void sendNotification(Long id, CottageSuperDeal superDeal) {
		List<String> emails = this.clientRepository.getEmails(id);
		for (String email : emails) {
			SuperDealNotificationEmailContext dealContext = new SuperDealNotificationEmailContext();
			dealContext.init(email);
			dealContext.setSuperDealInfo(superDeal);
			try {
				emailService.sendMail(dealContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
