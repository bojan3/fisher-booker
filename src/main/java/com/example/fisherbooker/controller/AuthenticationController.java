package com.example.fisherbooker.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.exception.ResourceConflictException;
import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.model.DTO.JwtAuthenticationRequest;
import com.example.fisherbooker.model.DTO.UserTokenState;
import com.example.fisherbooker.service.impl.AccountServiceImpl;
import com.example.fisherbooker.util.TokenUtils;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		// Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
		// kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		Account account = (Account) authentication.getPrincipal();
		System.out.println(account);
		String jwt = tokenUtils.generateToken(account.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<Account> addUser(@RequestBody AccountRequest accountRequest, UriComponentsBuilder ucBuilder) {
		//System.out.println(accountRequest.getRole());
		Account existAccount = this.accountService.findByUsername(accountRequest.getUsername());

		if (existAccount != null) {
			throw new ResourceConflictException(accountRequest.getId(), "Username already exists");
		}

		Account account = this.accountService.save(accountRequest);

		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}
}
