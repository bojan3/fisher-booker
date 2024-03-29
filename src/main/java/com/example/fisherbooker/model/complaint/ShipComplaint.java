package com.example.fisherbooker.model.complaint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.Ship;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipComplaint extends Complaint {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id")
	public Ship ship;

	public ShipComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShipComplaint(Client client, Ship ship, String text) {
		super();
		this.client = client;
		this.ship = ship;
		this.text = text;
		this.answered = false;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client clientId) {
		this.client = clientId;
	}

	public Ship getShipId() {
		return ship;
	}

	public void setCottageId(Ship cottageId) {
		this.ship = cottageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getAnswered() {
		return answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return super.toString() + "Ship:" + this.ship;
	}

}