package com.example.fisherbooker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.repository.AccountRepository;

@Service
public class CustomAccountDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Account account = accountRepository.findByUsername(username);
//		if (username == null) {
//			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//		} else {
//			return account;
//		}

		final Account account = accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
		boolean enabled = !account.isEnabled();
		// dodato kako spring sekjuriti ={) ne bi dopusatao neverifikovanim korisnicima odredjene zahteve
		UserDetails user = User.withUsername(username).password(account.getPassword()).disabled(enabled).authorities("USER").build();
		return account;
	}
	
	
}
