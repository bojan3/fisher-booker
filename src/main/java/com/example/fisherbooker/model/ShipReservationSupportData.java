package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class ShipReservationSupportData extends ReservationSupportData{

    @OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne
	//(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="reservation_id")
	
	private ShipReservation shr;
	
	
	public ShipReservationSupportData() {
		super();
	}


	public void setShipReservation(ShipReservation reservation) {
			this.shr=reservation;
	}
	
}
