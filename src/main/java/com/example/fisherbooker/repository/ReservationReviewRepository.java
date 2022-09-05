package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.Review;

@Repository
public interface ReservationReviewRepository<T extends ReservationReview> extends JpaRepository<T, Long> {
	
	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'COTTAGE'", nativeQuery = true)
	List<T> findAllCottages();

	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'ADVENTURE'", nativeQuery = true)
	 List<T> findAllAdventures();

	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'SHIP'", nativeQuery = true)
	 List<T> findAllShips();

	@Query(value = "SELECT * FROM REVIEW r where r.id = :#{#id}", nativeQuery = true)
	Review findReviewByReviewID(@Param("id") Long id);
	
	
	
	
	
}
