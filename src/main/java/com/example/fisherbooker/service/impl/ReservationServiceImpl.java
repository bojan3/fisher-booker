package com.example.fisherbooker.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.AddReservationDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.repository.ShipOptionRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@PersistenceContext
	EntityManager entityManager;

	private CottageOptionRepository cottageOptionRepository;
	private ShipOptionRepository shipOptionRepository;
	private ClientRepository clientRepository;
	

	public ReservationServiceImpl(CottageOptionRepository cottageOptionRepository,
			ShipOptionRepository shipOptionRepository, ClientRepository clientRepository) {
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
		this.shipOptionRepository = shipOptionRepository;
	}

	@Transactional()
	public Boolean add(AddReservationDTO reservation) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Client c = this.clientRepository.findByAccountUsername(username);

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
			newReservation.setShip(ship);
			ship.addReservation(newReservation);
			entityManager.persist(ship);
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
			newReservation.setCottage(cottage);
			cottage.addReservation(newReservation);
			entityManager.persist(cottage);
			break;
		}
		}
		
		c.getAccount().getStatus().increasePoints();
		this.clientRepository.save(c);
		
		return true;
	}

}
