package com.example.fisherbooker.service.impl;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.exception.InvalidTokenException;
import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.AccountVerificationEmailContext;
import com.example.fisherbooker.model.Role;
import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.SecureTokenRepository;
import com.example.fisherbooker.security.auth.SecureToken;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.RoleService;
import com.example.fisherbooker.service.SecureTokenService;

@Service
@Transactional
public class AccountServiceImpl {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SecureTokenService secureTokenService;
	//sad dal treba naglasiti koji implementira ili ce sam da skonta
	
	@Autowired 
	private SecureTokenRepository secureTokenRepository;
	
	@Value("${site.base.url.https}")
	private String baseURL;
	
	@Autowired
	private EmailService emailService;
	
	// adresa onoga ko se registruje treba da se doda
	public Account save(AccountRequest accountRequest) {
		
		Account account = new Account();
		account.setUsername(accountRequest.getUsername());
		account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
		account.setName(accountRequest.getName());
		account.setLastName(accountRequest.getLastName());
		account.setPhoneNumber(accountRequest.getPhoneNumber());
		account.setEnabled(false);
		account.setEmail(accountRequest.getEmail());
		account.setAddress(accountRequest.getAddress());
		
		if(accountRequest.getRole().equals("CLIENT"))
			account.setAdminVerified(true);
		
		List<Role> roles = getRoles(accountRequest.getRole());
		account.setRoles(roles);
		
		Account savedAccount = this.accountRepository.save(account);	
		
		sendRegistrationConfirmationEmail(savedAccount);
		
		return savedAccount;
	}
	
    public void sendRegistrationConfirmationEmail(Account account) {
        SecureToken secureToken= secureTokenService.createSecureToken();
        secureToken.setAccount(account);
        secureTokenRepository.save(secureToken);
        
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        emailContext.init(account);
        emailContext.setToken(secureToken.getToken());
        emailContext.buildVerificationUrl("http://localhost:4200", secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
	
	public boolean updateUser(AccountRequest account) {
		Account oldAccount = accountRepository.getOne(account.getId());
//		System.out.println("Stari akaunt: " + oldAccount);
		oldAccount.setUsername(account.getUsername());
		oldAccount.setPassword(account.getPassword());
		oldAccount.setName(account.getName());
		oldAccount.setPhoneNumber(account.getPhoneNumber());
		oldAccount.setAddress(oldAccount.getAddress());
		System.out.println("Updated account:");
//		System.out.println(oldAccount);
		accountRepository.save(oldAccount);
		return true;
	}

	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		System.out.println("Token iz baze: " + secureToken);
		System.out.println("Token sa fronta: " + token);
		
        if(Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired()){
            throw new InvalidTokenException("Token is not valid");
        }
        
        Account account = secureToken.getAccount();
        account.setEmailVerified(true);
        accountRepository.save(account);

        secureTokenService.removeToken(secureToken);
        return true;
	}
	
}
