package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.NavigationEquipment;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipSuperDeal;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.service.CottageService;

@Service
public class CottageServiceImpl implements CottageService {
	private CottageRepository cottageRepository;
	private CottageReservationRepository cottageReservationRepository;

	@Autowired
	public CottageServiceImpl(CottageRepository cottageRepository,
			CottageReservationRepository cottageReservationRepository) {
		this.cottageRepository = cottageRepository;
		this.cottageReservationRepository = cottageReservationRepository;
	}

	public Boolean saveCottage(Cottage cottage) {
		System.out.println("novi: " + cottage.getAvailabilityPeriod());
		for (Room r : cottage.getRooms()) {
			r.setCottage(cottage);
		}
		for (CottageSuperDeal csd : cottage.getCottageSuperDeals()) {
			csd.setCottage(cottage);
		}
		for (CottageOption co : cottage.getCottageOptions()) {
			co.setCottage(cottage);
		}
		this.cottageRepository.save(cottage);
		return true;
	}

	public void deleteCottage(Long id) {
		this.cottageRepository.deleteById(id);
	}

	public List<Cottage> getAllbyName() {
		return this.cottageRepository.findByOrderByName();
	}

	public List<Cottage> getAllbyPrice() {
		return this.cottageRepository.findByOrderByPricePerDay();
	}

	public Cottage getById(Long id) {
		return this.cottageRepository.findById(id).orElse(null);
	}

	public List<Cottage> getAllbyRate() {
		return this.cottageRepository.findByOrderByAverageMarkDesc();
	}

	public List<Cottage> getAllByOwnerUsername(String username) {
		return this.cottageRepository.findByCottageOwnerAccountUsername(username);
	}

	public Boolean checkIfOwnerHasCottage(String username, Long cottageId) {
		List<Cottage> cottages = this.cottageRepository.findByCottageOwnerAccountUsername(username);
		for (Cottage cottage : cottages) {
			if (cottage.getId().equals(cottageId)) {
				return true;
			}
		}
		return false;
	}

	public Boolean checkIfCottageHasReservation(Long id) {
		List<CottageReservation> reservations = this.cottageReservationRepository.findByCottageId(id);
		System.out.println(reservations);
		return !reservations.isEmpty();
	}

	@Override
	public List<Cottage> getAll() {
		return cottageRepository.findAll();
	}
}
