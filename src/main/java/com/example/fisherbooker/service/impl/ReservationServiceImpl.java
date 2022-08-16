package com.example.fisherbooker.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageReservation;
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

	private CottageRepository cottageRepository;
	
	private CottageReservationRepository cottageReservationRepository;
	private ShipReservationRepository shipReservationRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ShipOptionRepository shipOptionRepository;
	private ClientRepository clientRepository;

	public ReservationServiceImpl(CottageRepository cottageRepository, CottageReservationRepository cottageReservationRepository,
			ShipReservationRepository shipReservationRepository, CottageOptionRepository cottageOptionRepository,
			ShipOptionRepository shipOptionRepository, ClientRepository clientRepository) {
		this.cottageReservationRepository = cottageReservationRepository;
		this.cottageOptionRepository = cottageOptionRepository;
		this.clientRepository = clientRepository;
		this.shipReservationRepository = shipReservationRepository;
		this.shipOptionRepository = shipOptionRepository;
		this.cottageRepository = cottageRepository;
	}

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
			
			this.shipReservationRepository.save(newReservation);
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
			
//			Cottage cottage = this.cottageRepository.findById(reservation.getRealEstateId()).orElse(null);
//			cottage.addReservation(newReservation);
//			this.cottageRepository.save(cottage);

			this.cottageReservationRepository.save(newReservation);
			break;
		}
		}
		return true;
	}

}
