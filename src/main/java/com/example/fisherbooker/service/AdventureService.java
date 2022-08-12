package com.example.fisherbooker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureFastReservation;
import com.example.fisherbooker.model.AdventureOption;
import com.example.fisherbooker.model.AdventurePicture;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingEquipment;
import com.example.fisherbooker.model.Rule;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.repository.AdventureRepository;

@Service
public class AdventureService {

	public AdventureRepository adventureRepository;

	@Autowired
	public AdventureService(AdventureRepository ar) {

		this.adventureRepository = ar;

	}

	public void Save(String name, String adress, String description, AdventurePicture pic, int capacity,
			AdventureFastReservation afr, Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {

	}

	public Adventure saveAdventure(Adventure adventure) {
		return adventureRepository.save(adventure);

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

	public Optional<Adventure> findOneById(Long id) {
		return adventureRepository.findById(id);
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

}
