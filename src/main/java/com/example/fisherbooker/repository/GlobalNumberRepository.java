package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.GlobalNumber;

@Repository
public interface GlobalNumberRepository extends JpaRepository<GlobalNumber, Long>{

	
	
}
