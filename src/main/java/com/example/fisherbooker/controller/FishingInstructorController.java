package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.FishingInstructorDTO;
import com.example.fisherbooker.service.CottageService;
import com.example.fisherbooker.service.FishingInstructorService;

@RestController
@RequestMapping("/api/instructor")
public class FishingInstructorController {

	private FishingInstructorService FishingInstructorService;

	@Autowired
	public FishingInstructorController(FishingInstructorService FishingInstructorService) {
		this.FishingInstructorService = FishingInstructorService;
	}
		
	@GetMapping("/allAdventuresByOwnerID/{id}")
	public ResponseEntity<Set<AdventureDTO>> getAllCottagesByOwnerID(@PathVariable Long id){
		Set<AdventureDTO> adventures = this.FishingInstructorService.getAllAdventuresByOwnerID(id);
		return new ResponseEntity<>(adventures, HttpStatus.OK);
	}
	
	@GetMapping("/allAdventuresByOwner")
	public ResponseEntity<Set<AdventureDTO>> getAllAdventuresByOwnerUsername(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<AdventureDTO> adventures = this.FishingInstructorService.getAllAdventuresByOwnerUsername(username);
		return new ResponseEntity<>(adventures, HttpStatus.OK);
	}
	
	
	@GetMapping("/allReservationsByOwner")
	public ResponseEntity<Set<AdventureDTO>> getAllReservationsByInstructorUsername(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<AdventureDTO> adventures = this.FishingInstructorService.getAllAdventuresByOwnerUsername(username);
		return new ResponseEntity<>(adventures, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<FishingInstructorDTO>> getAll(){
		List<FishingInstructor> fishinginstructors = this.FishingInstructorService.getAll();
		List<FishingInstructorDTO> FishingInstructorsDTO = new ArrayList<FishingInstructorDTO>();
		for(FishingInstructor fishinginstructor : fishinginstructors) {
			FishingInstructorDTO fishinginstructorDTO = FishingInstructorDTO.createFishingInstructorDTO(fishinginstructor);
			FishingInstructorsDTO.add(fishinginstructorDTO);
		}
		return new ResponseEntity<>(FishingInstructorsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/all/byName")
	public ResponseEntity<List<FishingInstructorDTO>> getAllOrderByName(){
		List<FishingInstructor> fishinginstructors = this.FishingInstructorService.getAllOrderByName();
		List<FishingInstructorDTO> FishingInstructorsDTO = new ArrayList<FishingInstructorDTO>();
		for(FishingInstructor fishinginstructor : fishinginstructors) {
			FishingInstructorDTO fishinginstructorDTO = FishingInstructorDTO.createFishingInstructorDTO(fishinginstructor);
			FishingInstructorsDTO.add(fishinginstructorDTO);
		}
		return new ResponseEntity<>(FishingInstructorsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<FishingInstructorDTO> getOneInstrucotrByID(@RequestBody Long id){
		
		Optional<FishingInstructor> f =this.FishingInstructorService.findOneById(id);		
		return new ResponseEntity<>(new FishingInstructorDTO(f.get()) ,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public ResponseEntity<Boolean> deleteInstructorByID(@RequestBody Long instructor_id){	
		System.out.println("delete instructor with id:"+instructor_id);
		this.FishingInstructorService.deleteOne(instructor_id);	
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
}
	
	
	

