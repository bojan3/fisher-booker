package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.exception.InvalidTokenException;
import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Role;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.DeleteAccountRequest;
import com.example.fisherbooker.model.DTO.AccountDTO;
import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.model.DTO.AdventureDTO;
import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.CottageService;
import com.example.fisherbooker.service.FishingInstructorService;
import com.example.fisherbooker.service.RoleService;
import com.example.fisherbooker.service.ShipOwnerService;
import com.example.fisherbooker.service.impl.AccountServiceImpl;
import com.example.fisherbooker.service.impl.RoleServiceImpl;

@RestController
@RequestMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;
	private CottageOwnerService cottageownerservice;
	private FishingInstructorService fishingservice;
	private ShipOwnerService shipownerservice;
	private RoleServiceImpl roleservice;
	
	
	
	
	
	
	@PostMapping("/update")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean updateUser(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder) {
		return accountService.updateUser(accountRequest);
	}
	// Брисање налога
	@PostMapping("/delete")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean deleteUser(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder) {
		this.accountService.acceptdeleteAccountRequest(accountRequest.getId());
		return true;
	}
	

	@PostMapping("/newAdmin")
//	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')") *, UriComponentsBuilder ucBuilder
	public boolean newAdmin(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder){
			System.out.println("ulaz u kontoler:");
			System.out.println(accountRequest);		
			this.accountService.newAdmin(accountRequest);
			
		return true;
	}
	
	
	
	@GetMapping("/unverified")
	public ResponseEntity<List<AccountDTO>> getUnverifiedAccounts(){
	
		return new ResponseEntity<>(this.accountService.getAllUnverified(), HttpStatus.OK);
	}
	
	@PutMapping("/verify")
	public ResponseEntity<Boolean> AdminVerifyAccount(@RequestBody Long account_id){
		
		return new ResponseEntity<>(this.accountService.AdminVerifyUser(account_id), HttpStatus.OK);
	}
	/// Брисање захтева за прављење налога
	@DeleteMapping("/delete")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean deleteAccountByID(@RequestBody Long account_id){	
		this.accountService.deleteAccountRequest(account_id);	
		return true;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDTO>> getAccounts(){
		List<Account> accounts = this.accountService.getAll();
		System.out.println(accounts);
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		for(Account a : accounts) {
		//	AccountDTO accountDTO =AccountDTO.createAccountDTO(a);
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(a.getId());
			accountDTO.setAddress(a.getAddress());
			accountDTO.setEmail(a.getEmail());
			accountDTO.setLastName(a.getLastName());
			accountDTO.setPhoneNumber(a.getPhoneNumber());
			accountDTO.setUsername(a.getUsername());
			accountDTO.setName(a.getName());
			accountDTO.setPassword(a.getPassword());
			accountDTO.setRole(a.getRoles().toString());
			accountDTO.setEnabled(a.isEnabled());
			accountDTO.setStatus(a.getStatus());
			System.out.println(a.getStatus().toString());
			
			accountsDTO.add(accountDTO);
		}
		System.out.println(accountsDTO);
		return new ResponseEntity<>(accountsDTO, HttpStatus.OK);
	}

	@PostMapping("/deleteAccountRequest")
	public ResponseEntity<Boolean> createDeleteAccountRequest(@RequestBody DeleteAccountRequest request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (this.accountService.createDeleteAccountRequest(username, request)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}

	@GetMapping("/allDeleteRequests")
	public List<DeleteAccountRequest> getAllDeleteAccountRequests(){
		return this.accountService.deleteAccountRequests();
		
	}
	
	@DeleteMapping("/accepteddeleteAccountRequest/{deleteaccount_id}")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean acceptdeleteAccountRequest(@PathVariable Long deleteaccount_id){	
		this.accountService.acceptdeleteAccountRequest(deleteaccount_id);	
		return true;
	}
	
	@DeleteMapping("/denieddeleteAccountRequest/{deleteaccount_id}")
	//@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public boolean denydeleteAccountRequestByID(@PathVariable Long deleteaccount_id){	
		this.accountService.denydeleteAccountRequest(deleteaccount_id);	
		return true;
	}
	
}
