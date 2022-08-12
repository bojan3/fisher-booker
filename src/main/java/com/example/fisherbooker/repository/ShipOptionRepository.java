package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ShipOption;

@Repository
public interface ShipOptionRepository extends JpaRepository<ShipOption, Long> {
	public List<ShipOption> findByShipId(Long id);
}
