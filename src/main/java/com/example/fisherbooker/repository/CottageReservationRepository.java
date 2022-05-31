package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.CottageReservation;

public interface CottageReservationRepository extends JpaRepository<CottageReservation, Long> {
	public List<CottageReservation> findByCottageId(Long id);
}
