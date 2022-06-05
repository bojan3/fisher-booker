package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureOption;

public interface AdventureOptionsRepository extends JpaRepository<AdventureOption, Long> {

	AdventureOption deleteAllById(Long id);

}