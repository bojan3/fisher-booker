package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Role;
import com.example.fisherbooker.repository.RoleRepository;
import com.example.fisherbooker.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findById(Long id) {
		Role auth = this.roleRepository.getOne(id);
	    return auth;
	  }
	  
	@Override
	  public List<Role> findByName(String name) {
		List<Role> roles = this.roleRepository.findByName(name);
	    return roles;
	  }
	@Override
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
}
