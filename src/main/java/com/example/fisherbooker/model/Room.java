package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@Column(length = 10)
	private String label;
	private int numOfBeds;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;

	public Room() {
		super();
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

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	@Override
	public String toString() {
		return "Room [label=" + label + ", numOfBeds=" + numOfBeds + "]";
	}

}