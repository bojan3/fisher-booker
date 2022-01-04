package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.service.impl.AccountServiceImpl;

@RestController
@RequestMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping("/update")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean updateUser(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder){
		System.out.println("Account request");
		System.out.println(accountRequest);
		return accountService.updateUser(accountRequest);
	}
	
	@PostMapping("/delete")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean deleteUser(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder){
			//TO-DO
			
		return true;
	}
	
}
