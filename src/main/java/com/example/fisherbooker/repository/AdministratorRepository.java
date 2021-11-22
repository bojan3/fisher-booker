package com.example.fisherbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Admin;

@Repository
public interface AdministratorRepository extends JpaRepository<Admin, Long> {

}
