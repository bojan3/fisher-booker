package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageSuperDeal;

@Repository
public interface CottageSuperDealRepository extends JpaRepository<CottageSuperDeal, Long> {

}
