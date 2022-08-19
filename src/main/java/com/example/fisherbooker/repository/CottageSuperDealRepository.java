package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageSuperDeal;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

@Repository
public interface CottageSuperDealRepository extends JpaRepository<CottageSuperDeal, Long> {
	
	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from cottage_super_deal\r\n"
			+ "where cottage_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getDates(@Param("id") Long id);
	
}
