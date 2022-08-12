package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Long> {
	public List<FishingInstructor> findAll();

	public List<FishingInstructor> findByOrderByAccountName();

	FishingInstructor getById(Long id);

	Optional<FishingInstructor> findOneById(Long id);

	Optional<FishingInstructor> findByAccountUsername(String username);

	@Query(value = "select * from fishing_instructor where id = (select instructor_id from adventure where id = ?1)", nativeQuery = true)
	public FishingInstructor getByAdventureId(Long adventureId);
}
