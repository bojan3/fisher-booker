package com.example.fisherbooker.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {

	public void deleteById(Long id);

	public List<Cottage> findAll();

	public List<Cottage> findByOrderByName();

	public List<Cottage> findByOrderByPricePerDay();

	public List<Cottage> findByOrderByAverageMarkDesc();

	public List<Cottage> findByCottageOwnerAccountUsername(String username);

}
