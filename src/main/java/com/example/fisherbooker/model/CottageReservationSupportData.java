package com.example.fisherbooker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class CottageReservationSupportData extends ReservationSupportData {

    @OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne
	//(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="reservation_id")
	
	private CottageReservation ctr;
	
	
	public CottageReservationSupportData() {
		super();
	}


	public void setCottageReservation(CottageReservation reservation) {
			this.ctr=reservation;
	}
	
}

