package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.Stats;

@Repository
public interface CottageReservationRepository extends JpaRepository<CottageReservation, Long> {
	public List<CottageReservation> findByCottageId(Long id);
	
	@Query(value = "select c.name as cottageName, sum(capacity) as numOfPeople, sum(price) as income\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username and date_part('year', end_date) = :year \r\n"
			+ "group by c.name, date_part('year', end_date)", nativeQuery = true)
	public List<Stats> yearlyStats(@Param("username") String username, @Param("year") int year);

	@Query(value = "select distinct date_part('year', end_date)\r\n"
			+ "from cottage_reservation cr, cottage c, cottage_owner co, account a\r\n"
			+ "where cr.cottage_id = c.id and c.cottage_owner_id = co.id and co.account_id = a.id and a.username = :username\r\n"
			+ "group by c.name, date_part('year', end_date) order by date_part('year', end_date) desc", nativeQuery = true)
	public List<Integer> getYears(String username);
}
