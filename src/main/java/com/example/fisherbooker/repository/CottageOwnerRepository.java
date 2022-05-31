package com.example.fisherbooker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import java.util.List;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Long>{
	
	public Optional<CottageOwner> findOneByAccountUsername(String username);
	
	 List<CottageOwner> findAll();

}
