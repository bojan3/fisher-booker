package com.example.fisherbooker.service;

import java.util.ArrayList;
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
import com.example.fisherbooker.repository.ShipRepository;

@Service
public class ShipOwnerService {
	public ShipOwnerRepository shipOwnerRepository;
	public AccountRepository accountrepository;
	public ShipRepository shipRepository;

	@Autowired
	public ShipOwnerService(ShipOwnerRepository shipOwnerRepository, AccountRepository accountRepository,
			ShipRepository shr) {
		this.shipOwnerRepository = shipOwnerRepository;
		this.accountrepository = accountRepository;
		this.shipRepository = shr;
	}

	public Set<ShipDTO> getAllShipsByOwner(String username) {
		ShipOwner owner = this.shipOwnerRepository.findOneByAccountUsername(username).orElse(null);
		return this.createShipDTOs(owner.getShips());
	}

	public Set<ShipDTO> createShipDTOs(Set<Ship> ships) {
		Set<ShipDTO> shipDTOs = new HashSet<ShipDTO>();
		for (Ship ship : ships) {
			if (!ship.getIsDeleted()) {
				shipDTOs.add(ShipDTO.createShipDTO(ship));
			}
		}
		return shipDTOs;
	}

	public List<ShipOwner> getAll() {

		List<ShipOwner> response = new ArrayList<ShipOwner>();
		List<ShipOwner> svi = this.shipOwnerRepository.findAll();

		for (ShipOwner sho : svi)
			if (!sho.getAccount().isDeleted())
				response.add(sho);

		return response;

	}

	public void save(ShipOwner shipowner) {
		this.shipOwnerRepository.save(shipowner);
	}

	public void deleteOne2(Long instructor_id) {
		ShipOwner sho = this.shipOwnerRepository.getById(instructor_id);
		System.out.println(sho);
		// long acc_id = fi.getAccount().getId();
		Account acc = sho.getAccount();
		// Set<Adventure> avanture = fi.getAdventure();
		System.out.println("ulazak u iteracije");
		sho.removeAllShips();
		// for (Adventure a : fi.getAdventure()){
		// }

		acc.setAddress(null);
		this.accountrepository.save(acc);
		sho.setAccount(null);
		this.shipOwnerRepository.save(sho);
		this.accountrepository.delete(acc);
		this.shipOwnerRepository.delete(sho);
	}

	public void deleteOne(Long owner_id) {
		ShipOwner sho = this.shipOwnerRepository.findById(owner_id).get();
		Set<Ship> ships = sho.getShips();
		for (Ship sh : ships) {
			sh.setIsDeleted(true);
			this.shipRepository.save(sh);
		}
		Account acc = sho.getAccount();
		acc.setDeleted(true);
		this.accountrepository.save(acc);
	}

}
