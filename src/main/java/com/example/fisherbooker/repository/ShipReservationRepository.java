package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ShipReservation;

@Repository
public interface ShipReservationRepository extends JpaRepository<ShipReservation, Long> {
	public List<ShipReservation> findByShipId(Long id);
}
