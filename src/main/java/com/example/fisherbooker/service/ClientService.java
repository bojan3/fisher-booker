package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageComplaint;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.AdventureReservationDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageReservationDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.model.DTO.ShipReservationDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageComplaintRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.ShipRepository;

@Service
@Transactional
public class ClientService {
	
	private ClientRepository clientRepository;
	private CottageRepository cottageRepository;
	private ShipRepository shipRepository;
	private FishingInstructorRepository fishingInstructorRepository;
	private AdventureService adventureService;
	private CottageComplaintRepository cottageComplaintRepository;
	@Autowired
	public ClientService(ClientRepository clientRepository, CottageRepository cotageRepository, ShipRepository shipRepository, FishingInstructorRepository fishingInstructorRepository, AdventureService adventureService, CottageComplaintRepository cottageComplaintRepository) {
		this.clientRepository = clientRepository;
		this.cottageRepository = cotageRepository;
		this.shipRepository = shipRepository;
		this.fishingInstructorRepository = fishingInstructorRepository;
		this.adventureService = adventureService;
		this.cottageComplaintRepository = cottageComplaintRepository;
		
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return this.clientRepository.findAll();
	}

	public void subscribeToCottage(Long cottageId, Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);		
		Cottage cottage =  cottageRepository.getOne(cottageId);
		client.getCottageSubscriptions().add(cottage);
		clientRepository.save(client);
	}

	public void subscribeToShip(Long shipId, Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);		
		Ship ship = shipRepository.getOne(shipId);
		client.getShipSubscriptions().add(ship);
		clientRepository.save(client);
	}

	public void subscribeToInstructor(Long instructorId, Long accountId) {	
		Client client = clientRepository.findByAccountId(accountId);		
		FishingInstructor fishingInstructor = fishingInstructorRepository.getOne(instructorId);
		client.getInstructorSubscriptions().add(fishingInstructor);
		clientRepository.save(client);		
	}

	public Client getClientByAccountId(Long accountId) {
		return clientRepository.findByAccountId(accountId);
	}

	public List<CottageDTO> getCottageSubscriptions(Long accountId) {
		Set<Cottage> subscriptionCottageSet = this.clientRepository.findByAccountId(accountId).getCottageSubscriptions();
		List<Cottage> cottages = new ArrayList<Cottage>(subscriptionCottageSet);
		
		List<CottageDTO> cottageDTOs = new ArrayList<CottageDTO>();
		for(Cottage cottage: cottages) {
		CottageDTO cottageDTO = new CottageDTO(cottage);
		cottageDTOs.add(cottageDTO);
		}
		return cottageDTOs;
	}

	public List<FishingInstructorDTO> getInstructorSubscriptions(Long accountId) {
		Set<FishingInstructor> subscriptionInstructorSet = this.clientRepository.findByAccountId(accountId).getInstructorSubscriptions();
		List<FishingInstructor> instructors = new ArrayList<FishingInstructor>(subscriptionInstructorSet);
		
		List<FishingInstructorDTO> instructorDTOs = new ArrayList<FishingInstructorDTO>();
		for(FishingInstructor instructor: instructors) {
		FishingInstructorDTO instructorDTO = new FishingInstructorDTO(instructor);
		instructorDTOs.add(instructorDTO);
		}
		return instructorDTOs;
	}

	public List<ShipDTO> getShipSubscriptions(Long accountId) {
		Set<Ship> subscriptionShipSet = this.clientRepository.findByAccountId(accountId).getShipSubscriptions();
		List<Ship> ships = new ArrayList<Ship>(subscriptionShipSet);
		
		List<ShipDTO> shipDTOs = new ArrayList<ShipDTO>();
		for(Ship ship: ships) {
		ShipDTO shipDTO = new ShipDTO(ship);
		shipDTOs.add(shipDTO);
		}
		
		return shipDTOs;
	}

	public void unsubscribeToCottage(Long cottageId, Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		Cottage cottage = cottageRepository.getOne(cottageId);
		client.getCottageSubscriptions().remove(cottage);
		clientRepository.save(client);
	}
	
	public void unsubscribeToShip(Long shipId, Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		Ship ship = shipRepository.getOne(shipId);
		client.getShipSubscriptions().remove(ship);
		clientRepository.save(client);
	}
	
	public void unsubscribeToInstructor(Long instructorId, Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		FishingInstructor fishingInstructor = fishingInstructorRepository.getOne(instructorId);
		client.getInstructorSubscriptions().remove(fishingInstructor);
		clientRepository.save(client);
	}
