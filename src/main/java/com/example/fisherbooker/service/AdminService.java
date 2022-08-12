package com.example.fisherbooker.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

	
	public static Float GLOBAL_INCOME_PRECETAGE = (float) 0.1;

	public static Float TOTAL_INCOME = (float) 0;
	
	public static Float getGLOBAL_INCOME_PRECETAGE() {
		return GLOBAL_INCOME_PRECETAGE;
	}

	public static void setGLOBAL_INCOME_PRECETAGE(Float gLOBAL_INCOME_PRECETAGE) {
		GLOBAL_INCOME_PRECETAGE = gLOBAL_INCOME_PRECETAGE;
	}
		
}
