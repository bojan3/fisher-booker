package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fisherbooker.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
