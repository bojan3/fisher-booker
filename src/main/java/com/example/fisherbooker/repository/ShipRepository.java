package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
	public List<Ship> findAll();

	public void deleteById(Long id);

	public List<Ship> findByOrderByName();

	public List<Ship> findByOrderByAverageMarkDesc();

	public List<Ship> findByOrderByRentPrice();

	public List<Ship> findByOrderByCapacityDesc();

	public List<Ship> findByShipOwnerAccountUsername(String username);

}
