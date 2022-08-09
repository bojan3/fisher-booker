package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
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

//	@PostMapping("/add/{ownerId}")	
//	public ResponseEntity<Boolean> getAllByOwner(@RequestBody Cottage cottage) {
//		this.cottageService.saveCottage(cottage);
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

//	@PostMapping("/save")
//	public ResponseEntity<Boolean> save(@RequestBody Cottage cottage) {
//		this.cottageService.saveCottage(cottage);
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}

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


	@PostMapping("/uploadImage")
	public ResponseEntity<Boolean> uploadImage(@RequestParam("image") MultipartFile file,
			@RequestParam("cottage") String cottage) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(cottage);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PostMapping("/all/date")
	public ResponseEntity<List<CottageDTO>> getAllByDate(@RequestBody Date date) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date = formatter.parse(dateInput);
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}

		System.out.println("datum: " + date);
//		System.out.println("datum: " + date.toGMTString());
//		
//		List<Cottage> cottages = this.cottageService.getAllByDate(date);
//		
//		List<CottageDTO> cottagesDTO = new ArrayList<CottageDTO>();
//		for (Cottage cottage : cottages) {
//			CottageDTO cottageDTO = CottageDTO.createCottageDTO(cottage);
//			cottagesDTO.add(cottageDTO);
//		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

//	private String getDate(String dateString) {
//		String[] part = dateString.split("T");
//		return part[0];
//	}

	@GetMapping("ownership/{id}")
	public ResponseEntity<Boolean> checkOwnership(@PathVariable Long id) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
