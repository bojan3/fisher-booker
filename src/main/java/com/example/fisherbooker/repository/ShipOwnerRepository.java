package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ShipOwner;

@Repository
public interface ShipOwnerRepository extends JpaRepository<ShipOwner, Long>{
	

	 List<ShipOwner> findAll();
	
	 Optional<ShipOwner> findOneByAccountUsername(String username);
}
