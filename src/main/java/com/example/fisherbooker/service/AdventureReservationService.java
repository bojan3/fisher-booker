package com.example.fisherbooker.service;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.AdventureReservationRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;

@Service
public class AdventureReservationService {

	@Autowired
	public AdventureReservationRepository adventureReservationRepository;
	@Autowired
	public AdventureRepository adventureRepository;
	@Autowired
	public AdventureReservationService (AdventureReservationRepository arr, AdventureRepository ar) {
		
		this.adventureRepository=ar;
		this.adventureReservationRepository = arr;	
	}
	
	
	public void Save(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	
	}

	
	
	

	public void saveAdventureReservation(AdventureReservation adventure) {
           adventureReservationRepository.save(adventure);		
	}


	public List<AdventureReservation> getAll() {
		return adventureReservationRepository.findAll();
	}


	public void deleteById(Long id) {
    //    AdventureReservation adventurereservation =	this.arr.findById(id).get();
		
        //if(!adventurereservation.equals(null)) {
     //  Adventure adventure = adventurereservation.getAdventure();
        
      //  if(adventure.getAdventureReservation().remove(adventure)){
      //  adventure.setAdventureReservation(adventure.getAdventureReservation());
      //  this.ar.save(adventure);
       // }
		 this.adventureReservationRepository.deleteById(id);
      //  }
	}


	public AdventureReservation getById(Long id) {
		return this.adventureReservationRepository.getById(id);
	}
		
   public Optional<AdventureReservation> findOneById(Long id){
	   return adventureReservationRepository.findById(id);
   }



public List<AdventureReservation> getAllByAdventure(Long adventureID) {
	List<AdventureReservation> sve = adventureReservationRepository.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.adventure.getId().equals(adventureID)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}


public List<AdventureReservation> getAllByClient(Client client) {
	List<AdventureReservation> sve = adventureReservationRepository.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.client.getAccount().getId().equals(client.account.getId())) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}

public List<AdventureReservation> getAllByInstructor(Long fishingInstructor) {
	List<AdventureReservation> sve = adventureReservationRepository.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.getAdventure().getFishingInstructor().getId().equals(fishingInstructor)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}

public List<AdventureReservation> getAllByInstructorAccountUsername(String username) {
	List<AdventureReservation> sve = adventureReservationRepository.findAll();	
	List<AdventureReservation> neke = new ArrayList<AdventureReservation>();
	
	for (AdventureReservation adventureReservation : sve) {
		if (adventureReservation.getAdventure().getFishingInstructor().getAccount().getUsername().equals(username)) {
			neke.add(adventureReservation);
		}
	}
	return neke;
}


//public DatePeriodDTO getReservationDates(Long id) {
//	// TODO Auto-generated method stub
//	return new DatePeriodDTO() {	
//	};
//}

////METODE DODATE IZ COTTAGE
private final int perPage = 5;



public List<Stats> getYearlyStats(String username, int year) {
	return this.adventureReservationRepository.yearlyStats(username, year);
}

public List<Stats> getMonthlyStats(String username, int year, int month) {
	return this.adventureReservationRepository.monthlyStats(username, year, month);
}

public List<Stats> getArbitrarilyStats(String username, Timestamp startDate, Timestamp endDate) {
	return this.adventureReservationRepository.arbitrarilyStats(username, startDate, endDate);
}

public List<Integer> getYears(String username) {
	return this.adventureReservationRepository.getYears(username);
}

public List<DatePeriodDTO> getReservationDates(Long cottageId) {
	return this.adventureReservationRepository.getReservationDates(cottageId);
}

public AdventureReservation getReservationByDateAndCottage(Long id, Date date) {
	return this.adventureReservationRepository.getReservationByDateAndAdventure(id, date);
}

public List<ReservationDetailsDTO> getReservationsByCottageOwner(String username, int page) {
	List<AdventureReservation> reservations = this.adventureReservationRepository.findByAdventureFishingInstructorAccountUsernameOrderByStartDateDesc(username);
	List<ReservationDetailsDTO> dtos = new ArrayList<ReservationDetailsDTO>();
	for(AdventureReservation reservation:reservations) {
		dtos.add(reservation.toDTO());
	}
	return dtos;
}

public int getNumberOfReservations(String username) {
	List<AdventureReservation> reservations = this.adventureReservationRepository.findByAdventureFishingInstructorAccountUsernameOrderByStartDateDesc(username);
	return reservations.size();
	}

	}