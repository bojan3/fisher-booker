package com.example.fisherbooker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.ShipOwnerRepository;


@Service
public class ShipOwnerService {
	public ShipOwnerRepository shipOwnerRepository;
	public AccountRepository accountrepository;

	@Autowired
	public ShipOwnerService(ShipOwnerRepository shipOwnerRepository) {
		this.shipOwnerRepository = shipOwnerRepository;
	}
	
	public Set<ShipDTO> getAllShipsByOwner(String username){
		ShipOwner owner = this.shipOwnerRepository.findOneByAccountUsername(username).orElse(null);
		return this.createShipDTOs(owner.getShips());
	}
	
	public Set<ShipDTO> createShipDTOs(Set<Ship> ships){
		Set<ShipDTO> shipDTOs = new HashSet<ShipDTO>();
		for (Ship ship : ships) {
			shipDTOs.add(ShipDTO.createShipDTO(ship));
		}
		return shipDTOs;
	}
	
	public List<ShipOwner> getAll() {
		// TODO Auto-generated method stub
		return this.shipOwnerRepository.findAll();
	}

	public void save(ShipOwner shipowner) {
		this.shipOwnerRepository.save(shipowner);		
	}
	
	public void deleteOne(Long instructor_id) {
		ShipOwner sho =this.shipOwnerRepository.getById(instructor_id);
		System.out.println(sho);
	//	long acc_id = fi.getAccount().getId();		
		Account acc = sho.getAccount();
	//	Set<Adventure> avanture = fi.getAdventure();
		System.out.println("ulazak u iteracije");
		sho.removeAllShips();
		//for (Adventure a : fi.getAdventure()){		
		//}
		
		acc.setAddress(null);
		this.accountrepository.save(acc);  
		sho.setAccount(null);
		this.shipOwnerRepository.save(sho);
    	this.accountrepository.delete(acc);    
		this.shipOwnerRepository.delete(sho);	
	}
	
	
	
	
}
