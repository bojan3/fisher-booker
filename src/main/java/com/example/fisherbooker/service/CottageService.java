package com.example.fisherbooker.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOption;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.model.DTO.CottageDTO;
import com.example.fisherbooker.model.DTO.EditCottageDTO;
import com.example.fisherbooker.model.DTO.SearchFilter;

public interface CottageService {

	public Boolean saveCottage(CottageAddDTO cottage);

	public void deleteCottage(Long id);

	public List<Cottage> getAllbyName();

	public List<Cottage> getAllbyPrice();

	public Cottage getById(Long id);

	public List<Cottage> getAllbyRate();

	public List<Cottage> getAllByOwnerUsername(String username);

	public Boolean checkIfOwnerHasCottage(String username, Long cottageId);

	public Boolean checkIfCottageHasReservation(Long id);

	public List<Cottage> getAll();

	public Boolean checkOwnership(Long id);

	public List<CottageOption> getOptions(Long cottageId);

	public List<Cottage> getAllSorted(String type, String order);

	public List<String> getCottageLocations();

	public List<Cottage> searchCottages(SearchFilter searchFilter);
	
//	public List<Cottage> getAllByDate(Date date);
	
	public Boolean uploadImage(Long id, MultipartFile image) throws IOException;
	
	public Boolean deleteImage(Long id);
	
	public Boolean updateCottage(EditCottageDTO cottage);

}
