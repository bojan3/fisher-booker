package com.example.fisherbooker.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import com.example.fisherbooker.model.Admin;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.DeleteAccountRequest;
import com.example.fisherbooker.model.Role;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.DTO.AccountDTO;
import com.example.fisherbooker.model.DTO.AccountRequest;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.AdministratorRepository;
import com.example.fisherbooker.repository.CottageOwnerRepository;
import com.example.fisherbooker.repository.FishingInstructorRepository;
import com.example.fisherbooker.repository.DeleteAccountRequestRepository;
import com.example.fisherbooker.repository.SecureTokenRepository;
import com.example.fisherbooker.repository.ShipOwnerRepository;
import com.example.fisherbooker.security.auth.SecureToken;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.RoleService;
import com.example.fisherbooker.service.SecureTokenService;

@Service
@Transactional
public class AccountServiceImpl {

	@Autowired
	private CottageOwnerRepository coRep;

	@Autowired
	private ShipOwnerRepository soRep;

	@Autowired
	private FishingInstructorRepository fiRep;

	@Autowired
	private AdministratorRepository adminrepo;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleService roleService;

	@Autowired
	private SecureTokenService secureTokenService;
	// sad dal treba naglasiti koji implementira ili ce sam da skonta

	@Autowired
	private SecureTokenRepository secureTokenRepository;

	@Autowired
	private DeleteAccountRequestRepository deleteAccountRequestRepository;

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
		account.setAdminVerified(false);

		if (accountRequest.getRole().equals("CLIENT"))
			account.setAdminVerified(true);

		List<Role> roles = getRoles(accountRequest.getRole());
		account.setRoles(roles);

		Account savedAccount = this.accountRepository.save(account);

		sendRegistrationConfirmationEmail(savedAccount);

