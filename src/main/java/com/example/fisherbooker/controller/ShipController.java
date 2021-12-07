package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/all")
	public ResponseEntity<List<ShipDTO>> getAll(){
		List<Ship> ships = this.shipService.getAll();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for(Ship ship: ships) {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{ShipId}")
	public ResponseEntity<List<ShipDTO>> deleteShip(@PathVariable("ShipId") Long ShipId) {
		List<Ship> ships = this.shipService.getAll();
		List<ShipDTO> shipsDTO = new ArrayList<ShipDTO>();
		for(Ship ship: ships) {
			if(ship.getId().equals(ShipId)) {
			this.shipService.deleteShip(ShipId);
			System.out.println("Brod sa identifikatorom"+ShipId+"je uspesno obrisan");
			}
			else {
			ShipDTO shipDTO = new ShipDTO().createShipDTO(ship);
			shipsDTO.add(shipDTO);
			}
		}
		return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
	}
		
	}
	
	
	
	
	

