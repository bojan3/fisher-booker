package com.example.fisherbooker.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
	public List<Ship> findAll();
	
	public Optional<Ship> findById(Long id);

	public void deleteById(Long id);

	public List<Ship> findByOrderByName();

	public List<Ship> findByOrderByAverageMarkDesc();

	public List<Ship> findByOrderByRentPrice();

	public List<Ship> findByOrderByCapacityDesc();

	public List<Ship> findByShipOwnerAccountUsername(String username);

	@Query(value = "select distinct address.city from ship, address where ship.address_id = address.id", nativeQuery = true)
	public List<String> getCottageLocations();

	@Query(value = "select * from ship s, availability_period ap where s.availability_period_id = ap.id and ap.start_date < ?1 and ?2 < ap.end_date", nativeQuery = true)
	public List<Ship> getAllAvalible(Date startDate, Date endDate);

}
