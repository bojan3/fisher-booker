package com.example.fisherbooker.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureImage;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageImage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.model.DTO.AdventureAddDTO;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.repository.AdventureOptionsRepository;
import com.example.fisherbooker.repository.AdventureRepository;
import com.example.fisherbooker.repository.AdventureReservationRepository;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.ImageRepository;

@Service
public class AdventureService {

	public AdventureRepository adventureRepository;
	private AdventureReservationRepository adventureReservationRepository;
	private FishingInstructorRepository instructorRepository;
	private AdventureOptionsRepository adventureOptionRepository;
	private ImageRepository imageRepository;


	@Autowired
	public AdventureService(AdventureRepository ar, ImageRepository imgr, AdventureReservationRepository  arr, FishingInstructorRepository fir , AdventureOptionsRepository aor) {

		this.adventureReservationRepository = arr;
		this.adventureOptionRepository = aor;
		this.instructorRepository = fir;
		this.adventureRepository = ar;
		this.imageRepository = imgr;
	}

	public void Save(String name, String adress, String description, AdventurePicture pic, int capacity,
			AdventureFastReservation afr, Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {

	}

	public Adventure saveAdventure(AdventureAddDTO adventure) {
		Adventure newAdventure = adventure.toModel();

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		FishingInstructor owner = this.instructorRepository.findByAccountUsername(username).orElse(null);
		if (owner != null) {
			newAdventure.setFishingInstructor(owner);
			owner.addAdventure(newAdventure);
		}
		
		return adventureRepository.save(adventure);

	}
	
	
	public List<Adventure> getAllSorted(String type, String order) {
		if (order.equals("ASC"))
			return adventureRepository.findAll(Sort.by(type).ascending());
		return adventureRepository.findAll(Sort.by(type).descending());
	}

	public List<Adventure> getAll() {
		return adventureRepository.findAll();
	}

	public List<Adventure> getAllByName() {
		return adventureRepository.findByOrderByName();
	}

	public List<Adventure> getAllByPrice() {
		return adventureRepository.findByOrderByPrice();
	}

	public List<Adventure> getAllByCapacity() {
		return adventureRepository.findByOrderByCapacityDesc();
	}

	public Adventure deleteById(Long id) {
		return adventureRepository.deleteAllById(id);
	}

//	by instructor id
	public List<Adventure> getAllByInstructor(Long instructorId) {
		return adventureRepository.findByInstructor(instructorId);
	}

	public List<Adventure> getAllByAccountOrderByName(Long instructorId) {
		return adventureRepository.findByInstructorOrderByName(instructorId);
	}

	public List<Adventure> getAllByAccountOrderByPrice(Long instructorId) {
		return adventureRepository.findByInstructorOrderByPrice(instructorId);
	}

	public List<Adventure> getAllByAccountOrderByCapacity(Long instructorId) {
		return adventureRepository.findByInstructorOrderByCapacity(instructorId);
	}

	public Adventure getById(Long id) {
		return adventureRepository.getById(id);
	}

	public Adventure findOneById(Long id) {
		return adventureRepository.findById(id).get();
	}

//public List<Adventure> getAllByName() {
	// TODO Auto-generated method stub
//	return ar.findByOrderByName();
//}

	public List<Adventure> getAllByRentPrice() {
		// TODO Auto-generated method stub
		return adventureRepository.findByOrderByPrice();
	}

	public List<Adventure> getAllByAverageMark() {
		// TODO Auto-generated method stub
		return adventureRepository.findByOrderByName();
	}

	public Boolean checkIfOwnerHasAdventure(String username, Long adventureId) {
		List<Adventure> adventures = this.adventureRepository.findByFishingInstructorAccountUsername(username);
		for (Adventure adventure : adventures) {
			System.out.println(adventure.getFishingInstructor());
			if (adventure.getId().equals(adventureId)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean uploadImage(Long id, MultipartFile image) throws IOException {
		AdventureImage newImage = new AdventureImage();
		newImage.setName(image.getOriginalFilename());
		newImage.setType(image.getContentType());
		newImage.setImage(image.getBytes());
		Adventure a = this.getById(id);
		newImage.setAdventure(a);
		a.addImage(newImage);
		this.imageRepository.save(newImage);
		return true;
	}

	public void delete(Long adventure_id) {
		Adventure adv =this.adventureRepository.findById(adventure_id).get();
		adv.setIsDeleted(true);
		this.adventureRepository.save(adv);		
	}

	public boolean checkIfAdventureHasReservation(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Adventure> getAllByOwnerUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAdventureLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CottageOption> getOptions(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Adventure> searchAdventures(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

}
