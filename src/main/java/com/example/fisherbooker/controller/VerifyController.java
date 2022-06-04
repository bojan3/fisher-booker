package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.exception.InvalidTokenException;
import com.example.fisherbooker.service.impl.AccountServiceImpl;

@RestController
@RequestMapping(value = "/api/verify", produces = MediaType.APPLICATION_JSON_VALUE)
public class VerifyController {

	@Autowired
 	private AccountServiceImpl accountService;
	
	@PostMapping("/email")
    public ResponseEntity<Boolean> verifyEmail(@RequestBody(required = false) String securetoken){
//        if(token == null){
//            redirAttr.addFlashAttribute("tokenError", messageSource.getMessage("user.registration.verification.missing.token", null,LocaleContextHolder.getLocale()));
//            return REDIRECT_LOGIN;
//        }
//        try {
//        accountService.verifyUser(token);
//        } catch (InvalidTokenException e) {
//            redirAttr.addFlashAttribute("tokenError", messageSource.getMessage("user.registration.verification.invalid.token", null,LocaleContextHolder.getLocale()));
//            return REDIRECT_LOGIN;
//        }
    	 try {
			accountService.verifyUser(securetoken);
		} catch (InvalidTokenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        redirAttr.addFlashAttribute("verifiedAccountMsg", messageSource.getMessage("user.registration.verification.success", null,LocaleContextHolder.getLocale()));
    	return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
	
//	@RequestParam(required = false) String token, final Model model, RedirectAttributes redirAttr
	
	
}
