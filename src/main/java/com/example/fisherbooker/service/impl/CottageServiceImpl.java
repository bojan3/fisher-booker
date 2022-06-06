package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReservation;
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

	@Override
	public List<Cottage> getAllByDate(Date date) {
		List<Cottage> cottages = cottageRepository.findAll();
		List<Cottage> returnList = new ArrayList<Cottage>();
		for (Cottage cottage: cottages) {
			if(date.after(cottage.availabilityPeriod.getStartDate()) && date.before(cottage.getAvailabilityPeriod().getEndDate())) {
			
				List<CottageReservation> cottageReservations = cottageReservationRepository.findByCottageId(cottage.getId());
				if(isFree(cottageReservations, date)) {
					returnList.add(cottage);
				}
			}
			
		}
		
		return returnList;
	}
	
	private boolean isFree(List<CottageReservation> cottageReservations, Date date) {
		for(CottageReservation cottageReservation: cottageReservations) {
			if(!cottageReservation.isDeleted()) {
			if (date.after(cottageReservation.getStartDate()) && date.before(cottageReservation.getEndDate())) {
				return false;
			}}
		}
		return true;
	}
}
