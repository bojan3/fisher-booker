package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ShipOwner;

@Repository
public interface ShipOwnerRepository extends JpaRepository<ShipOwner, Long>{
	public List<ShipOwner> findAll();
	public Optional<ShipOwner> findOneByAccountUsername(String username);
}
