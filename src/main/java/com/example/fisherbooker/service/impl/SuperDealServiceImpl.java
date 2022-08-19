package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipSuperDeal;
import com.example.fisherbooker.model.SuperDealNotificationEmailContext;
import com.example.fisherbooker.model.DTO.AddSuperDealDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageSuperDealRepository;
import com.example.fisherbooker.repository.ShipOptionRepository;
import com.example.fisherbooker.repository.ShipSuperDealRepository;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.SuperDealService;

@Service
public class SuperDealServiceImpl implements SuperDealService {

	@Autowired
	private EmailService emailService;
	
	@PersistenceContext
	EntityManager entityManager;

	private CottageSuperDealRepository cottageSuperDealRepository;
	private ShipSuperDealRepository shipSuperDealRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ShipOptionRepository shipOptionRepository;
	private ClientRepository clientRepository;

	public SuperDealServiceImpl(CottageSuperDealRepository cottageSuperDealRepository,
			ShipSuperDealRepository shipSuperDealRepository, CottageOptionRepository cottageOptionRepository,
			ShipOptionRepository shipOptionRepository, ClientRepository clientRepository) {
		this.cottageSuperDealRepository = cottageSuperDealRepository;
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
		this.shipSuperDealRepository = shipSuperDealRepository;
		this.shipOptionRepository = shipOptionRepository;
	}

	@Transactional()
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
			Ship ship = entityManager.find(Ship.class, deal.getRealEstateId(),
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			newDeal.setShip(ship);
			ship.addSuperDeal(newDeal);
			entityManager.persist(ship);
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
			Cottage cottage = entityManager.find(Cottage.class, deal.getRealEstateId(),
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			newDeal.setCottage(cottage);
			cottage.addSuperDeal(newDeal);
			entityManager.persist(cottage);
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

	public List<DatePeriodDTO> getDates(RealEstateType type, Long id) {
		List<DatePeriodDTO> dates = new ArrayList<>();
		switch (type) {
		case COTTAGE: {
			dates = this.cottageSuperDealRepository.getDates(id);
			break;
		}
		case SHIP: {
			dates = this.shipSuperDealRepository.getDates(id);
			break;
		}
		}
		return dates;
	}

}
