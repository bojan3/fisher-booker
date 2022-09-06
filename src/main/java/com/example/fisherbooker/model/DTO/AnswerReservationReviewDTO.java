package com.example.fisherbooker.model.DTO;

import javax.persistence.GeneratedValue;

import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.AdventureReservationReview;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.ReservationReview;
import com.example.fisherbooker.model.ReservationType;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipReservationReview;

public class AnswerReservationReviewDTO {

	
	
	private String content;
	private Boolean badReview;
	private Boolean didntAppear;
	private String type;
	private Long reservationId;
	private String clientusername;
	private String ownerusername;
	private String clientemail;
	private String owneremail;
	
	public AnswerReservationReviewDTO() {
		super();
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getBadReview() {
		return badReview;
	}

	public void setBadReview(Boolean badReview) {
		this.badReview = badReview;
	}

	public Boolean getDidntAppear() {
		return didntAppear;
	}

	public void setDidntAppear(Boolean didntAppear) {
		this.didntAppear = didntAppear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	
	public String getOwnerUsername() {
		return ownerusername;
	}

	public void setOwnerUsername(String owner) {
		this.ownerusername = owner;
	}
	public String getClientUsername() {
		return this.clientusername;
	}

	public void setClientUsername(String clientusername) {
		this.clientusername = clientusername;
	}
	
	public String getClientEmail() {
		return this.clientemail;
	}

	public void setClientEmail(String clientemail) {
		this.clientemail = clientemail;
	}
	
	public String getOwnerEmail() {
		return this.owneremail;
	}

	public void setOwnerEmail(String owneremail) {
		this.owneremail = owneremail;
	}
	

	public AnswerReservationReviewDTO(CottageReservationReview cr) {
			this.badReview = cr.getBadReview();
			this.content  = cr.getContent();
			this.didntAppear =  cr.getDidntAppear();
			this.reservationId = cr.getCottageReservation().getId();
			this.type = "COTTAGE";
			this.clientusername = cr.getCottageReservation().getClient().getAccount().getUsername();
			this.clientemail = cr.getCottageReservation().getClient().getAccount().getEmail();
			this.ownerusername = cr.getCottageReservation().getCottage().getCottageOwner().getAccount().getUsername();
			this.owneremail = cr.getCottageReservation().getCottage().getCottageOwner().getAccount().getEmail();

			
	}

	public AnswerReservationReviewDTO(ShipReservationReview shr) {
		this.badReview = shr.getBadReview();
		this.content  = shr.getContent();
		this.didntAppear =  shr.getDidntAppear();
		this.reservationId = shr.getShipReservation().getId();
		this.type = "SHIP";
		this.clientusername = shr.getShipReservation().getClient().getAccount().getUsername();
		this.clientemail = shr.getShipReservation().getClient().getAccount().getEmail();
		this.ownerusername = shr.getShipReservation().getShip().getShipOwner().getAccount().getUsername();
		this.owneremail = shr.getShipReservation().getShip().getShipOwner().getAccount().getEmail();
	}

	public AnswerReservationReviewDTO(AdventureReservationReview ar) {
		this.badReview = ar.getBadReview();
		this.content  = ar.getContent();
		this.didntAppear =  ar.getDidntAppear();
		this.reservationId = ar.getAdventureReservation().getId();
		this.type = "ADVENTURE";
		this.clientusername = ar.getAdventureReservation().getClient().getAccount().getUsername();
		this.clientemail = ar.getAdventureReservation().getClient().getAccount().getEmail();
		this.ownerusername = ar.getAdventureReservation().getAdventure().getFishingInstructor().getAccount().getUsername();
		this.owneremail = ar.getAdventureReservation().getAdventure().getFishingInstructor().getAccount().getEmail();
	}

	@Override
	public String toString() {
		return "AnswerReservationReviewDTO ["+"content=" + content + ", badReview=" + badReview + ", didntAppear="
				+ didntAppear + ", type=" + type + ", reservationId=" + reservationId + "clientusername:"+clientusername
				+"clientemail:"+clientemail+"ownerusername:"+ownerusername+"owneremail:"+owneremail
				+ "]";
	}

	public CottageReservationReview toCottageReview() {
		CottageReservationReview review = new CottageReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setCottageReservation(new CottageReservation(reservationId));
		review.setAnswered(true);
		return review;
	}

	public ShipReservationReview toShipReview() {
		ShipReservationReview review = new ShipReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setShipReservation(new ShipReservation(reservationId));
		review.setAnswered(true);
		return review;
	}

	public AdventureReservationReview toAdventureReview() {
		AdventureReservationReview review = new AdventureReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setAdventureReservation(new AdventureReservation(reservationId));
		review.setAnswered(true);
		return review;
	}

	
	
	
	
	
}
