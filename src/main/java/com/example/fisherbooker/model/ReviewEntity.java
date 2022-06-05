package com.example.fisherbooker.model;

public enum ReviewEntity {

	INSTRUCTOR("INSTRUCTOR"),
	SHIP("SHIP"),
	COTTAGE("COTTAGE"),
	SHIPOWNER("SHIPOWNER"),
	COTTAGEOWNER("COTTAGEOWNER")
	;

	private final String name;
	
	ReviewEntity(String string) {
			this.name = string;
			}
	
	
}
