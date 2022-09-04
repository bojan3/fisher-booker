package com.example.fisherbooker.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

@Repository
public interface CottageReservationRepository
		extends JpaRepository<CottageReservation, Long>, PagingAndSortingRepository<CottageReservation, Long> {
	
	@Query(value = "select * \r\n"
			+ "from cottage_reservation\r\n"
			+ "where cottage_id = :id and end_date >= CURRENT_DATE", nativeQuery = true)
	public List<CottageReservation> isCottageReserved(@Param("id") Long id);

	@Query(value = "select c.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username and date_part('year', end_date) = :year \r\n"
			+ "group by c.name, date_part('year', end_date)", nativeQuery = true)
	public List<Stats> yearlyStats(@Param("username") String username, @Param("year") int year);
	
	@Query(value = "select c.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username and date_part('year', end_date) = :year and date_part('month', end_date) = :month \r\n"
			+ "group by c.name, date_part('year', end_date), date_part('month', end_date)", nativeQuery = true)
	public List<Stats> monthlyStats(@Param("username") String username, @Param("year") int year, @Param("month") int month);
	
	@Query(value = "select c.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username and end_date >= :startDate and end_date <= :endDate \r\n"
			+ "group by c.name", nativeQuery = true)
	public List<Stats> arbitrarilyStats(@Param("username") String username, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	@Query(value = "select distinct date_part('year', end_date)\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username\r\n"
			+ "group by c.name, date_part('year', end_date) order by date_part('year', end_date) desc", nativeQuery = true)
	public List<Integer> getYears(String username);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from cottage_reservation\r\n"
			+ "where cottage_id = 1", nativeQuery = true)
	public List<DatePeriodDTO> getReservationDates(Long cottageId);

	@Query(value = "select *\r\n" + "from cottage_reservation\r\n"
			+ "where cottage_id = :id and start_date <= :date and end_date >= :date", nativeQuery = true)
	public CottageReservation getReservationByDateAndCottage(@Param("id") Long id, @Param("date") Date date);

	public List<CottageReservation> findByCottageCottageOwnerAccountUsernameOrderByStartDateDesc(String username,
			Pageable pageable);

	public List<CottageReservation> findByCottageCottageOwnerAccountUsernameOrderByStartDateDesc(String username);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from cottage_reservation\r\n"
			+ "where cottage_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getDates(@Param("id") Long id);
	
	@Query(value = "select *\r\n"
			+ "from cottage_reservation\r\n"
			+ "where cottage_id = :id and (start_date >= :startDate and start_date <= :endDate) or (end_date >= :startDate and end_date <= :endDate)", nativeQuery = true)
	public List<CottageReservation> getReservationsInPeriod(@Param("id") Long id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
