package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("SHIP")
public class ShipReservationReview extends ReservationReview {
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id")
	private ShipReservation shipReservation;

	public ShipReservationReview() {
		super();
	}

	public ShipReservation getShipReservation() {
		return shipReservation;
	}

	public void setShipReservation(ShipReservation shipReservation) {
		this.shipReservation = shipReservation;
	}

}
