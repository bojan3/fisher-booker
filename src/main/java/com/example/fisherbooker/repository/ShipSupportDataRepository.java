package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.ShipReservationSupportData;

public interface ShipSupportDataRepository extends JpaRepository<ShipReservationSupportData, Long> {

}