// odavden pocinje rezervacije da samaraju
	public List<AdventureReservationDTO> getAdventureReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<AdventureReservation> adventureReservations = new ArrayList<AdventureReservation>(client.getAdventureReservation());
		List<AdventureReservationDTO> adventureReservationDTOs = new ArrayList<AdventureReservationDTO>();
		for(AdventureReservation adventureReservation: adventureReservations) {
			AdventureReservationDTO adventureReservationDTO = new AdventureReservationDTO(adventureReservation);
			if(!adventureReservationDTO.isFinished() && !adventureReservation.isDeleted()) {
				adventureReservationDTOs.add(adventureReservationDTO);
			}
		}
		
		return adventureReservationDTOs;
	}
	
	public List<AdventureReservationDTO> getFinishedAdventureReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<AdventureReservation> adventureReservations = new ArrayList<AdventureReservation>(client.getAdventureReservation());
		List<AdventureReservationDTO> adventureReservationDTOs = new ArrayList<AdventureReservationDTO>();
		for(AdventureReservation adventureReservation: adventureReservations) {
			AdventureReservationDTO adventureReservationDTO = new AdventureReservationDTO(adventureReservation);
			if(adventureReservationDTO.isFinished() && !adventureReservation.isDeleted()) {
				adventureReservationDTOs.add(adventureReservationDTO);
			}
		}
		return adventureReservationDTOs;
	}
	
	public List<CottageReservationDTO> getCottageReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<CottageReservation> cottageReservations = new ArrayList<CottageReservation>(client.getCottageReservation());
		List<CottageReservationDTO> cottageReservationDTOs = new ArrayList<CottageReservationDTO>();
		for(CottageReservation cottageReservation: cottageReservations) {
			CottageReservationDTO cottageReservationDTO = new CottageReservationDTO(cottageReservation);
			
			System.out.println(cottageReservationDTO);
			if(!cottageReservationDTO.isFinished() && !cottageReservation.isDeleted()) {
				cottageReservationDTOs.add(cottageReservationDTO);
			}
		}
		return cottageReservationDTOs;
	}
	
	public List<CottageReservationDTO> getFisnihedCottageReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<CottageReservation> cottageReservations = new ArrayList<CottageReservation>(client.getCottageReservation());
		List<CottageReservationDTO> cottageReservationDTOs = new ArrayList<CottageReservationDTO>();
		for(CottageReservation cottageReservation: cottageReservations) {
			CottageReservationDTO cottageReservationDTO = new CottageReservationDTO(cottageReservation);
			if(cottageReservationDTO.isFinished() && !cottageReservation.isDeleted()) {
				cottageReservationDTOs.add(cottageReservationDTO);
			}
		}
		return cottageReservationDTOs;
	}
	
	public List<ShipReservationDTO> getShipReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<ShipReservation> shipReservations = new ArrayList<ShipReservation>(client.getShipReservation());
		List<ShipReservationDTO> ShipReservationDTOs = new ArrayList<ShipReservationDTO>();
		for(ShipReservation shipReservation: shipReservations) {
			ShipReservationDTO shipReservationDTO = new ShipReservationDTO(shipReservation);
			if(!shipReservationDTO.isFinished() && !shipReservation.isDeleted()) {
				ShipReservationDTOs.add(shipReservationDTO);
			}
		}
		return ShipReservationDTOs;
	}
	
	public List<ShipReservationDTO> getFinishedShipReservations(Long accountId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<ShipReservation> shipReservations = new ArrayList<ShipReservation>(client.getShipReservation());
		List<ShipReservationDTO> ShipReservationDTOs = new ArrayList<ShipReservationDTO>();
		for(ShipReservation shipReservation: shipReservations) {
			ShipReservationDTO shipReservationDTO = new ShipReservationDTO(shipReservation);
			if(shipReservationDTO.isFinished() && !shipReservation.isDeleted()) {
				ShipReservationDTOs.add(shipReservationDTO);
			}
		}
		System.out.println(ShipReservationDTOs);
		return ShipReservationDTOs;
	}

	public void deleteCottageReservation(Long accountId, Long cottageReesrvationId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<CottageReservation> cottageReservations = new ArrayList<CottageReservation>(client.getCottageReservation()); 
		
		for(CottageReservation cottageReservation: cottageReservations) {
			if(cottageReservation.getId() == cottageReesrvationId) {
				cottageReservation.setDeleted(true);
			}
		}
		
		client.setCottageReservation(cottageReservations);
		
		this.clientRepository.save(client);
	}

	public void deleteShipReservation(Long accountId, Long shipReservationId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<ShipReservation> shipReservations = new ArrayList<ShipReservation>(client.getShipReservation()); 
		
		for(ShipReservation shipReservation: shipReservations) {
			if(shipReservation.getId() == shipReservationId) {
				shipReservation.setDeleted(true);
			}
		}
		client.setShipReservation(shipReservations);
		
		this.clientRepository.save(client);
		
	}
	
	public void deleteAdventureReservation(Long accountId, Long adventureReservationId) {
		Client client = clientRepository.findByAccountId(accountId);
		List<AdventureReservation> adventureReservations = new ArrayList<AdventureReservation>(client.getAdventureReservation()); 
		
		for(AdventureReservation adventureReservation: adventureReservations) {
			if(adventureReservation.getId() == adventureReservationId) {
				adventureReservation.setDeleted(true);
			}
		}
		client.setAdventureReservation(adventureReservations);
		
		this.clientRepository.save(client);
		
	}
	
	public Optional<Client> findOneById(Long client_id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(client_id);
	}

	public Object getById(Long client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createCottageComplaint(Long cottageId, Long accountId, String text) {
		Client client = clientRepository.findByAccountId(accountId);
		Cottage cottage = cottageRepository.getOne(cottageId);
		
		CottageComplaint cottageComplaint = new CottageComplaint(cottage, client, text, "");
		
		this.cottageComplaintRepository.save(cottageComplaint);
	}
	
//	public List<Client> getAll(){
//		return clientRepository.getAll();
//	}
}
