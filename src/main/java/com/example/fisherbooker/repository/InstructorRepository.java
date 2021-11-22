package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;

@Repository
public interface InstructorRepository extends JpaRepository<Cottage, Long>{
	
}