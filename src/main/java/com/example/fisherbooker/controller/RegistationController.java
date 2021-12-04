package com.example.fisherbooker.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.FishingInstructorService;
import com.example.fisherbooker.service.RegistrationRequestService;
import com.example.fisherbooker.service.ShipOwnerService;
import com.example.fisherbooker.service.impl.AccountServiceImpl;

@RestController
@RequestMapping(value = "/api/registration", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistationController {
	private CottageOwnerService cottageOwnerService;
	private ShipOwnerService shipOwnerService;
 	private FishingInstructorService instructorService;
 	
 	@Autowired
 	private AccountServiceImpl accountService;
 	
 	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Account loadById(@PathVariable Long accountId) {
		return this.accountService.findById(accountId);
	}
 	
	@GetMapping("/whoami")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public Account account(Principal account) {
		return this.accountService.findByUsername(account.getName());
	}

	
}
