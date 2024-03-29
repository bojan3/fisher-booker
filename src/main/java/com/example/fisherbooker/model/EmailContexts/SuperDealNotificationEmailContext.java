package com.example.fisherbooker.model.EmailContexts;

import com.example.fisherbooker.model.CottageSuperDeal;

public class SuperDealNotificationEmailContext extends EmailContext {

	@Override
	public <T> void init(T context) {
		String email = (String) context;
		setTemplateLocation("reservation");
		setSubject("NOVA PONUDA");
		setFrom("potuc3@gmail.com");
		setTo(email);
	}

	public void setCottageSuperDealInfo(CottageSuperDeal superDeal) {
		put("start", superDeal.getStartDate());
		put("end", superDeal.getEndDate());
		put("capacity", superDeal.getCapacity());
		put("price", superDeal.getDiscountedPrice());
		put("options", superDeal.getOptions());
	}

}
