package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.complaint.Complaint;

@Repository
public interface ComplaintRepository<T extends Complaint> extends JpaRepository<T, Long> {

	@Query(value = "SELECT * FROM COMPLAINT c WHERE c.dtype = 'CottageComplaint' AND c.answered = FALSE", 
			  nativeQuery = true)
	List<T> findAllCottageComplaints();

	@Query(value = "SELECT * FROM COMPLAINT c WHERE c.dtype = 'InstructorComplaint' AND c.answered = FALSE", 
			nativeQuery = true)
	 List<T> findAllAdventureComplaints();

	@Query(value = "SELECT * FROM COMPLAINT c WHERE c.dtype = 'ShipComplaint' AND c.answered = FALSE",
			nativeQuery = true)
	 List<T> findAllShipComplaints();

	@Query(value = "SELECT * FROM COMPLAINT c where c.id = :#{#id}", nativeQuery = true)
	Complaint FindOneByID(@Param("id") Long id);

	@Query(value = "SELECT * FROM COMPLAINT c WHERE c.answer = null", nativeQuery = true)
	List<Complaint> findAllUnanswered();
	

	@Modifying
	@Query(value = "UPDATE COMPLAINT SET answer = :#{#answer}, answered = TRUE WHERE id =:#{#id}", nativeQuery = true)
	void answer(@Param("answer") String answer, @Param("id") Long id);
	
}