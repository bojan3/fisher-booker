package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

 @Entity
@DiscriminatorValue("ADVENTURE")
 public class AdventureImage extends Image {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "adventure_id")
	private Adventure adventure;

	public AdventureImage() {
		super();
	}

	public Adventure getAdventuree() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

}
