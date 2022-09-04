package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("COTTAGE")
public class CottageImage extends Image {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;

	public CottageImage() {
		super();
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

}
