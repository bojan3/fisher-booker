package com.example.fisherbooker.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.NavigationEquipment;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipPicture;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipSuperDeal;
import com.example.fisherbooker.repository.ShipRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

	private ShipRepository shipRepository;
	private ShipReservationRepository shipReservationRepository;

	@Autowired
	public ShipServiceImpl(ShipRepository shipRepository, ShipReservationRepository shipReservationRepository) {
		this.shipRepository = shipRepository;
		this.shipReservationRepository = shipReservationRepository;
	}

	public Boolean updateShip(Ship ship) { 
//		Ship oldShip = this.shipRepository.findById(ship.getId()).orElse(null);
//		oldShip.setName(ship.getName());
//		oldShip.setType(ship.getType());
//		oldShip.setLength(ship.getLength());
//		oldShip.setDescription(ship.getDescription());
//		oldShip.setRentPrice(ship.getRentPrice());
//		oldShip.setEngineNumber(ship.getEngineNumber());
//		oldShip.setEnginePower(ship.getEnginePower());
//		oldShip.setMaxSpeed(ship.getMaxSpeed());
//		oldShip.setCapacity(ship.getCapacity());
//		oldShip.setCancelRate(ship.getCancelRate());
//		oldShip.setAddress(ship.getAddress());
//		oldShip.setAvailabilityPeriod(ship.getAvailabilityPeriod());
//		oldShip.setRules(ship.getRules());
//
//		Iterator<NavigationEquipment> itrNav = ship.getNavigationEquipments().iterator();
//		for(NavigationEquipment ne : oldShip.getNavigationEquipments()) {
//			ne.setName(itrNav.next().getName());
//		}
//		
//		Iterator<FishingEquipment> itrFish = ship.getFishingEquipments().iterator();
//		for(FishingEquipment fe : oldShip.getFishingEquipments()) {
//			fe.setName(itrFish.next().getName());
//		}
//		
////		Iterator<ShipPicture> itrPic = ship.getShipPictures().iterator();
////		for(ShipPicture sp : oldShip.getShipPictures()) {
////			sp.setShip(ship);
////		}
//		
//		Iterator<ShipOption> itrOp = ship.getShipOptions().iterator();
//		for(ShipOption so : oldShip.getShipOptions()) {
//			so.setName(itrOp.next().getName());
//			so.setPrice(itrOp.next().getPrice());
//			so.setDescription(itrOp.next().getDescription());
//		}
//		
//		/*Iterator<ShipSuperDeal> itrSuper = ship.getShipSuperDeals().iterator();
//		for(ShipSuperDeal ssd : oldShip.getShipSuperDeals()) {
//			ssd.setStartDate(itrSuper.next().getStartDate());
//			ssd.setEndDate(itrSuper.next().getEndDate());
//			ssd.setDiscountedPrice(itrSuper.next().getDiscountedPrice());
//			ssd.setCapacity(itrSuper.next().getCapacity());
//		}*/
//		
//		oldShip.setRules(ship.getRules());
		for(NavigationEquipment ne : ship.getNavigationEquipments()) {
			ne.setShip(ship);
		}
		this.shipRepository.save(ship);
		return true;
	}
	
	public Boolean saveShip(Ship ship) { 
		for(NavigationEquipment ne : ship.getNavigationEquipments()) {
			ne.setShip(ship);
		}
		for (FishingEquipment fe : ship.getFishingEquipments()) {
			fe.setShip(ship);
		}
		for (ShipSuperDeal ssd : ship.getShipSuperDeals()) {
			ssd.setShip(ship);
		}
		for (ShipOption so : ship.getShipOptions()) {
			so.setShip(ship);
		}
		this.shipRepository.save(ship);
		return true;
	}
	
	
	public Ship getById(Long id) {
		return this.shipRepository.findById(id).orElse(null);
	}

	public List<Ship> getAll() {
		return this.shipRepository.findAll();
	}

	public void deleteShip(Long id) {
		this.shipRepository.deleteById(id);
	}

	public List<Ship> getAllByName() {
		return this.shipRepository.findByOrderByName();
	}

	public List<Ship> getAllByAverageMark() {
		return this.shipRepository.findByOrderByAverageMarkDesc();
	}

	public List<Ship> getAllByRentPrice() {
		return this.shipRepository.findByOrderByRentPrice();
	}

	public List<Ship> getAllByCapacity() {
		return this.shipRepository.findByOrderByCapacityDesc();
	}
	
	public List<Ship> getAllByOwnerUsername(String username){
		return this.shipRepository.findByShipOwnerAccountUsername(username);
	}

	public Boolean checkIfOwnerHasShip(String username, Long shipId) {
		List<Ship> ships = this.shipRepository.findByShipOwnerAccountUsername(username);
		for (Ship ship : ships) {
			//System.out.println(ship.getShipOwner());
			if (ship.getId().equals(shipId)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean checkIfShipHasReservation(Long id) {
		List<ShipReservation> reservations = this.shipReservationRepository.findByShipId(id);
		return !reservations.isEmpty();
	}
}