		return savedAccount;
	}

	public void sendRegistrationConfirmationEmail(Account account) {
		SecureToken secureToken = secureTokenService.createSecureToken();
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

	public Boolean createDeleteAccountRequest(String username, DeleteAccountRequest request) {
		Account account = this.accountRepository.findByUsername(username);
		request.setAccount(account);
		this.deleteAccountRequestRepository.save(request);
		return true;
	}

	public List<DeleteAccountRequest> deleteAccountRequests() {

		return this.deleteAccountRequestRepository.findAll();
	}

	private List<Role> getRoles(String roleType) {

		switch (roleType) {
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

	public List<AccountDTO> getAllUnverified() {

		List<Account> accounts = this.getAll();
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		for (Account a : accounts) {
			if (!a.isAdminVerified()) {
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(a.getId());
				accountDTO.setAddress(a.getAddress());
				accountDTO.setEmail(a.getEmail());
				accountDTO.setLastName(a.getLastName());
				accountDTO.setPhoneNumber(a.getPhoneNumber());
				accountDTO.setUsername(a.getUsername());
				accountDTO.setName(a.getName());
				accountDTO.setPassword(a.getPassword());
				accountDTO.setRole(a.getRoles().get(0).getName().toString());
				accountDTO.setEnabled(a.isEnabled());

				accountsDTO.add(accountDTO);
			}
		}

		return accountsDTO;

	}

	public boolean AdminVerifyUser(Long account_id) {

		Account account = accountRepository.findById(account_id).get();

		// List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		if (account.isAdminVerified() == false) {

			System.out.println(account + "/n");

			System.out.println(account.getRoles() + "/n");

			if (account.getRoles().get(0).getName().equals(("ROLE_COTTAGE_OWNER"))) {
				account.setAdminVerified(true);
				CottageOwner cottageowner = new CottageOwner();
				cottageowner.setAccount(account);
				this.accountRepository.save(account);
				coRep.save(cottageowner);
				return true;
			}

			if (account.getRoles().get(0).getName().equals("ROLE_SHIP_OWNER")) {
				account.setAdminVerified(true);
				ShipOwner shipowner = new ShipOwner();
				shipowner.setAccount(account);
				this.accountRepository.save(account);
				soRep.save(shipowner);
				return true;
			}

			if (account.getRoles().get(0).getName().equals("ROLE_INSTRUCTOR")) {
				account.setAdminVerified(true);
				FishingInstructor fishinginstructor = new FishingInstructor();
				fishinginstructor.setAccount(account);
				this.accountRepository.save(account);
				fiRep.save(fishinginstructor);
				return true;
			}
		}

		return false;
	}

	public void acceptdeleteAccountRequest(Long id) {
		System.out.println(id);
		DeleteAccountRequest dcc = this.deleteAccountRequestRepository.getById(id);
		System.out.println(dcc);
		Account acc = dcc.getAccount();
		System.out.println(acc.getRoles().get(0).toString());

		System.out.println(acc);
		dcc.setAccount(null);
		System.out.println(dcc);
		System.out.println(1);
		switch (acc.getRoles().get(0).getName().toString()) {
		case "ROLE_INSTRUCTOR":
			FishingInstructor fi = this.fiRep.findByAccountUsername(acc.getUsername()).get();
			System.out.println(fi);
			this.fiRep.delete(fi);
			break;

		case "ROLE_SHIP_OWNER":
			ShipOwner sho = this.soRep.findOneByAccountUsername(acc.getUsername()).get();
			System.out.println(sho);
			this.soRep.delete(sho);
			break;

		case "ROLE_COTTAGE_OWNER":
			CottageOwner co = this.coRep.findOneByAccountUsername(acc.getUsername()).get();
			System.out.println(co);
			this.coRep.delete(co);
			break;

		default:
			break;
		}
		// brisanje u zavisnosti od uloge
		// acc.setAddress(null);
		// accountRepository.save(acc);

		// accountRepository.deleteById(id);

		this.deleteAccountRequestRepository.save(dcc);
		this.deleteAccountRequestRepository.delete(dcc);
		System.out.println("return");
	}

	public void denydeleteAccountRequest(Long id) {
		DeleteAccountRequest dcc = this.deleteAccountRequestRepository.getById(id);
		this.deleteAccountRequestRepository.delete(dcc);
	}

	public void deleteAccountRequest(Long id) {
		Account account = this.accountRepository.getById(id);
		account.setAddress(null);
		accountRepository.save(account);
		this.accountRepository.deleteById(id);
	}

	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		System.out.println("Token iz baze: " + secureToken);
		System.out.println("Token sa fronta: " + token);

		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}

		Account account = secureToken.getAccount();
		account.setEmailVerified(true);
		accountRepository.save(account);

		secureTokenService.removeToken(secureToken);
		return true;
	}

	public List<Account> getAll() {
		return this.accountRepository.findAll();
	}

	public Account newAdmin(AccountRequest accountRequest) {
		System.out.println("улаз у сервис:");
		Account account = new Account();
		account.setUsername(accountRequest.getUsername());
		account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
		account.setName(accountRequest.getLastName());
		account.setLastName(accountRequest.getLastName());
		account.setPhoneNumber(accountRequest.getPhoneNumber());
		account.setEnabled(true);
		account.setEmail(accountRequest.getEmail());
		account.setAddress(accountRequest.getAddress());
		account.setAdminVerified(true);
		account.setEmailVerified(true);

		// SA FRONTA CU POSLATI ADMIN ROLE
		List<Role> roles = new ArrayList<Role>();
		Role role = this.roleService.findById((long) (2));
		System.out.println("uloga:");
		System.out.println(role);
		// Set<Role> rolex = new HashSet<Role>();
		roles.add(role);
		account.setRoles(roles);
		Account savedAccount = this.accountRepository.save(account);
		Admin noviAdmin = new Admin();
		noviAdmin.setAccount(savedAccount);
		adminrepo.save(noviAdmin);
		return savedAccount;
	}

}
