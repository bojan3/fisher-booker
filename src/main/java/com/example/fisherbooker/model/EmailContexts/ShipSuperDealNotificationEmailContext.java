package com.example.fisherbooker.model.EmailContexts;

import com.example.fisherbooker.model.ShipSuperDeal;

public class ShipSuperDealNotificationEmailContext extends EmailContext {

	@Override
	public <T> void init(T context) {
		String email = (String) context;
		setTemplateLocation("new-ship-super-deal");
		setSubject("NOVA PONUDA");
		setFrom("potuc3@gmail.com");
		setTo(email);
	}

	public void setShipSuperDealInfo(ShipSuperDeal superDeal) {
		put("start", superDeal.getStartDate());
		put("end", superDeal.getEndDate());
		put("capacity", superDeal.getCapacity());
		put("price", superDeal.getDiscountedPrice());
		put("options", superDeal.getOptions());
	}
}
