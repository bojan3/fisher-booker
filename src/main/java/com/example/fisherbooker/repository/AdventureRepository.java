package com.example.fisherbooker.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {

	Adventure deleteAllById(Long id);

	
	
	Adventure getById(Long id);
	
	Optional<Adventure> findOneById(Long id);
	
//	Boolean update(Adventure adventure);
	
	Adventure save(Adventure adventure);


	List<Adventure> findByOrderByName();


	List<Adventure> findByOrderByPrice();
	
	public List<Adventure> findByFishingInstructorAccountUsername(String username);

	

	public List<Adventure> findByOrderByName();
	public List <Adventure> findByOrderByPrice();
	public List <Adventure> findByOrderByCapacityDesc();


}
