package com.example.fisherbooker.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {

	public void deleteById(Long id);

	public List<Cottage> findAll();

	public List<Cottage> findByOrderByName();

	public List<Cottage> findByOrderByPricePerDay();

	public List<Cottage> findByOrderByAverageMarkDesc();

	public List<Cottage> findByCottageOwnerAccountUsername(String username);

	@Query(value = "select distinct address.city from cottage, address where cottage.address_id = address.id", nativeQuery = true)
	public List<String> getCottageLocations();

	@Query(value = "select * from cottage c, availability_period ap where c.availability_period_id = ap.id and ap.start_date < ?1 and ?2 < ap.end_date", nativeQuery = true)
	public List<Cottage> getAllAvalible(Date startDate, Date endDate);

}
