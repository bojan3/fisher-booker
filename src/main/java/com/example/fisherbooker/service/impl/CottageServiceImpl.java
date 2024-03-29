package com.example.fisherbooker.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageImage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Room;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.model.DTO.EditCottageDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;
import com.example.fisherbooker.repository.CottageOptionRepository;
import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.CottageRepository;
import com.example.fisherbooker.repository.CottageReservationRepository;
import com.example.fisherbooker.repository.ImageRepository;
import com.example.fisherbooker.service.CottageService;

@Service
public class CottageServiceImpl implements CottageService {
	
	private CottageRepository cottageRepository;
	private CottageReservationRepository cottageReservationRepository;
	private CottageOwnerRepository cottageOwnerRepository;
	private CottageOptionRepository cottageOptionRepository;
	private ImageRepository imageRepository;

	@Autowired
	public CottageServiceImpl(CottageRepository cottageRepository,
			CottageReservationRepository cottageReservationRepository, CottageOwnerRepository cottageOwnerRepository,
			CottageOptionRepository cottageOptionRepository, ImageRepository cottageImageRepository) {
		this.cottageRepository = cottageRepository;
		this.cottageReservationRepository = cottageReservationRepository;
		this.cottageOwnerRepository = cottageOwnerRepository;
		this.cottageOptionRepository = cottageOptionRepository;
		this.imageRepository = cottageImageRepository;
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
	
	@Transactional
	public Boolean edit(EditCottageDTO cottage) throws OptimisticLockException {
		Cottage oldCottage = this.cottageRepository.findById(cottage.getId()).orElse(null);
		if(checkIfCottageHasReservation(cottage.getId())) {
			return false;
		}
		oldCottage.setName(cottage.getName());
		oldCottage.setAddress(cottage.getAddress());
		oldCottage.setAvailabilityPeriod(cottage.getAvailabilityPeriod());
		oldCottage.setDescription(cottage.getDescription());
		oldCottage.setPricePerDay(cottage.getPricePerDay());
		oldCottage.setRooms(cottage.getRooms());
		oldCottage.setRules(cottage.getRules());
		oldCottage.setCottageOptions(cottage.getCottageOptions());
		this.cottageRepository.save(oldCottage);
		return true;
	}

	public void deleteCottage(Long id) {
		//System.out.println(this.cottageRepository.getById(id));
		Cottage cottage = this.cottageRepository.findById(id).get();
		cottage.setIsDeleted(true);
		this.cottageRepository.save(cottage);
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
		List<CottageReservation> reservations = this.cottageReservationRepository.isCottageReserved(id);
		System.out.println(reservations);
		return !reservations.isEmpty();
	}

	@Override
	public List<Cottage> getAll() {
		return cottageRepository.findAll();
	}

	/*
	 * @Override public List<Cottage> getAllByDate(Date date) { List<Cottage>
	 * cottages = cottageRepository.findAll(); List<Cottage> returnList = new
	 * ArrayList<Cottage>(); for (Cottage cottage: cottages) {
	 * if(date.after(cottage.availabilityPeriod.getStartDate()) &&
	 * date.before(cottage.getAvailabilityPeriod().getEndDate())) {
	 * 
	 * List<CottageReservation> cottageReservations =
	 * cottageReservationRepository.findByCottageId(cottage.getId());
	 * if(isFree(cottageReservations, date)) { returnList.add(cottage); } }
	 * 
	 * }
	 * 
	 * return returnList; }
	 */

	private boolean isFree(List<CottageReservation> cottageReservations, Date date) {
		for (CottageReservation cottageReservation : cottageReservations) {
			if (!cottageReservation.isDeleted()) {
				if (date.after(cottageReservation.getStartDate()) && date.before(cottageReservation.getEndDate())) {
					return false;
				}
			}
		}
		return true;
	}

	public Boolean checkOwnership(Long id) {
		Cottage cottage = this.cottageRepository.findById(id).orElse(null);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return cottage.getCottageOwner().getAccount().getUsername().equals(username);
	}

	@Override
	public List<Cottage> getAllSorted(String type, String order) {
		if (order.equals("ASC"))
			return cottageRepository.findAll(Sort.by(type).ascending());
		return cottageRepository.findAll(Sort.by(type).descending());
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

	public List<CottageOption> getOptions(Long cottageId) {
		return this.cottageOptionRepository.findByCottageId(cottageId);
	}

	@Override
	public List<String> getCottageLocations() {
		return this.cottageRepository.getCottageLocations();
	}

	@Override
	public List<Cottage> searchCottages(SearchFilter searchFilter) {
		List<Cottage> cottages = this.cottageRepository.getAllAvalible(searchFilter.getStartDate(),
				searchFilter.getEndDate());

		if (searchFilter.getMinGrade() != null) {
			Iterator<Cottage> it = cottages.iterator();
			while (it.hasNext()) {
				if (it.next().getAverageMark() < searchFilter.getMinGrade()) {
					it.remove();
				}
			}

		}

		if (searchFilter.getLocationCity() != null) {
			Iterator<Cottage> it = cottages.iterator();
			while (it.hasNext()) {
				if (!it.next().getAddress().getCity().equals(searchFilter.getLocationCity())) {
					it.remove();
				}
			}
		}

		return cottages;
	}

	public Boolean uploadImage(Long id, MultipartFile image) throws IOException {
		CottageImage newImage = new CottageImage();
		newImage.setName(image.getOriginalFilename());
		newImage.setType(image.getContentType());
		newImage.setImage(image.getBytes());
		Cottage c = this.getById(id);
		newImage.setCottage(c);
		c.addImage(newImage);
		this.imageRepository.save(newImage);
		return true;
	}

	public Boolean deleteImage(Long id) {
		this.imageRepository.deleteById(id);
		return true;
	}

}
