package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NavigationEquipment {
	
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NavigationEquipment [name=" + name + "]";
	}
	
}