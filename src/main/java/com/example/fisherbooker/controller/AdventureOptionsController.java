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
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.service.AdventureOptionsService;
import com.example.fisherbooker.service.AdventureService;
import com.example.fisherbooker.service.FishingInstructorService;


	@RestController
	@RequestMapping("/api/adventure/options")
	public class AdventureOptionsController {
	public AdventureOptionsService adventureOptionService;
	public AdventureService adventureService;
		
		@Autowired
		public AdventureOptionsController(AdventureOptionsService adventureService) {
			this.adventureOptionService = adventureService;
		}
		
		// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
			@PostMapping("/add/{AdventureId}")
			public ResponseEntity<Boolean> getAllByAdventure(@RequestBody AdventureOption adventureOption){
				this.adventureOptionService.saveAdventureOption(adventureOption);
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			
			
			@GetMapping("/all")
			public ResponseEntity<List<AdventureOption>> getAll(){
				List<AdventureOption> adventures = this.adventureOptionService.getAll();
			//	List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
			//	for(Adventure a : adventures) {
			//		AdventureDTO adventureDTO =AdventureDTO.createAdventureDTO(a);
			//		adventuresDTO.add(adventureDTO);
			//	}
				return new ResponseEntity<>(adventures, HttpStatus.OK);
			}
			

				 
		
		  @PostMapping("/update/{AdventureID}")
		  public ResponseEntity<Boolean>updateAdventure(@RequestBody Adventure adventure){
			  
			  
				return new ResponseEntity<>(true, HttpStatus.OK);

		  }
		
		  @DeleteMapping("/delete/{id}")
		  void deleteEmployee(@PathVariable Long id) {
		//    adventureOptionService.deleteById(id);
		  }
		  
		  
		  @PostMapping("/new")
		  public ResponseEntity<Boolean>SaveAdventure(@RequestBody Adventure adventure){
	//		  adventureOptionService.saveAdventure(adventure);
			  return new ResponseEntity<>(true,HttpStatus.OK);
		  }

}
