package com.example.fisherbooker.model.EmailContexts;

import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.model.Account;

public class AccountVerificationEmailContext extends EmailContext {

	private String token;

	@Override
	public <T> void init(T context) {
		// we can do any common configuration setup here
		// like setting up some base URL and context
		Account account = (Account) context; // we pass the customer informati
		put("firstName", account.getName());
		setTemplateLocation("email-verification");
		setSubject("Complete your registration");
		setFrom("isa.projekat333@gmail.com");
		setTo(account.getEmail());
	}

	public void setToken(String token) {
		this.token = token;
		put("token", token);
	}

	public void buildVerificationUrl(final String baseURL, final String token) {
//        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
//                .path("/register/verify").queryParam("token", token).toUriString();
//        put("verificationURL", url);

		final String url = UriComponentsBuilder.fromHttpUrl(baseURL).path("/register/verify/").path(token)
				.toUriString();
		put("verificationURL", url);

	}
}