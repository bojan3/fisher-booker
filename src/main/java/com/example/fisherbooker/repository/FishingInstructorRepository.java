package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Long>{
	 List<FishingInstructor> findAll();

	 FishingInstructor getById(Long id);
	Optional<FishingInstructor> findOneById(Long id);

	Optional<FishingInstructor> findByAccountUsername(String username);

}


