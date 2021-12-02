package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Role;

public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
	List<Role> findAll();
}
