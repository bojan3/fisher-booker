package com.example.fisherbooker.model;

public class SuperDealNotificationEmailContext extends EmailContext {

	@Override
	public <T> void init(T context) {
		String email = (String) context;
		setTemplateLocation("new-super-deal");
		setSubject("NOVA PONUDA");
		setFrom("isa.projekat333@gmail.com");
		setTo(email);
	}

	public void setSuperDealInfo(CottageSuperDeal superDeal) {
		put("start", superDeal.getStartDate());
		put("end", superDeal.getEndDate());
		put("capacity", superDeal.getCapacity());
		put("price", superDeal.getDiscountedPrice());
		put("options", superDeal.getOptions());
	}
}
