package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NavigationEquipment {
	
	@Id
	private String name;

	public NavigationEquipment() {
		super();
		// TODO Auto-generated constructor stub
	}

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