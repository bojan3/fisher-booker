package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageOption;

@Repository
public interface CottageOptionRepository extends JpaRepository<CottageOption, Long> {
	public List<CottageOption> findByCottageId(Long id);
}
