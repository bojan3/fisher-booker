package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.Ship;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {

	public void deleteById(Long id);
	
	public List<Cottage> findAll();

	public List<Cottage> findByOrderByName();

	public List<Cottage> findByOrderByPricePerDay();

	public List<Cottage> findByOrderByAverageMarkDesc();

	public List<Cottage> findByCottageOwnerAccountUsername(String username);
}
