package com.example.fisherbooker.model.EmailContexts;

import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Review;

public class NewReviewEmailContext extends EmailContext {
	private String token;

	
	public <T> void init(T context, T rw) {
		// we can do any common configuration setup here
		// like setting up some base URL and context
		Account account = (Account) context; // we pass the customer informati
		
		Review review = (Review) rw;
		
		put("firstName", account.getName());
		put("grade", review.getGrade());
		put("comment", review.getComment());
		put("client_name", review.getClient().getAccount().getName());
		put("client_lname", review.getClient().getAccount().getLastName());

		setTemplateLocation("new-review");
		setSubject("New review");
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
