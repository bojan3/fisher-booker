package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;

@Repository
public interface ShipOwnerRepository extends JpaRepository<Cottage, Long>{
	

}
