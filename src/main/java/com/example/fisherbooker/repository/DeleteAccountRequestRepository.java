package com.example.fisherbooker.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.DeleteAccountRequest;


@Repository
public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest, Long> {
	
	
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
	//@Query(value = "SELECT * FROM DELETE_ACCOUNT_REQUEST dar where dar.id = :#{#id}", nativeQuery = true)
	//DeleteAccountRequest getById(@Param ("id") Long id);
	
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
	// void delete(DeleteAccountRequest dar);
	
}
