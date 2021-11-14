package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@Column(length=10)
	private String label;
	private int numOfBeds;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String label, int numOfBeds) {
		super();
		this.label = label;
		this.numOfBeds = numOfBeds;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getNumOfBeds() {
		return numOfBeds;
	}

	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	@Override
	public String toString() {
		return "Room [label=" + label + ", numOfBeds=" + numOfBeds + "]";
	}
	
}