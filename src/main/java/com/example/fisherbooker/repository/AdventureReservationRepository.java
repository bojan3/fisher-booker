package com.example.fisherbooker.repository;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;
import com.example.fisherbooker.model.DTO.DatePeriodDTO;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Long> {

	//S save(AdventureReservation adventure);

	List<AdventureReservation> findAll();

	void deleteById(Long id);

	AdventureReservation getById(Long id);

	Optional<AdventureReservation> findById(Long id);

	@Query(value = "select a.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from adventure_reservation ar, adventure a, fishing_instructor fi, account ac\r\n"
			+ "where ar.cottage_id = a.id and a.fishing_instructor_id = fi.id and fi.account_id = ac.id and ac.username = :username and date_part('year', end_date) = :year \r\n"
			+ "group by a.name, date_part('year', end_date)", nativeQuery = true)
	List<Stats> yearlyStats(@Param("username") String username, @Param("year") int year);
	
	@Query(value = "select a.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from adventure_reservation ar, adventure a, fishing_instructor fi, account ac\r\n"
			+ "where ar.adventure_id = a.id and a.fishing_instructor_id = fi.id and fi.account_id = ac.id and ac.username = :username and date_part('year', end_date) = :year and date_part('month', end_date) = :month \r\n"
			+ "group by a.name, date_part('year', end_date), date_part('month', end_date)", nativeQuery = true)
	List<Stats> monthlyStats(String username, int year, int month);

	@Query(value = "select a.name as realEstate, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from adventure_reservation ar, adventure a, fishing_instructor fi, account ac\r\n"
			+ "where ar.adventure_id = a.id and a.fishing_instructor_id = fi.id and fi.account_id = ac.id and ac.username = :username and end_date >= :startDate and end_date <= :endDate \r\n"
			+ "group by a.name", nativeQuery = true)
	List<Stats> arbitrarilyStats(String username, Timestamp startDate, Timestamp endDate);

	
	@Query(value = "select distinct date_part('year', end_date)\r\n"
			+ "from adventure_reservation ar, adventure a, fishing_instructor fi, account ac\r\n"
			+ "where ar.adventure_id = a.id and a.fishing_instructor_id = fi.id and fi.account_id = ac.id and ac.username = :username\r\n"
			+ "group by a.name, date_part('year', end_date) order by date_part('year', end_date) desc", nativeQuery = true)
	List<Integer> getYears(String username);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from adventure_reservation\r\n"
			+ "where adventure_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getReservationDates(@Param("id")Long adventureId);

	@Query(value = "select *\r\n" + "from adventure_reservation\r\n"
			+ "where adventure_id = :id and start_date <= :date and end_date >= :date", nativeQuery = true)
	public AdventureReservation getReservationByDateAndAdventure(@Param("id") Long id, @Param("date") Date date);

	List<AdventureReservation> findByAdventureFishingInstructorAccountUsernameOrderByStartDateDesc(String username);

	//public List<AdventureReservation> findByAdventureFishingInstructorCottageOwnerAccountUsernameOrderByStartDateDesc(String username,
	//		Pageable pageable);

	//public List<AdventureReservation> findByCottageCottageOwnerAccountUsernameOrderByStartDateDesc(String username);

	@Query(value = "select start_date as startDate, end_date as endDate\r\n" + "from cottage_reservation\r\n"
			+ "where cottage_id = :id", nativeQuery = true)
	public List<DatePeriodDTO> getDates(@Param("id") Long id);
	
	@Query(value = "select *\r\n"
			+ "from cottage_reservation\r\n"
			+ "where cottage_id = :id and (start_date >= :startDate and start_date <= :endDate) or (end_date >= :startDate and end_date <= :endDate)", nativeQuery = true)
	public List<AdventureReservation> getReservationsInPeriod(@Param("id") Long id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
