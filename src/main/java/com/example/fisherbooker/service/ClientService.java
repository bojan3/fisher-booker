package com.example.fisherbooker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.AbstractListenerWriteFlushProcessor;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.repository.ClientRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.ShipRepository;

@Service
@Transactional
public class ClientService {
	
	public ClientRepository clientRepository;
	public CottageRepository cottageRepository;
	public ShipRepository shipRepository;
	public FishingInstructorRepository fishingInstructorRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, CottageRepository cotageRepository, ShipRepository shipRepository, FishingInstructorRepository fishingInstructorRepository) {
		this.clientRepository = clientRepository;
		this.cottageRepository = cotageRepository;
		this.shipRepository = shipRepository;
		this.fishingInstructorRepository = fishingInstructorRepository;
		
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
	
//	public List<Client> getAll(){
//		return clientRepository.getAll();
//	}
}
