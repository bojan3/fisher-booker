package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
