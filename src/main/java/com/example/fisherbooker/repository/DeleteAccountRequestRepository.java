package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.DeleteAccountRequest;


@Repository
public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest, Long> {
	
}
