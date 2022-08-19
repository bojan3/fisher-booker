package com.example.fisherbooker.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.DTO.CreateReviewDTO;

@Entity
@DiscriminatorValue("cottage_review")
public class CottageReview extends Review{

	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;

	public CottageReview() {
	}
	
	public CottageReview(CreateReviewDTO createReviewDTO, Client client, Cottage cottage) {
		super(createReviewDTO, client);
		this.cottage = cottage;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}
	
	
	public Long  getCottageId() {
		return cottage.getId();
	}


	
	
	
}
