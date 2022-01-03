package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.impl.ShipServiceImpl;

@RestController
@RequestMapping("/api/ship")
public class ShipController {

	public ShipServiceImpl shipService;

	@Autowired
	public ShipController(ShipServiceImpl shipServiceImpl) {
		this.shipService = shipServiceImpl;
	}

	@GetMapping("/all/name")
	public ResponseEntity<List<ShipDTO>> getAllByName() {
		List<Ship> ships = this.shipService.getAllByName();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/price")
	public ResponseEntity<List<ShipDTO>> getAllByPrice() {
		List<Ship> ships = this.shipService.getAllByRentPrice();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/rating")
	public ResponseEntity<List<ShipDTO>> getAllByAverageMark() {
		List<Ship> ships = this.shipService.getAllByAverageMark();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}

	@GetMapping("/all/capacity")
	public ResponseEntity<List<ShipDTO>> getAllByCapacity() {
		List<Ship> ships = this.shipService.getAllByCapacity();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for (Ship ship : ships) {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}
}
