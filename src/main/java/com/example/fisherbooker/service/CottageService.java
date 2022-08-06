package com.example.fisherbooker.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.example.fisherbooker.repository.CottageRepository;

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

	public List<Cottage> getAllSorted(String type, String order);

//	public List<Cottage> getAllByDate(Date date);

}
