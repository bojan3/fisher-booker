package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.CottageImage;
import com.example.fisherbooker.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

	@Query(value = "delete from image where id = :id", nativeQuery = true)
	CottageImage deleteImageById(@Param("id") Long id);
	
}
