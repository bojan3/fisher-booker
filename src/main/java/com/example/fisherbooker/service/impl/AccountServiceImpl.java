package com.example.fisherbooker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Role;
import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.service.RoleService;

@Service
public class AccountServiceImpl {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	
	// adresa onoga ko se registruje treba da se doda
	public Account save(AccountRequest accountRequest) {
		
		Account account = new Account();
		account.setUsername(accountRequest.getUsername());
		
		account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
		
		account.setName(accountRequest.getFirstname());
		account.setLastName(accountRequest.getLastname());
		account.setPhoneNumber(accountRequest.getPhoneNumber());
		
		
		account.setEnabled(true);
		account.setEmail(accountRequest.getEmail());

		List<Role> roles = getRoles(accountRequest.getRole());
		account.setRoles(roles);
		
		return this.accountRepository.save(account);
	}
	
	public Account findByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findByUsername(username);
	}
	
	private List<Role> getRoles(String roleType) {
		
		switch(roleType) {
			case "ADMIN":
				return roleService.findAll();
			case "CLIENT":
				return roleService.findByName("ROLE_CLIENT");
			case "COTTAGE_OWNER":
				return roleService.findByName("ROLE_COTTAGE_OWNER");
			case "SHIP_OWNER":
				return roleService.findByName("ROLE_SHIP_OWNER");
			case "INSTRUCTOR":
				return roleService.findByName("ROLE_INSTRUCTOR");
		}
		
		return null;
	}
	
	public Account findById(Long id) throws AccessDeniedException {
		return accountRepository.findById(id).orElseGet(null);
	}
}
