package com.example.fisherbooker.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.OptimisticLockException;

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

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.EditCottageDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.service.CottageReservationService;
import com.example.fisherbooker.service.CottageService;

@RestController
@RequestMapping("/api/cottage")
public class CottageController {

	public CottageService cottageService;
	public CottageReservationService cottageReservationService;

	@Autowired
	public CottageController(CottageService cottageService, CottageReservationService cottageReservationService) {
		this.cottageService = cottageService;
		this.cottageReservationService = cottageReservationService;
	}

//	@PostMapping("/add/{ownerId}")

//	public ResponseEntity<Boolean> getAllByOwner(@RequestBody Cottage cottage) {
//		this.cottageService.saveCottage(cottage);

//	public ResponseEntity<Boolean> getAllByOwner(@RequestBody CottageAddDTO cottageAddDTO) {
//		this.cottageService.saveCottage(cottageAddDTO);
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}

	@GetMapping("/all")
	public ResponseEntity<List<CottageDTO>> getAll() {
		List<Cottage> cottages = this.cottageService.getAll();
		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
		for (Cottage cottage : cottages) {
			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
			cottagesDTO.add(cottageDTO);
		}
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}

	@GetMapping("/all/")
	public ResponseEntity<List<CottageDTO>> getAllSorted(@RequestParam String type, @RequestParam String order) {
		List<Cottage> cottages = this.cottageService.getAllSorted(type, order);
		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
		for (Cottage cottage : cottages) {
			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
			cottagesDTO.add(cottageDTO);
		}
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}

	@GetMapping("/page/{id}")
	public ResponseEntity<Cottage> getById(@PathVariable Long id) {
		Cottage cottage = this.cottageService.getById(id);
		return new ResponseEntity<>(cottage, HttpStatus.OK);
	}

//	@GetMapping("/all/price")
//	public ResponseEntity<List<CottageDTO>> getAllbyPrice() {
//		List<Cottage> cottages = this.cottageService.getAllbyPrice();
//		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
//		for (Cottage cottage : cottages) {
//			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
//			cottagesDTO.add(cottageDTO);
//		}
//		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
//	}
//
//	@GetMapping("/all/rate")
//	public ResponseEntity<List<CottageDTO>> getAllByRate() {
//		List<Cottage> cottages = this.cottageService.getAllbyRate();
//		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
//		for (Cottage cottage : cottages) {
//			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
//			cottagesDTO.add(cottageDTO);
//		}
//		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
//	}

	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	@DeleteMapping("/delete/owner/{CottageId}")
	public ResponseEntity<List<CottageDTO>> delete(@PathVariable("CottageId") Long id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (this.cottageService.checkIfOwnerHasCottage(username, id)) {

			if (!this.cottageService.checkIfCottageHasReservation(id)) {
				this.cottageService.deleteCottage(id);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}
		List<Cottage> ownersCottages = this.cottageService.getAllByOwnerUsername(username);
		List<CottageDTO> cottageDTOs = new ArrayList<CottageDTO>();
		for (Cottage cottage : ownersCottages) {
			cottageDTOs.add(CottageDTO.createCottageDTO(cottage));
		}
		return new ResponseEntity<>(cottageDTOs, HttpStatus.OK);
	}

	@GetMapping("/locations")
	public ResponseEntity<List<String>> getCottageLocations() {
		List<String> locations = this.cottageService.getCottageLocations();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Boolean> save(@RequestBody CottageAddDTO cottage) {
		this.cottageService.saveCottage(cottage);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody EditCottageDTO cottage) {
		Boolean response = false;
		try {
			response = this.cottageService.updateCottage(cottage);
		} catch (OptimisticLockException e) {
			return new ResponseEntity<>(true, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@GetMapping("/all/date/{dateString}")
//	public ResponseEntity<List<CottageDTO>> getAllByDate(@PathVariable String dateString) {
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date = formatter.parse(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//		System.out.println("datum: " + date);
//		// ovde je sad problem zbog liste valjda
////		List<Cottage> cottages = this.cottageService.getAllByDate(date);
//		
//		List<CottageDTO> cottagesDTOs = new ArrayList<CottageDTO>();
//		for (Cottage cottage : cottages) {
//			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
//			cottagesDTOs.add(cottageDTO);
//		}
//		return new ResponseEntity<>(cottagesDTOs, HttpStatus.OK);
//	}

//	@PostMapping("/uploadImage")
//	public ResponseEntity<Boolean> uploadImage(@RequestParam("image") MultipartFile file,
//			@RequestParam("cottage") String cottage) {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		System.out.println(cottage);
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}

// visak je ovo valjda
//	@PostMapping("/all/date")
//	public ResponseEntity<List<CottageDTO>> getAllByDate(@RequestBody Date date) {
////		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////		Date date = null;
////		try {
////			date = formatter.parse(dateInput);
////		} catch (ParseException e) {
////			
////			e.printStackTrace();
////		}
//
//		System.out.println("datum: " + date);
////		System.out.println("datum: " + date.toGMTString());
////		
////		List<Cottage> cottages = this.cottageService.getAllByDate(date);
////		
////		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
////		for (Cottage cottage : cottages) {
////			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
////			cottagesDTO.add(cottageDTO);
////		}
//
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}

//	private String getDate(String dateString) {
//		String[] part = dateString.split("T");
//		return part[0];
//	}

	@GetMapping("ownership/{id}")
	public ResponseEntity<Boolean> checkOwnership(@PathVariable Long id) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("options/{id}")
	public ResponseEntity<List<CottageOption>> getOptions(@PathVariable Long id) {
		return new ResponseEntity<>(this.cottageService.getOptions(id), HttpStatus.OK);
	}

	@GetMapping("search/filter/")
	public ResponseEntity<List<CottageDTO>> searchCottages(@RequestParam String startDate, @RequestParam String endDate,
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
		List<Cottage> cottages = cottageService.searchCottages(searchFilter);
		return new ResponseEntity<>(toDTOs(cottages), HttpStatus.OK);
	}

	private List<CottageDTO> toDTOs(List<Cottage> cottages) {
		List<CottageDTO> cottageDTOs = new ArrayList<CottageDTO>();
		for (Cottage cottage : cottages) {
			cottageDTOs.add(CottageDTO.createCottageDTO(cottage));
		}
		return cottageDTOs;
	}

	@GetMapping("dates/{id}")
	public ResponseEntity<List<DatePeriodDTO>> getReservationDates(@PathVariable Long id) {
		return new ResponseEntity<>(this.cottageReservationService.getReservationDates(id), HttpStatus.OK);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<Boolean> uplaodImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {

		try {
			this.cottageService.uploadImage(id, file);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	@DeleteMapping("/delete/image/{id}")
	public ResponseEntity<Boolean> deleteImage(@PathVariable("id") Long id) {
		this.cottageService.deleteImage(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
