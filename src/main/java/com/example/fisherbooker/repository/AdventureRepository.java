package com.example.fisherbooker.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.DTO.AdventureDTO;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {

	Adventure deleteAllById(Long id);
	public List<Adventure> findByOrderByName();
	public List<Adventure> findByOrderByPrice();
	public List<Adventure> findByOrderByCapacityDesc();
	
	@Query("FROM Adventure WHERE account = ?1")
	public List<Adventure> findByInstructor(Long accountId);
	
	@Query("FROM Adventure WHERE account = ?1 ORDER BY name")
	public List<Adventure> findByInstructorOrderByName(Long accountId);
	
	@Query("FROM Adventure WHERE account = ?1 ORDER BY price")
	public List<Adventure> findByInstructorOrderByPrice(Long accountId);
	
	@Query("FROM Adventure WHERE account = ?1 ORDER BY capacity")
	public List<Adventure> findByInstructorOrderByCapacity(Long accountId);
}
