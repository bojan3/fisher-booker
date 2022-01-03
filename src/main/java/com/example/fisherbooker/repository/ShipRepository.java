package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long>{
	public List<Ship> findAll();
	public List<Ship> findByOrderByName();
	public List<Ship> findByOrderByAverageMarkDesc();
	public List<Ship> findByOrderByRentPrice();
	public List<Ship> findByOrderByCapacityDesc();
}
