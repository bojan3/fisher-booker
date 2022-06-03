package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.FishingInstructor;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public List<Client> findAll();
	
	@Query("FROM Client WHERE account_id = ?1")
	public Client findByAccountId(Long accountId);
	
}
