package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GlobalNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private Float valuex;
	
	public GlobalNumber() {
		super();
	}

	
	public GlobalNumber(String name, Float valuex) {
		super();
		this.name = name;
		this.valuex = valuex;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValuex() {
		return valuex;
	}

	public void setValuex(Float valuex) {
		this.valuex = valuex;
	}


	@Override
	public String toString() {
		return "GlobalNumber [id=" + id + ", name=" + name + ", valuex=" + valuex + "]";
	}
		
}
