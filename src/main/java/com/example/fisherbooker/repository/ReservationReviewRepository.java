package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.AdventureReservation;
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
	
	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'COTTAGE' and r.cottage_reservation_id = :#{#reservation_id} ", 
			nativeQuery = true)
	T findOneCottageReservationReview(@Param("reservation_id") Long reservation_id);
	
	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'ADVENTURE' and r.adventure_reservation_id = :#{#reservation_id} ", 
			nativeQuery = true)
	T findOneAdventureReservationReview(@Param("reservation_id") Long reservation_id);
	
	@Query(value = "SELECT * FROM RESERVATION_REVIEWS r WHERE r.image_type = 'SHIP' and r.ship_id = :#{#reservation_id} ", 
			nativeQuery = true)
	T findOneShipReservationReview(@Param("reservation_id") Long reservation_id);

//	void save(T reservationReview);
	

	
	
}
