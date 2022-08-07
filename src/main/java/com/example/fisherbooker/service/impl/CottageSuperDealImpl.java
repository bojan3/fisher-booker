package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.SuperDealNotificationEmailContext;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageSuperDealRepository;
import com.example.fisherbooker.service.CottageSuperDealService;
import com.example.fisherbooker.service.EmailService;

@Service
public class CottageSuperDealImpl implements CottageSuperDealService {

	@Autowired
	private EmailService emailService;

	private CottageSuperDealRepository cottageSuperDealRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ClientRepository clientRepository;

	public CottageSuperDealImpl(CottageSuperDealRepository cottageSuperDealRepository,
			CottageOptionRepository cottageOptionRepository, ClientRepository clientRepository) {
		this.cottageSuperDealRepository = cottageSuperDealRepository;
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
	}

	public Boolean add(AddSuperDealDTO deal) {
		CottageSuperDeal newDeal = deal.toModel();
		for (Long i : deal.getOptions()) {
			CottageOption option = this.cottageOptionRepository.findById(i).orElse(null);
			System.out.println(i);
			if (option != null) {
				newDeal.addOption(option);
			}
		}
		this.cottageSuperDealRepository.save(newDeal);
		this.sendNotification(deal.getRealEstateId(), newDeal);
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
