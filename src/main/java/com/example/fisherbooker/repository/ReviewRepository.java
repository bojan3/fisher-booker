package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long > {

	public List<Review> findByOrderByGrade();
}
