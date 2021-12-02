package com.example.fisherbooker.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long>{
	
	public List<Cottage> findAll();
}
