package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.event.CaretListener;

import com.example.fisherbooker.model.DTO.CreateReviewDTO;

@Entity
@DiscriminatorValue("adventure_review")
public class AdventureReview extends Review{
	
	@ManyToOne
	@JoinColumn(name = "adventure_id")
	private Adventure adventure;

	public AdventureReview() {
		super();
	}
	
	public AdventureReview(CreateReviewDTO createReviewDTO, Client client, Adventure adventure) {
		super(createReviewDTO, client);
		this.adventure = adventure;
	}
}
