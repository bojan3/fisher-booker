package com.example.fisherbooker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.service.RoleService;

public class AccountServiceImpl {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService role;
	
}
