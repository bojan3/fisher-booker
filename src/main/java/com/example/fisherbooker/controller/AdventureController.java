package com.example.fisherbooker.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.DTO.AdventureAddDTO;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.model.DTO.ShipDTO;
import com.example.fisherbooker.service.AdventureReservationService;
import com.example.fisherbooker.service.AdventureService;
import com.example.fisherbooker.service.CottageReservationService;
import com.example.fisherbooker.service.FishingInstructorService;

@RestController
@RequestMapping("/api/adventure")
public class AdventureController {
	public AdventureService adventureService;
	public FishingInstructorService fishinginstructorservice;
	public AdventureReservationService adventureReservationService;


	@Autowired
	public AdventureController(AdventureService adventureService, FishingInstructorService fis) {
		this.adventureService = adventureService;
		this.fishinginstructorservice = fis;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<AdventureDTO>> getAlll() {
		List<Adventure> adventures = this.adventureService.getAll();
		List<AdventureDTO>adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure adventure : adventures) {
			if(!adventure.getIsDeleted())
			{
				AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(adventure);
				adventureDTO.setId(adventure.getId());
				adventuresDTO.add(adventureDTO);
			}
										}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/all/")
	public ResponseEntity<List<AdventureDTO>> getAllSorted(@RequestParam String type, @RequestParam String order) {
		List<Adventure> adventures = this.adventureService.getAllSorted(type, order);
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure adventure : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(adventure);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/page/{id}")
	public ResponseEntity<Adventure> getById(@PathVariable Long id) {
		Adventure adventure = this.adventureService.getById(id);
		return new ResponseEntity<>(adventure, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('FISHING_INSTRUCTOR')")
	@DeleteMapping("/delete/owner/{AdventureId}")
	public ResponseEntity<List<AdventureDTO>> delete(@PathVariable("AdventureId") Long id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (this.adventureService.checkIfOwnerHasAdventure(username, id)) {

			if (!this.adventureService.checkIfAdventureHasReservation(id)) {
				this.adventureService.delete(id);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}
		List<Adventure> ownersAdventures = this.adventureService.getAllByOwnerUsername(username);
		List<AdventureDTO> adventureDTOs = new ArrayList<AdventureDTO>();
		for (Adventure adventure : ownersAdventures) {
			adventureDTOs.add(AdventureDTO.createAdventureDTO(adventure));
		}
		return new ResponseEntity<>(adventureDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/delete")
		public ResponseEntity<List<AdventureDTO>> deleteAadventure(@RequestBody Long adventure_id) {
			this.adventureService.delete(adventure_id);
			List<Adventure> adventures = this.adventureService.getAll();
			List<AdventureDTO> adventureDTOs = new ArrayList<AdventureDTO>();
			for (Adventure adventure : adventures) {
				if(!adventure.getIsDeleted())
				{
					AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(adventure);
					adventureDTO.setId(adventure.getId());
					adventureDTOs.add(adventureDTO);
				}
											}
			return new ResponseEntity<>(adventureDTOs, HttpStatus.OK);
		}
	

	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
	@PostMapping("/add/{InstructorId}")
	public ResponseEntity<Boolean> getAllByOwner(@RequestBody AdventureAddDTO adventure) {
		this.adventureService.saveAdventure(adventure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}



	@GetMapping("/one/{id}")
	public ResponseEntity<AdventureDTO> GetOne(@PathVariable Long id) {

		Adventure adventure = this.adventureService.findOneById(id);
		
		AdventureDTO response = new AdventureDTO(adventure);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{AdventureID}")
	public ResponseEntity<Boolean> updateAdventure(@PathVariable Long AdventureID, @RequestBody Adventure adventure) {
		this.adventureService.deleteById(AdventureID);

		Adventure nova = this.adventureService.findOneById(AdventureID);
		System.out.println("dobavljena avantura");

		if (adventure.getAddress() != null)
			nova.setAddress(adventure.getAddress());

		if (adventure.getCancelRate() != 0)
			nova.setCancelRate(adventure.getCancelRate());

		if (adventure.getCapacity() != 0)
			nova.setCapacity(adventure.getCapacity());

		if (adventure.getDescription() != null)
			nova.setDescription(adventure.getDescription());

		if (adventure.getName() != null)
			nova.setName(adventure.getName());

		if (adventure.getAddress() != null)
			nova.setPrice(adventure.getPrice());

		this.adventureService.deleteById(AdventureID);
		// this.adventureService.Update(nova);

		System.out.println("updateovana avantura");

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	void deleteEmployee(@PathVariable Long id) {
		adventureService.deleteById(id);
	}

//	@PostMapping("/new/{instructor_id}")
//	public ResponseEntity<Boolean> SaveAdventure(@RequestBody Adventure adventure, @PathVariable Long instructor_id) {
//		Adventure nova = new Adventure();

//		nova.setAddress(adventure.getAddress());
//		nova.setCancelRate(adventure.getCancelRate());
//		nova.setCapacity(adventure.getCapacity());
//		nova.setName(adventure.getName());
//		nova.setPrice(adventure.getPrice());

//		nova.fishingInstructor = this.fishinginstructorservice.getById(instructor_id);

//		adventureService.saveAdventure(nova);
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}

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
	 * @GetMapping("/get/delete/{AdventureId}") public
	 * ResponseEntity<List<AdventureDTO>> deleteShip(@PathVariable("AdventureId")
	 * Long AdventureId) { List<Adventure> adventures =
	 * this.adventureService.getAll(); List<AdventureDTO> adventuresDTO = new
	 * ArrayList<AdventureDTO>(); for (Adventure adventure : adventures) { if
	 * (adventure.getId().equals(AdventureId)) {
	 * this.adventureService.deleteAdventure(AdventureId);
	 * System.out.println("Brod sa identifikatorom" + AdventureId +
	 * "je uspesno obrisan"); } else { AdventureDTO adventureDTO = new
	 * AdventureDTO().createAdventureDTO(adventure);
	 * adventuresDTO.add(adventureDTO); } } return new
	 * ResponseEntity<>(adventuresDTO, HttpStatus.OK); }
	 * 
	 */

	@PostMapping("/save")
	public ResponseEntity<Boolean> save(@RequestBody AdventureAddDTO adventure) {
		// String username =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		// if (this.adventureService.checkIfOwnerHasAdventure(username,
		// adventure.getId())) {
		this.adventureService.saveAdventure(adventure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/locations")
	public ResponseEntity<List<String>> getAdventureLocations() {
		List<String> locations = this.adventureService.getAdventureLocations();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

	
	@GetMapping("ownership/{id}")
	public ResponseEntity<Boolean> checkOwnership(@PathVariable Long id) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("options/{id}")
	public ResponseEntity<List<CottageOption>> getOptions(@PathVariable Long id) {
		return new ResponseEntity<>(this.adventureService.getOptions(id), HttpStatus.OK);
	}

	@GetMapping("search/filter/")
	public ResponseEntity<List<AdventureDTO>> searchAdventures(@RequestParam String startDate, @RequestParam String endDate,
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
		List<Adventure> adventures = adventureService.searchAdventures(searchFilter);
		return new ResponseEntity<>(toDTOs(adventures), HttpStatus.OK);
	}

	private List<AdventureDTO> toDTOs(List<Adventure> adventures) {
		List<AdventureDTO> adventureDTOs = new ArrayList<AdventureDTO>();
		for (Adventure adventure : adventures) {
			adventureDTOs.add(AdventureDTO.createAdventureDTO(adventure));
		}
		return adventureDTOs;
	}

	@GetMapping("dates/{id}")
	public ResponseEntity<List<DatePeriodDTO>> getReservationDates(@PathVariable Long id) {
		return new ResponseEntity<>(this.adventureReservationService.getReservationDates(id), HttpStatus.OK);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<Boolean> uplaodImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {

		try {
			this.adventureService.uploadImage(id, file);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/all/instructor/{instructorId}")
	public ResponseEntity<List<AdventureDTO>> getAllByInstructorId(@PathVariable Long instructorId) {
		List<Adventure> adventures = this.adventureService.getAllByInstructor(instructorId);

//		System.out.println(Avanture:" + "");

		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@GetMapping("/all/instructor/{instructorId}/orderByName")
	public ResponseEntity<List<AdventureDTO>> getAllByInstructorIdOrderByName(@PathVariable Long instructorId) {
		List<Adventure> adventures = this.adventureService.getAllByAccountOrderByName(instructorId);
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@GetMapping("/all/instructor/{instructorId}/orderByPrice")
	public ResponseEntity<List<AdventureDTO>> getAllByInstructorIdOrderByPrice(@PathVariable Long instructorId) {
		List<Adventure> adventures = this.adventureService.getAllByAccountOrderByPrice(instructorId);
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		for (Adventure a : adventures) {
			AdventureDTO adventureDTO = AdventureDTO.createAdventureDTO(a);
			adventuresDTO.add(adventureDTO);
		}
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}

	@GetMapping("/all/instructor/{instructorId}/orderByCapacity")
	public ResponseEntity<List<AdventureDTO>> getAllByInstructorIdOrderByCapacity(@PathVariable Long instructorId) {
		List<Adventure> adventures = this.adventureService.getAllByAccountOrderByCapacity(instructorId);
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

//	@DeleteMapping("/delete/{id}")
//	void deleteEmployee(@PathVariable Long id) {
//		adventureService.deleteById(id);
//	}


}
