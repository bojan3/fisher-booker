package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.ShipReservationSupportData;
import com.example.fisherbooker.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
