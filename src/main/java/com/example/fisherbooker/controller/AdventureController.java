package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public AdventureController(AdventureService adventureService, FishingInstructorService fis) {
		this.adventureService = adventureService;
		this.fishinginstructorservice = fis;
	}
	
	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
		@PostMapping("/add/{InstructorId}")
		public ResponseEntity<Boolean> getAllByOwner(@RequestBody Adventure adventure){
			this.adventureService.saveAdventure(adventure);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		
		@GetMapping("/all")
		public ResponseEntity<List<AdventureDTO>> getAdventuresAll(){
			List<Adventure> adventures = this.adventureService.getAll();
			List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			for(Adventure a : adventures) {
				AdventureDTO adventureDTO =AdventureDTO.createAdventureDTO(a);
				adventuresDTO.add(adventureDTO);
			}
			return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
		}
		

		@GetMapping("/one/{id}")
		 public ResponseEntity<AdventureDTO> GetOne(@PathVariable Long id) {
			
			Optional<Adventure> adventure = this.adventureService.findOneById(id);
			
		//	adventure.get();
		//--	AdventureDTO adventureDTO = new AdventureDTO(adventure.get());
//			adventureDTO.setId(adventureDTO.getId());
//			adventureDTO.setAddress(adventureDTO.getAddress());
//			adventureDTO.setCancelRate(adventureDTO.getCancelRate());
//			adventureDTO.setDescription(adventureDTO.getDescription());
//			adventureDTO.setCapacity(adventureDTO.getCapacity());
//			adventureDTO.setName(adventureDTO.getName());
//			adventureDTO.setPrice(adventureDTO.getPrice());

			return new ResponseEntity<>(new AdventureDTO(adventure.get()), HttpStatus.OK);
		}
		
		
		
	
	  @PutMapping("/update/{AdventureID}")
	  public ResponseEntity<Boolean>updateAdventure(@PathVariable Long AdventureID, @RequestBody Adventure adventure){
		  this.adventureService.deleteById(AdventureID);
		 
		  Adventure nova =  this.adventureService.findOneById(AdventureID).get();
		  System.out.println("dobavljena avantura");
		  
		  if(adventure.getAddress()!=null)
		  nova.setAddress(adventure.getAddress());
		  
		  if(adventure.getCancelRate()!=0)
		  nova.setCancelRate(adventure.getCancelRate());
		  
		  if(adventure.getCapacity()!=0)
		  nova.setCapacity(adventure.getCapacity());
		  
		  if(adventure.getDescription()!=null)
		  nova.setDescription(adventure.getDescription());
		  
		  if(adventure.getName()!=null)
		  nova.setName(adventure.getName());
		  
		  if(adventure.getAddress()!=null)
		  nova.setPrice(adventure.getPrice());
		  
		  this.adventureService.deleteById(AdventureID);
	//	  this.adventureService.Update(nova);	
		  
		  System.out.println("updateovana avantura");
		  
			return new ResponseEntity<>(true, HttpStatus.OK);
	  }
	
	  @DeleteMapping("/delete/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    adventureService.deleteById(id);
	  }
	  
	  
	  @PostMapping("/new/{instructor_id}")
	  public ResponseEntity<Boolean>SaveAdventure(@RequestBody Adventure adventure, @PathVariable Long instructor_id ){
		  Adventure nova = new Adventure();
		  
		  nova.setAddress(adventure.getAddress());
		  nova.setCancelRate(adventure.getCancelRate());
		  nova.setCapacity(adventure.getCapacity());
		  nova.setName(adventure.getName());
		  nova.setPrice(adventure.getPrice());
		  
		  nova.fishingInstructor = this.fishinginstructorservice.getById(instructor_id);
		  		  
		  adventureService.saveAdventure(nova);
		  return new ResponseEntity<>(true,HttpStatus.OK);
	  }	
	  
	  
	  
	  @GetMapping("/all/name")
		public ResponseEntity<List<AdventureDTO>> getAllByName() {
			List<Adventure> adventures = this.adventureService.getAllByName();
			List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				AdventureDTO adventureDTO = new AdventureDTO().createAdventureDTO(adventure);
				adventuresDTO.add(adventureDTO);
			}
			return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
		}

		@GetMapping("/all/price")
		public ResponseEntity<List<AdventureDTO>> getAllByPrice() {
			List<Adventure> adventures = this.adventureService.getAllByRentPrice();
			List<AdventureDTO> shipsDTO = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				AdventureDTO shipDTO = new AdventureDTO().createAdventureDTO(adventure);
				shipsDTO.add(shipDTO);
			}
			return new ResponseEntity<>(shipsDTO, HttpStatus.OK);
		}

		@GetMapping("/all/rating")
		public ResponseEntity<List<AdventureDTO>> getAllByAverageMark() {
			List<Adventure> adventures = this.adventureService.getAllByAverageMark();
			List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				AdventureDTO adventureDTO = new AdventureDTO().createAdventureDTO(adventure);
				adventuresDTO.add(adventureDTO);
			}
			return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
		}

		@GetMapping("/all/capacity")
		public ResponseEntity<List<AdventureDTO>> getAllByCapacity() {
			List<Adventure> adventures = this.adventureService.getAllByCapacity();
			List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				AdventureDTO adventureDTO = new AdventureDTO().createAdventureDTO(adventure);
				adventuresDTO.add(adventureDTO);
			}
			return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
		}

	/*
		@GetMapping("/get/delete/{AdventureId}")
		public ResponseEntity<List<AdventureDTO>> deleteShip(@PathVariable("AdventureId") Long AdventureId) {
			List<Adventure> adventures = this.adventureService.getAll();
			List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				if (adventure.getId().equals(AdventureId)) {
					this.adventureService.deleteAdventure(AdventureId);
					System.out.println("Brod sa identifikatorom" + AdventureId + "je uspesno obrisan");
				} else {
					AdventureDTO adventureDTO = new AdventureDTO().createAdventureDTO(adventure);
					adventuresDTO.add(adventureDTO);
				}
			}
			return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
		}
		
	*/

		@PostMapping("/save")
		public ResponseEntity<Boolean> save(@RequestBody Adventure adventure) {
			//String username = SecurityContextHolder.getContext().getAuthentication().getName();
			//if (this.adventureService.checkIfOwnerHasAdventure(username, adventure.getId())) {
				this.adventureService.saveAdventure(adventure);
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			//return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	//	}
	 
}
