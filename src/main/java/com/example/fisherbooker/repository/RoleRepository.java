package com.example.fisherbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fisherbooker.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByName(String name);
}
