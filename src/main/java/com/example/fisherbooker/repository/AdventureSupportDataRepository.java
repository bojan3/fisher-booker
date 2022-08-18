package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.AdventureReservationSupportData;

public interface AdventureSupportDataRepository extends JpaRepository<AdventureReservationSupportData, Long> {

}
