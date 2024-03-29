package com.example.fisherbooker.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOption;
import com.example.fisherbooker.model.DTO.AddShipDTO;
import com.example.fisherbooker.model.DTO.EditShipDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.ShipService;

@RestController
@RequestMapping("/api/ship")
public class ShipController {

	public ShipService shipService;

	@Autowired
	public ShipController(ShipService shipService) {
		this.shipService = shipService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ShipDTO>> getAlll() {
		List<Ship> ships = this.shipService.getAll();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			if (!ship.getIsDeleted()) {
				ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
				shipDTO.setId(ship.getId());
				shipsDTO.add(shipDTO);
			}
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@DeleteMapping("/admin/delete/{ship_id}")
	public ResponseEntity<List<ShipDTO>> deleteAship(@PathVariable Long ship_id) {
		this.shipService.delete(ship_id);
		List<Ship> ships = this.shipService.getAll();
		List<ShipDTO> shipDTOs = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			if (!ship.getIsDeleted()) {
				ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
				shipDTOs.add(shipDTO);
			}
		}
		return new ResponseEntity<>(shipDTOs, HttpStatus.OK);
	}

	@GetMapping("/page/{id}")
	public ResponseEntity<Ship> getById(@PathVariable Long id) {
		Ship ship = this.shipService.getById(id);
		return new ResponseEntity<>(ship, HttpStatus.OK);
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<Ship> getEditDtoById(@PathVariable Long id) {
		Ship ship = this.shipService.getById(id);
		return new ResponseEntity<>(ship, HttpStatus.OK);
	}

//	@GetMapping("/all")
//	public ResponseEntity<List<ShipDTO>> getAll() {
//		List<Ship> ships = this.shipService.getAll();
//		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
//		for (Ship ship : ships) {
//			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
//			shipsDTO.add(shipDTO);
//		}
//		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
//	}

//	@GetMapping("/all")
//	public ResponseEntity<List<ShipDTO>> getAll() {
//		List<Ship> ships = this.shipService.getAll();
//		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
//		for (Ship ship : ships) {
//			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
//			shipsDTO.add(shipDTO);
//		}
//		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
//	}

	@GetMapping("/all/")
	public ResponseEntity<List<ShipDTO>> getAllSorted(@RequestParam String type, @RequestParam String order) {
		List<Ship> ships = this.shipService.getAllSorted(type, order);
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/name")
	public ResponseEntity<List<ShipDTO>> getAllByName() {
		List<Ship> ships = this.shipService.getAllByName();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/price")
	public ResponseEntity<List<ShipDTO>> getAllByPrice() {
		List<Ship> ships = this.shipService.getAllByRentPrice();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/rating")
	public ResponseEntity<List<ShipDTO>> getAllByAverageMark() {
		List<Ship> ships = this.shipService.getAllByAverageMark();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/capacity")
	public ResponseEntity<List<ShipDTO>> getAllByCapacity() {
		List<Ship> ships = this.shipService.getAllByCapacity();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/delete/{ShipId}")
	public ResponseEntity<List<ShipDTO>> deleteShip(@PathVariable("ShipId") Long ShipId) {
		List<ShipDTO> shipsDTO = this.shipService.deleteShipDTO(ShipId);

		if (shipsDTO != new ArrayList<ShipDTO>()) {
			return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
		}

		else
			return new ResponseEntity<>(shipsDTO, HttpStatus.BAD_REQUEST);
	}

	// @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete1/{ShipId}")
	public ResponseEntity<List<ShipDTO>> deleteShip1(@PathVariable("ShipId") Long ShipId) {
		List<Ship> ships = this.shipService.getAll();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			if (ship.getId().equals(ShipId)) {
				this.shipService.deleteShip(ShipId);
				System.out.println("Brod sa identifikatorom" + ShipId + "je uspesno obrisan");
			} else {
				ShipDTO shipDTO = ShipDTO.createShipDTO(ship);
				shipsDTO.add(shipDTO);
			}
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasRole('SHIP_OWNER')")
	@DeleteMapping("/delete/owner/{ShipId}")
	public ResponseEntity<List<ShipDTO>> delete(@PathVariable("ShipId") Long ShipId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (this.shipService.checkIfOwnerHasShip(username, ShipId)) {

			if (!this.shipService.checkIfShipHasReservation(ShipId)) {
				this.shipService.delete(ShipId);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}
		List<Ship> ownersShips = this.shipService.getAllByOwnerUsername(username);
		List<ShipDTO> shipDTOs = new ArrayList<ShipDTO>();
		for (Ship ship : ownersShips) {
			shipDTOs.add(ShipDTO.createShipDTO(ship));
		}
		return new ResponseEntity<>(shipDTOs, HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('SHIP_OWNER')")
//	@PutMapping("/update")
//	public ResponseEntity<Boolean> update(@RequestBody Ship ship) {
//		System.out.println(ship);
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		if (this.shipService.checkIfOwnerHasShip(username, ship.getId())) {
//			this.shipService.saveShip(ship);
//			return new ResponseEntity<>(true, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(true, HttpStatus.UNAUTHORIZED);
//	}

	@PreAuthorize("hasRole('SHIP_OWNER')")
	@PostMapping("/save")
	public ResponseEntity<Boolean> save(@RequestBody AddShipDTO ship) {
		System.out.println(ship);
		this.shipService.saveShip(ship);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('SHIP_OWNER')")
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody EditShipDTO ship) {
		try {
			this.shipService.updateShip(ship);
		} catch (OptimisticLockException e) {
			return new ResponseEntity<>(true, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("ownership/{id}")
	public ResponseEntity<Boolean> checkOwnership(@PathVariable Long id) {
		return new ResponseEntity<>(this.shipService.checkOwnership(id), HttpStatus.OK);
	}

	@GetMapping("options/{id}")
	public ResponseEntity<List<ShipOption>> getOptions(@PathVariable Long id) {
		return new ResponseEntity<>(this.shipService.getOptions(id), HttpStatus.OK);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<Boolean> uplaodImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {

		try {
			this.shipService.uploadImage(id, file);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('SHIP_OWNER')")
	@DeleteMapping("/delete/image/{id}")
	public ResponseEntity<Boolean> deleteImage(@PathVariable("id") Long id) {
		this.shipService.deleteImage(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/locations")
	public ResponseEntity<List<String>> getShipLocations() {
		List<String> locations = this.shipService.getShipLocations();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

	@GetMapping("search/filter/")
	public ResponseEntity<List<ShipDTO>> searchShips(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String locationCity, @RequestParam String minGrade) {

		Date startDate1 = null;
		Date endDate1 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			startDate1 = formatter.parse(startDate);
			endDate1 = formatter.parse(endDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		SearchFilter searchFilter = new SearchFilter(startDate1, endDate1, locationCity, minGrade, "null");
//		System.out.println(searchFilter);
		List<Ship> ships = shipService.searchShips(searchFilter);
		return new ResponseEntity<>(toDTOs(ships), HttpStatus.OK);
	}

	private List<ShipDTO> toDTOs(List<Ship> ships) {
		List<ShipDTO> shipDTOs = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			shipDTOs.add(ShipDTO.createShipDTO(ship));
		}
		return shipDTOs;
	}
}
