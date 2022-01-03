package com.example.fisherbooker.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {

	Adventure deleteAllById(Long id);
	public List<Adventure> findByOrderByName();
	public List <Adventure> findByOrderByPrice();
	public List <Adventure> findByOrderByCapacityDesc();

}
