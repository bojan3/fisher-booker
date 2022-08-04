package com.example.fisherbooker.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.fisherbooker.model.CottageAvailabilityPeriod;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.service.CottageService;
import com.example.fisherbooker.util.FileUploadUtil;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CottageServiceImpl implements CottageService {
	private CottageRepository cottageRepository;
	private CottageReservationRepository cottageReservationRepository;
	private CottageOwnerRepository cottageOwnerRepository;

	@Autowired
	public CottageServiceImpl(CottageRepository cottageRepository,
			CottageReservationRepository cottageReservationRepository, CottageOwnerRepository cottageOwnerRepository) {
		this.cottageRepository = cottageRepository;
		this.cottageReservationRepository = cottageReservationRepository;
		this.cottageOwnerRepository = cottageOwnerRepository;
	}

	public Boolean saveCottage(CottageAddDTO cottage) {

		Cottage newCottage = cottage.toModel();

		for (Room r : newCottage.getRooms()) {
			r.setCottage(newCottage);
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		CottageOwner owner = cottageOwnerRepository.findOneByAccountUsername(username).orElse(null);
		if (owner != null) {
			newCottage.setCottageOwner(owner);
			owner.addCottage(newCottage);
		}

		this.cottageRepository.save(newCottage);
		return true;
	}

	private void saveImageToDisk(String fileName, MultipartFile file) throws IOException {
		String uploadDir = "src/main/resources/images";
		FileUploadUtil.saveFile(uploadDir, fileName, file);
	}

	public void deleteCottage(Long id) {
		this.cottageRepository.deleteById(id);
	}

	public List<Cottage> getAllbyName() {
		return this.cottageRepository.findByOrderByName();
	}

	public List<Cottage> getAllbyPrice() {
		return this.cottageRepository.findByOrderByPricePerDay();
	}

	public Cottage getById(Long id) {
		return this.cottageRepository.findById(id).orElse(null);
	}

	public List<Cottage> getAllbyRate() {
		return this.cottageRepository.findByOrderByAverageMarkDesc();
	}

	public List<Cottage> getAllByOwnerUsername(String username) {
		return this.cottageRepository.findByCottageOwnerAccountUsername(username);
	}

	public Boolean checkIfOwnerHasCottage(String username, Long cottageId) {
		List<Cottage> cottages = this.cottageRepository.findByCottageOwnerAccountUsername(username);
		for (Cottage cottage : cottages) {
			if (cottage.getId().equals(cottageId)) {
				return true;
			}
		}
		return false;
	}

	public Boolean checkIfCottageHasReservation(Long id) {
		List<CottageReservation> reservations = this.cottageReservationRepository.findByCottageId(id);
		System.out.println(reservations);
		return !reservations.isEmpty();
	}

	@Override
	public List<Cottage> getAll() {
		return cottageRepository.findAll();
	}

	/*@Override
	public List<Cottage> getAllByDate(Date date) {
		List<Cottage> cottages = cottageRepository.findAll();
		List<Cottage> returnList = new ArrayList<Cottage>();
		for (Cottage cottage: cottages) {
			if(date.after(cottage.availabilityPeriod.getStartDate()) && date.before(cottage.getAvailabilityPeriod().getEndDate())) {
			
				List<CottageReservation> cottageReservations = cottageReservationRepository.findByCottageId(cottage.getId());
				if(isFree(cottageReservations, date)) {
					returnList.add(cottage);
				}
			}
			
		}
		
		return returnList;
	}*/
	
	private boolean isFree(List<CottageReservation> cottageReservations, Date date) {
		for(CottageReservation cottageReservation: cottageReservations) {
			if(!cottageReservation.isDeleted()) {
			if (date.after(cottageReservation.getStartDate()) && date.before(cottageReservation.getEndDate())) {
				return false;
			}}
		}
		return true;
	}
	
	public Boolean checkOwnership(Long id) {
		Cottage cottage = this.cottageRepository.findById(id).orElse(null);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return cottage.getCottageOwner().getAccount().getUsername().equals(username);
	}

//	@Override
//	public List<Cottage> getAllByDate(Date date) {
//		List<Cottage> cottages = cottageRepository.findAll();
//		List<Cottage> returnList = new ArrayList<Cottage>();
//		for (Cottage cottage: cottages) {
//			if(date.before(cottage.availabilityPeriod.getStartDate()) || date.after(cottage.getAvailabilityPeriod().getEndDate()))
//				return new ArrayList<Cottage>();
//			
//			List<CottageReservation> cottageReservations = cottageReservationRepository.findByCottageId(cottage.getId());
//			if(isFree(cottageReservations, date)) {
//				returnList.add(cottage);
//			}
//		}
//		return returnList;
//	}
//	
//	private boolean isFree(List<CottageReservation> cottageReservations, Date date) {
//		for(CottageReservation cottageReservation: cottageReservations) {
//			if (date.after(cottageReservation.getStartDate()) && date.before(cottageReservation.getEndDate())) {
//				return false;
//			}
//		}
//		return true;
//	}
}
