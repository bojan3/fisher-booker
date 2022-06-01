package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.FishingInstructor;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Long>{
	public List<FishingInstructor> findAll();
	public List<FishingInstructor> findByOrderByAccountName();

}
