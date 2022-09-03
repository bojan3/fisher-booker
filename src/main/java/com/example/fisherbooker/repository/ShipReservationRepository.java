package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

@Repository
public interface ShipReservationRepository extends JpaRepository<ShipReservation, Long> {
	public List<ShipReservation> findByShipId(Long id);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from ship_reservation\r\n"
			+ "where ship_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getDates(@Param("id") Long id);
	
	public List<ShipReservation> findByShipShipOwnerAccountUsernameOrderByStartDateDesc(String username,
			Pageable pageable);
	
	public List<ShipReservation> findByShipShipOwnerAccountUsernameOrderByStartDateDesc(String username);

}
