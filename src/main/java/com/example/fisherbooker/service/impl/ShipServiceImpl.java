package com.example.fisherbooker.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipImage;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.AddShipDTO;
import com.example.fisherbooker.model.DTO.EditShipDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.repository.ImageRepository;
import com.example.fisherbooker.repository.ShipOptionRepository;
import com.example.fisherbooker.repository.ShipOwnerRepository;
import com.example.fisherbooker.repository.ShipRepository;
import com.example.fisherbooker.repository.ShipReservationRepository;
import com.example.fisherbooker.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

	@PersistenceContext
	EntityManager entityManager;

	private ShipRepository shipRepository;
	private ShipReservationRepository shipReservationRepository;
	private ShipOwnerRepository shipOwnerRepository;
	private ShipOptionRepository shipOptionRepository;
	private ImageRepository imageRepository;

	@Autowired
	public ShipServiceImpl(ShipRepository shipRepository, ShipReservationRepository shipReservationRepository,
			ShipOwnerRepository shipOwnerRepository, ShipOptionRepository shipOptionRepository,
			ImageRepository imageRepository) {
		this.shipRepository = shipRepository;
		this.shipReservationRepository = shipReservationRepository;
		this.shipOwnerRepository = shipOwnerRepository;
		this.shipOptionRepository = shipOptionRepository;
		this.imageRepository = imageRepository;
	}

	@Transactional
	public Boolean updateShip(EditShipDTO ship) throws OptimisticLockException {
		Ship oldShip = this.shipRepository.findById(ship.getId()).orElse(null);
		if(checkIfShipHasReservation(ship.getId())) {
			return false;
		}
		oldShip.setName(ship.getName());
		oldShip.setType(ship.getType());
		oldShip.setLength(ship.getLength());
		oldShip.setDescription(ship.getDescription());
		oldShip.setRentPrice(ship.getRentPrice());
		oldShip.setEngineNumber(ship.getEngineNumber());
		oldShip.setEnginePower(ship.getEnginePower());
		oldShip.setMaxSpeed(ship.getMaxSpeed());
		oldShip.setCapacity(ship.getCapacity());
		oldShip.setCancelRate(ship.getCancelRate());
		oldShip.setAddress(ship.getAddress());
		oldShip.setAvailabilityPeriod(ship.getAvailabilityPeriod());
		oldShip.setRules(ship.getRules());
		oldShip.setFishingEquipments(ship.getFishingEquipments());
		oldShip.setNavigationEquipments(ship.getNavigationEquipments());
		oldShip.setShipOptions(ship.getShipOptions());
		this.shipRepository.save(oldShip);
		return true;
	}

	public Boolean saveShip(AddShipDTO ship) {

		Ship newShip = ship.toModel();

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ShipOwner owner = shipOwnerRepository.findOneByAccountUsername(username).orElse(null);
		if (owner != null) {
			newShip.setShipOwner(owner);
			owner.addShip(newShip);
		}

		this.shipRepository.save(newShip);
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

	public List<Ship> getAllByOwnerUsername(String username) {
		return this.shipRepository.findByShipOwnerAccountUsername(username);
	}

	public Boolean checkIfOwnerHasShip(String username, Long shipId) {
		List<Ship> ships = this.shipRepository.findByShipOwnerAccountUsername(username);
		for (Ship ship : ships) {
			if (ship.getId().equals(shipId)) {
				return true;
			}
		}
		return false;
	}

	public List<ShipDTO> deleteShipDTO(Long id) {

		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		List<Ship> ships = this.shipRepository.findAll();

		if (this.shipRepository.findById(id).get().getName() != "") {
			for (Ship ship : ships) {
				if (ship.getId().equals(id)) {
					this.shipRepository.delete(ship);
					System.out.println("Brod sa identifikatorom" + id + "je uspesno obrisan");
				} else {
					ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
					shipsDTO.add(shipDTO);
				}
			}
		}

		return shipsDTO;
	}

	public Boolean checkIfShipHasReservation(Long id) {
		List<ShipReservation> reservations = this.shipReservationRepository.isShipReserved(id);
		return !reservations.isEmpty();
	}

	@Override
	public List<Ship> getAllSorted(String type, String order) {
		if (order.equals("ASC"))
			return this.shipRepository.findAll(Sort.by(type).ascending());
		return this.shipRepository.findAll(Sort.by(type).descending());
	}

	public Boolean checkOwnership(Long id) {
		Ship ship = this.shipRepository.findById(id).orElse(null);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return ship.getShipOwner().getAccount().getUsername().equals(username);
	}

	public List<ShipOption> getOptions(Long shipId) {
		return this.shipOptionRepository.findByShipId(shipId);
	}

	@Override
	public List<Ship> searchShips(SearchFilter searchFilter) {
		List<Ship> ships = this.shipRepository.getAllAvalible(searchFilter.getStartDate(), searchFilter.getEndDate());

		if (searchFilter.getMinGrade() != null) {
			Iterator<Ship> it = ships.iterator();
			while (it.hasNext()) {
				if (it.next().getAverageMark() < searchFilter.getMinGrade()) {
					it.remove();
				}
			}

		}

		if (searchFilter.getLocationCity() != null) {
			Iterator<Ship> it = ships.iterator();
			while (it.hasNext()) {
				if (!it.next().getAddress().getCity().equals(searchFilter.getLocationCity())) {
					it.remove();
				}
			}
		}

		return ships;
	}

	@Override
	public List<String> getShipLocations() {
		return this.shipRepository.getCottageLocations();
	}

	public Boolean uploadImage(Long id, MultipartFile image) throws IOException {
		ShipImage newImage = new ShipImage();
		newImage.setName(image.getOriginalFilename());
		newImage.setType(image.getContentType());
		newImage.setImage(image.getBytes());
		Ship s = this.getById(id);
		newImage.setShip(s);
		s.addImage(newImage);
		this.imageRepository.save(newImage);
		return true;
	}

	public Boolean deleteImage(Long id) {
		this.imageRepository.deleteById(id);
		return true;
	}
}
