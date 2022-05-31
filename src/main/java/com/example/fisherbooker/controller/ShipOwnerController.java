package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.CottageOwnerDTO;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.model.DTO.ShipOwnerDTO;
import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.ShipOwnerService;

@RestController
@RequestMapping("/api/shipOwner")
public class ShipOwnerController {

	private ShipOwnerService shipOwnerService;

	@Autowired
	public ShipOwnerController(ShipOwnerService shipOwnerService) {
		super();
		this.shipOwnerService = shipOwnerService;
	}

	@GetMapping("/allShipsByOwner")
	public ResponseEntity<Set<ShipDTO>> getAllShipsByOwner() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<ShipDTO> ships = this.shipOwnerService.getAllShipsByOwner(username);
		return new ResponseEntity<>(ships, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ShipOwnerDTO>> getAll() {
		List<ShipOwner> shipowners = this.shipOwnerService.getAll();
		List<ShipOwnerDTO> shipownersDTO = new ArrayList<ShipOwnerDTO>();
		for (ShipOwner shipowner : shipowners) {
			ShipOwnerDTO shipownerDTO = ShipOwnerDTO.createShipOwnerDTO(shipowner);
			shipownersDTO.add(shipownerDTO);
		}
		return new ResponseEntity<>(shipownersDTO, HttpStatus.OK);
	}

}
