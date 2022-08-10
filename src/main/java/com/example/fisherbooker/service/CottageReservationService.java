package com.example.fisherbooker.service;

import java.util.List;

import com.example.fisherbooker.model.Stats;

public interface CottageReservationService {
	public List<Stats> getYearlyStats(String username, int year);
}
