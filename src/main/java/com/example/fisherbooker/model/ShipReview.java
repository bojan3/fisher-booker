package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.DTO.CreateReviewDTO;

@Entity
@DiscriminatorValue("ship_review")
public class ShipReview extends Review {

	@ManyToOne
	@JoinColumn(name = "ship_id")
	private Ship ship;

	public ShipReview() {
		super();
	}

	public ShipReview(CreateReviewDTO createReviewDTO, Client client, Ship ship) {
		super(createReviewDTO, client);
		this.ship = ship;
	}

}
