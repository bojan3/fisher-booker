package com.example.fisherbooker.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;
import com.example.fisherbooker.model.DTO.RatingDTO;

@Repository
public interface ShipReservationRepository extends JpaRepository<ShipReservation, Long> {
	
	@Query(value = "select * \r\n"
			+ "from ship_reservation\r\n"
			+ "where ship_id = :id and end_date >= CURRENT_DATE", nativeQuery = true)
	public List<ShipReservation> isShipReserved(@Param("id") Long id);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from ship_reservation\r\n"
			+ "where ship_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getDates(@Param("id") Long id);
	
	public List<ShipReservation> findByShipShipOwnerAccountUsernameOrderByStartDateDesc(String username,
			Pageable pageable);
	
	public List<ShipReservation> findByShipShipOwnerAccountUsernameOrderByStartDateDesc(String username);
	
	@Query(value = "select *\r\n"
			+ "from ship_reservation\r\n"
			+ "where ship_id = :id and (start_date >= :startDate and start_date <= :endDate) or (end_date >= :startDate and end_date <= :endDate)", nativeQuery = true)
	public List<CottageReservation> getReservationsInPeriod(@Param("id") Long id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	
	@Query(value = "select s.name as realEstate, sum(sr.capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from ship_reservation sr, ship s, ship_owner so, account a\r\n"
			+ "where sr.ship_id = s.id and s.ship_owner_id = so.id and so.account_id = a.id and a.username = :username and date_part('year', end_date) = :year \r\n"
			+ "group by s.name, date_part('year', end_date)", nativeQuery = true)
	public List<Stats> yearlyStats(@Param("username") String username, @Param("year") int year);

	@Query(value = "select s.name as realEstate, sum(sr.capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from ship_reservation sr, ship s, ship_owner so, account a\r\n"
			+ "where sr.ship_id = s.id and s.ship_owner_id = so.id and so.account_id = a.id and a.username = :username and date_part('year', end_date) = :year and date_part('month', end_date) = :month \r\n"
			+ "group by s.name, date_part('year', end_date), date_part('month', end_date)", nativeQuery = true)
	public List<Stats> monthlyStats(@Param("username") String username, @Param("year") int year, @Param("month") int month);

	@Query(value = "select s.name as realEstate, sum(sr.capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from ship_reservation sr, ship s, ship_owner so, account a\r\n"
			+ "where sr.ship_id = s.id and s.ship_owner_id = so.id and so.account_id = a.id and a.username = :username and end_date >= :startDate and end_date <= :endDate \r\n"
			+ "group by s.name", nativeQuery = true)
	public List<Stats> arbitrarilyStats(@Param("username") String username, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	
	@Query(value = "select distinct date_part('year', end_date)\r\n"
			+ "from ship_reservation sr, ship s, ship_owner so, account a\r\n"
			+ "where sr.ship_id = s.id and s.ship_owner_id = so.id and so.account_id = a.id and a.username = :username\r\n"
			+ "group by s.name, date_part('year', end_date) order by date_part('year', end_date) desc", nativeQuery = true)
	public List<Integer> getYears(String username);
	
	@Query(value = "select s.name as name, average_mark as averageRating\r\n"
			+ "from ship s, ship_owner so, account a\r\n"
			+ "where s.ship_owner_id = so.id and so.account_id = a.id and a.username = :username", nativeQuery = true)
	public List<RatingDTO> getRatings(@Param("username") String username);
}
