package com.example.fisherbooker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByUsername(String username);
	Account findByEmail(String email);
}
