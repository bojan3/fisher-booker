package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.AdventureReview;
import com.example.fisherbooker.model.CottageReview;
import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.ShipReview;

@Repository
public interface ReviewRepository<T extends Review> extends JpaRepository<T, Long> {

	@Query(value = "SELECT * FROM REVIEW r WHERE r.review_type = 'cottage_review'", 
			  nativeQuery = true)
	List<T> findAllCottages();

	@Query(value = "SELECT * FROM review r WHERE r.review_type = 'adventure_review'", nativeQuery = true)
	 List<T> findAllAdventures();

	@Query(value = "SELECT * FROM review r WHERE r.review_type = 'ship_review'", nativeQuery = true)
	 List<T> findAllShips();

	@Query(value = "SELECT * FROM REVIEW r where r.id = :#{#id}", nativeQuery = true)
	Review findReviewByReviewID(@Param("id") Long id);

	@Query(value = "SELECT * FROM REVIEW r WHERE r.review_type = 'cottage_review' AND COTTAGE_ID = :#{#cottageId}", 
			  nativeQuery = true)
	List<CottageReview> findAllCottagesByCottageId(@Param("cottageId") Long cottageId);
	
	@Query(value = "SELECT * FROM REVIEW r WHERE r.review_type = 'ship_review' AND SHIP_ID = :shipId", 
			  nativeQuery = true)
	List<ShipReview> findAllShipsByShipId(@Param("shipId") Long shipId);
	
	@Query(value = "SELECT * FROM REVIEW r WHERE r.review_type = 'adventure_review' AND ADVENTURE_ID = :adventureId", 
			  nativeQuery = true)
	List<ShipReview> findAllAdvByAdvId(@Param("adventureId") Long adventureId);
}
