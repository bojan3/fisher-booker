package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ShipSuperDeal;

@Repository
public interface ShipSuperDealRepository extends JpaRepository<ShipSuperDeal, Long> {

}
