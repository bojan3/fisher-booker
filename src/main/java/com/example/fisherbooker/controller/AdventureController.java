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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.service.AdventureService;
import com.example.fisherbooker.service.FishingInstructorService;

@RestController
@RequestMapping("/api/adventure")
public class AdventureController {
	public AdventureService adventureService;
	public FishingInstructorService fishinginstructorservice;

	@Autowired
	public AdventureController(AdventureService adventureService) {
		this.adventureService = adventureService;
	}

	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
	@PostMapping("/add/{InstructorId}")
	public ResponseEntity<Boolean> getAllByOwner(@RequestBody Adventure adventure) {
		this.adventureService.saveAdventure(adventure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/all/name")
	public ResponseEntity<List<AdventureDTO>> getAllByName() {
		List<Adventure> adventures = this.adventureService.getAllByName();
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@GetMapping("/all/price")
	public ResponseEntity<List<AdventureDTO>> getAllByPrice() {
		List<Adventure> adventures = this.adventureService.getAllByPrice();
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@GetMapping("/all/capacity")
	public ResponseEntity<List<AdventureDTO>> getAllByCapacity() {
		List<Adventure> adventures = this.adventureService.getAllByCapacity();
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@PostMapping("/update/{AdventureID}")
	public ResponseEntity<Boolean> updateAdventure(@RequestBody Adventure adventure) {

		return new ResponseEntity<>(true, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	void deleteEmployee(@PathVariable Long id) {
		adventureService.deleteById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<Boolean> SaveAdventure(@RequestBody Adventure adventure) {
		adventureService.saveAdventure(adventure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
