package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.service.CottageService;

@RestController
@RequestMapping("/api/cottage")
public class CottageController {
	
	public CottageService cottageService;
	
	@Autowired
	public CottageController(CottageService cottageService) {
		this.cottageService = cottageService;
	}
	
	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
	@PostMapping("/add/{ownerId}")
	public ResponseEntity<Boolean> getAllByOwner(@RequestBody Cottage cottage){
		this.cottageService.saveCottage(cottage);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/all/name")
	public ResponseEntity<List<CottageDTO>> getAllByName(){
		List<Cottage> cottages = this.cottageService.getAllbyName();
		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
		for(Cottage cottage : cottages) {
			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
			System.out.println(cottageDTO.getPrice_per_day());
			cottagesDTO.add(cottageDTO);
		}
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}
	
	@GetMapping("/page/{id}")
	public ResponseEntity<Cottage> getById(@PathVariable Long id){
		Cottage cottage = this.cottageService.getById(id);
		return new ResponseEntity<>(cottage, HttpStatus.OK);
	}
	
	@GetMapping("/all/price")
	public ResponseEntity<List<CottageDTO>> getAllbyPrice(){
		List<Cottage> cottages = this.cottageService.getAllbyPrice();
		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
		for(Cottage cottage : cottages) {
			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
			System.out.println(cottageDTO.getPrice_per_day());
			cottagesDTO.add(cottageDTO);
		}
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}
	
	@GetMapping("/all/rate")
	public ResponseEntity<List<CottageDTO>> getAllByRate(){
		List<Cottage> cottages = this.cottageService.getAllbyRate();
		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
		for(Cottage cottage : cottages) {
			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
			System.out.println(cottageDTO.getPrice_per_day());
			cottagesDTO.add(cottageDTO);
		}
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Boolean> save(@RequestBody Cottage cottage){
		this.cottageService.saveCottage(cottage);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	

}
