package com.example.fisherbooker.model.EmailContexts;

import java.util.Date;

import com.example.fisherbooker.model.CottageSuperDeal;

public class ReservationMail extends EmailContext {
	
	@Override
	public <T> void init(T context) {
		String email = (String) context;
		setTemplateLocation("reservation");
		setSubject("Rezervacija uspela!");
		setFrom("potuc3@gmail.com");
		setTo(email);
	}

	public void setReservationInfo(String name) {
		put("name", name);
	}
	
}
