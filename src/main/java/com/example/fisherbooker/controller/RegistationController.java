package com.example.fisherbooker.controller;

import java.security.Principal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.exception.InvalidTokenException;
import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.DTO.AccountDTO;
import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.FishingInstructorService;
import com.example.fisherbooker.service.ShipOwnerService;
import com.example.fisherbooker.service.impl.AccountServiceImpl;


@RestController
@RequestMapping(value = "/api/registration", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistationController {
	
	private static final String REDIRECT_LOGIN= "redirect:/login";
	
	private CottageOwnerService cottageOwnerService;
	private ShipOwnerService shipOwnerService;
 	private FishingInstructorService instructorService;
 	
 	@Autowired
 	private MessageSource messageSource;
 	
 	@Autowired
 	private AccountServiceImpl accountService;
 	
 	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Account loadById(@PathVariable Long accountId) {
		return this.accountService.findById(accountId);
	}
 	
	@GetMapping("/whoami")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
	public AccountDTO account(Principal account) {
		return AccountDTO.createAccountDTO(accountService.findByUsername(account.getName()));
	}


}
