package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReservation;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Long> {

	//S save(AdventureReservation adventure);

	List<AdventureReservation> findAll();

	void deleteById(Long id);

	AdventureReservation getById(Long id);

	Optional<AdventureReservation> findById(Long id);

}
