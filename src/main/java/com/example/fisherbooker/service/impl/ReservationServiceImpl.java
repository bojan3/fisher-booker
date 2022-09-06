package com.example.fisherbooker.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.RealEstateType;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipSuperDeal;
import com.example.fisherbooker.model.Status;
import com.example.fisherbooker.model.DTO.AddReservationDTO;
import com.example.fisherbooker.model.DTO.CreateSuperDealReservation;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.repository.AdventureOptionsRepository;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.repository.CottageSuperDealRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.ShipOptionRepository;
import com.example.fisherbooker.repository.ShipOwnerRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.repository.ShipSuperDealRepository;
import com.example.fisherbooker.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@PersistenceContext
	EntityManager entityManager;

	private CottageReservationRepository cottageReservationRepository;
	private ShipReservationRepository shipReservationRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ShipOptionRepository shipOptionRepository;
	private ClientRepository clientRepository;
	private FishingInstructorRepository instructorRepository;
	private ShipOwnerRepository shipOwnerRepository;
	private CottageOwnerRepository cottageOwnerRepository;

	
	private CottageSuperDealRepository cottageSuperDealRepository;
	private ShipSuperDealRepository shipSuperDealRepository;
	private AdventureOptionsRepository adventureOptionsRepository;

	public ReservationServiceImpl(CottageOptionRepository cottageOptionRepository,
			ShipOptionRepository shipOptionRepository, ClientRepository clientRepository,
			CottageReservationRepository cottageReservationRepository,
			ShipReservationRepository shipReservationRepository, CottageSuperDealRepository cottageSuperDealRepository,
			ShipSuperDealRepository shipSuperDealRepository, AdventureOptionsRepository adventureOptionsRepository,
			FishingInstructorRepository instructorRepository, ShipOwnerRepository shipOwnerRepository,
			CottageOwnerRepository cottageOwnerRepository) {
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
		this.shipOptionRepository = shipOptionRepository;
		this.cottageReservationRepository = cottageReservationRepository;
		this.shipReservationRepository = shipReservationRepository;
		this.cottageSuperDealRepository = cottageSuperDealRepository;
		this.shipSuperDealRepository = shipSuperDealRepository;
		this.adventureOptionsRepository = adventureOptionsRepository;
		this.instructorRepository = instructorRepository;
		this.cottageOwnerRepository = cottageOwnerRepository;
		this.shipOwnerRepository = shipOwnerRepository;
		
		
	}

	@Transactional
	public Boolean addByClient(AddReservationDTO reservation) throws OptimisticLockException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Client c = this.clientRepository.findByAccountUsername(username);
		if(c.getPenals() >= 3)
			return false;
		return this.addingProcedure(reservation, c);
	}

	@Transactional
	public Boolean addByClientSuperDeal(CreateSuperDealReservation superDealReservation) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Client c = this.clientRepository.findByAccountUsername(username);
		
		if(c.getPenals() >= 3)
			return false;
		
		switch (superDealReservation.getType()) {
		case SHIP:{
			ShipSuperDeal shipSuperDeal = this.shipSuperDealRepository.getOne(superDealReservation.getSuperDealId());
			return this.addingProcedure(new AddReservationDTO(shipSuperDeal), c);
		}
		case COTTAGE:{
			CottageSuperDeal cottageSuperDeal = this.cottageSuperDealRepository.getOne(superDealReservation.getSuperDealId());
			return this.addingProcedure(new AddReservationDTO(cottageSuperDeal), c);
		}
		case ADVENTURE:{
			
			break;
		}
		}
		return this.addingProcedure(null, c);
	}

	@Transactional
	public Boolean addByOwner(AddReservationDTO reservation) throws OptimisticLockException {
		Client c = this.clientRepository.findById(reservation.getClientId()).orElse(null);
		return this.addingProcedure(reservation, c);
	}

	public Boolean addingProcedure(AddReservationDTO reservation, Client c) throws OptimisticLockException {
		switch (reservation.getType()) {
		case SHIP: {
			ShipReservation newReservation = reservation.toShipModel();
			for (Long i : reservation.getOptions()) {
				ShipOption option = this.shipOptionRepository.findById(i).orElse(null);
				if (option != null) {
					newReservation.addOption(option);
				}
			}
			newReservation.setClient(c);
			Ship ship = entityManager.find(Ship.class, reservation.getRealEstateId(),
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (this.shipIsReserved(reservation.getRealEstateId(), reservation.getStartDate(),
					reservation.getEndDate())) {
				return false;
			}
			newReservation.setShip(ship);
			ship.addReservation(newReservation);
			entityManager.persist(ship);
			
			ShipOwner sho = ship.getShipOwner();
			Account acc  = sho.getAccount();
			Status s = acc.getStatus();
			s.increasePoints();
			acc.setStatus(s);
			sho.setAccount(acc);
			this.shipOwnerRepository.save(sho);
			break;
		}
		case COTTAGE: {
			CottageReservation newReservation = reservation.toCottageModel();
			for (Long i : reservation.getOptions()) {
				CottageOption option = this.cottageOptionRepository.findById(i).orElse(null);
				if (option != null) {
					newReservation.addOption(option);
				}
			}
			newReservation.setClient(c);
			Cottage cottage = entityManager.find(Cottage.class, reservation.getRealEstateId(),
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (this.cottageIsReserved(reservation.getRealEstateId(), reservation.getStartDate(),
					reservation.getEndDate())) {
				return false;
			}
			newReservation.setCottage(cottage);
			cottage.addReservation(newReservation);
			entityManager.persist(cottage);
			
			CottageOwner co = cottage.getCottageOwner();
			Account acc  = co.getAccount();
			Status s = acc.getStatus();
			s.increasePoints();
			acc.setStatus(s);
			co.setAccount(acc);
			this.cottageOwnerRepository.save(co);
			break;
		}
		case ADVENTURE:
			AdventureReservation newReservation = reservation.toAdventureModel();
			for (Long i : reservation.getOptions()) {
				AdventureOption option = this.adventureOptionsRepository.findById(i).orElse(null);
				if (option != null) {
					newReservation.addOption(option);
				}
			}
			newReservation.setClient(c);
			Adventure adventure = entityManager.find(Adventure.class, reservation.getRealEstateId(),
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (this.cottageIsReserved(reservation.getRealEstateId(), reservation.getStartDate(),
					reservation.getEndDate())) {
				return false;
			}
			newReservation.setAdventure(adventure);
			adventure.addReservation(newReservation);
			entityManager.persist(adventure);
			
			FishingInstructor fi = adventure.getFishingInstructor();
			Account acc  = fi.getAccount();
			Status s = acc.getStatus();
			s.increasePoints();
			acc.setStatus(s);
			fi.setAccount(acc);
			this.instructorRepository.save(fi);
			
			
			break;
		}

		Account acc  = c.getAccount();
		Status s = acc.getStatus();
		s.increasePoints();
		acc.setStatus(s);
		c.setAccount(acc);
		this.clientRepository.save(c);

		return true;
	}

	private Boolean cottageIsReserved(Long id, Date stardDate, Date endDate) {
		return this.cottageReservationRepository.getReservationsInPeriod(id, stardDate, endDate).size() != 0;
	}

	private Boolean shipIsReserved(Long id, Date stardDate, Date endDate) {
		return this.shipReservationRepository.getReservationsInPeriod(id, stardDate, endDate).size() != 0;
	}

	public List<DatePeriodDTO> getDates(RealEstateType type, Long id) {
		List<DatePeriodDTO> dates = new ArrayList<>();
		switch (type) {
		case COTTAGE: {
			dates = this.cottageReservationRepository.getDates(id);
			break;
		}
		case SHIP: {
			dates = this.shipReservationRepository.getDates(id);
			break;
		}
		}
		return dates;
	}

}
