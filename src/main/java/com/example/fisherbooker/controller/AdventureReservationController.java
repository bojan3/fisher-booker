package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.AdventureReservationDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.service.AdventureReservationService;
import com.example.fisherbooker.service.AdventureService;
import com.example.fisherbooker.service.ClientService;
import com.example.fisherbooker.service.FishingInstructorService;

	@RestController
	@RequestMapping("/api/adventurereservation")
	public class AdventureReservationController {
	public AdventureReservationService adventurereservationservice;
	public AdventureService adventureservice;
	public ClientService clientservice;
	public FishingInstructorService fishinginstructorservice;
		
		@Autowired
		public AdventureReservationController(AdventureReservationService adventureRService, AdventureService adventureService, ClientService cs, FishingInstructorService fs) {
			this.adventurereservationservice = adventureRService;
			this.adventureservice = adventureService;
			this.clientservice = cs;
			this.fishinginstructorservice = fs;
		}
		
		// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
			@PostMapping("/add/{AdventureId}")
			public ResponseEntity<Boolean> getAllByAdventure(@RequestParam Long AdventureId, @RequestParam Long client_id){
				
				Adventure a = this.adventureservice.findOneById(AdventureId).get();

				if(a.adventureReservation.size()>=a.getCapacity()) {
					
					System.out.println("Sva mesta su popunjena!");
					
					return new ResponseEntity<>(true, HttpStatus.FORBIDDEN);
				}
					
				AdventureReservation arr = new AdventureReservation();
				
				arr.adventure=a;
				arr.client = this.clientservice.findOneById(client_id).get();
				//arr.setCapacity(a.getCapacity());
				arr.setPrice(a.getPrice());
				
				this.adventurereservationservice.arr.save(arr);		
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			
			
			@GetMapping("/all/adventure/{adventure_id}")
			public ResponseEntity<List<AdventureReservationDTO>> getAllByAdventureID(@PathVariable Long adventure_id){
				System.out.println("usli smo u metodu");
				List<AdventureReservation> adventures = this.adventurereservationservice.getAllByAdventure(adventure_id);
				System.out.println("dobavili smo listu rezervacija");
				List<AdventureReservationDTO> adventuresDTO = new ArrayList<AdventureReservationDTO>();
				for(AdventureReservation a : adventures) {
					AdventureReservationDTO adventureDTO = new AdventureReservationDTO(a);
					adventuresDTO.add(adventureDTO);
				}
				System.out.println("zavrsili smo kreiranje DTO objekata");
				return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
			}
			
			
			
			@GetMapping("/all/client/{client_id}")
			public ResponseEntity<List<AdventureReservationDTO>> getAllByClientID(@PathVariable Long client_id){
				List<AdventureReservation> adventures = this.adventurereservationservice.getAllByClient(this.clientservice.findOneById(client_id).get());
				List<AdventureReservationDTO> adventuresDTO = new ArrayList<AdventureReservationDTO>();
				for(AdventureReservation a : adventures) {
					AdventureReservationDTO adventureDTO =AdventureReservationDTO.createAdventureReservationDTO(a);
					adventuresDTO.add(adventureDTO);
				}
				return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
			}
			
			
			@GetMapping("/all/instructor_id/{instructor_id}")
			public ResponseEntity<List<AdventureReservationDTO>> getAllByInstructorID(@PathVariable Long instructor_id){		
				
				List<AdventureReservation> adventures = this.adventurereservationservice.getAllByInstructor(instructor_id);
				List<AdventureReservationDTO> adventuresDTO = new ArrayList<AdventureReservationDTO>();
		
				for(AdventureReservation a : adventures) {
					AdventureReservationDTO adventureDTO = new AdventureReservationDTO(a);					
					adventuresDTO.add(adventureDTO);
				}
				return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);	
			}
			
			@GetMapping("/all/instructor_username/{instructor_username}")
			public ResponseEntity<List<AdventureReservationDTO>> getAllByInstructorUsername(@PathVariable String instructor_username){		
				
				List<AdventureReservation> adventures = this.adventurereservationservice.getAllByInstructorAccountUsername(instructor_username);
				List<AdventureReservationDTO> adventuresDTO = new ArrayList<AdventureReservationDTO>();
		
				for(AdventureReservation a : adventures) {
					AdventureReservationDTO adventureDTO = new AdventureReservationDTO(a);					
					adventuresDTO.add(adventureDTO);
				}
				return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);	
			}
			
			
			

			@GetMapping("/one/{id}")
			 public ResponseEntity<AdventureReservationDTO> GetOne(@PathVariable Long id) {
				
				Optional<AdventureReservation> adventure = this.adventurereservationservice.findOneById(id);
				
			//	adventure.get();
			//--	AdventureDTO adventureDTO = new AdventureDTO(adventure.get());
//				adventureDTO.setId(adventureDTO.getId());
//				adventureDTO.setAddress(adventureDTO.getAddress());
//				adventureDTO.setCancelRate(adventureDTO.getCancelRate());
//				adventureDTO.setDescription(adventureDTO.getDescription());
//				adventureDTO.setCapacity(adventureDTO.getCapacity());
//				adventureDTO.setName(adventureDTO.getName());
//				adventureDTO.setPrice(adventureDTO.getPrice());

				return new ResponseEntity<>(new AdventureReservationDTO(adventure.get()), HttpStatus.OK);
			}
		
		  @PutMapping("/update/{AdventureID}")
		  public ResponseEntity<Boolean>updateAdventure(@RequestBody AdventureReservation adventurer){
			  this.adventurereservationservice.saveAdventureReservation(adventurer);		  
				return new ResponseEntity<>(true, HttpStatus.OK);

		  }
		
		  @DeleteMapping("/delete/{id}")
		  void deleteEmployee(@PathVariable Long id) {
			  adventurereservationservice.deleteById(id);
		  }
		  
		  
		  @PostMapping("/new")
		  public ResponseEntity<Boolean>SaveAdventure(@RequestBody AdventureReservation adventurer){
			  adventurereservationservice.saveAdventureReservation(adventurer);
			  return new ResponseEntity<>(true,HttpStatus.OK);
		  }	
	}

