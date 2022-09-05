package com.example.fisherbooker.model.EmailContexts;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Review;
import com.example.fisherbooker.model.DTO.AnswerReservationReviewDTO;

public class NewPenalEmailContext extends EmailContext  {

	public <T> void init(T context) {
		// we can do any common configuration setup here
		// like setting up some base URL and context
		AnswerReservationReviewDTO arrD = (AnswerReservationReviewDTO) context; // we pass the customer informati
			
		put("client_username", arrD.getClientUsername());
		put("owner_username", arrD.getOwnerUsername());
		put("text", arrD.getContent());
		put("owner_email", arrD.getOwnerEmail());

		setTemplateLocation("penal");
		setSubject("New penal");
		setFrom("potuc3@gmail.com");
		//setTo(account.getEmail());
	}
	
}
