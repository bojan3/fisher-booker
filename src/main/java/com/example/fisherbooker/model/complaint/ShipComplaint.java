package com.example.fisherbooker.model.complaint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Ship;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipComplaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id", nullable = false)
	public Ship ship;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	@Column
	private String text;

	private String answer;
	@Column
	private Boolean answered;

	public ShipComplaint() {
		super();
	}

	public ShipComplaint(Client client, Ship ship, String text) {
		super();
		this.text = text;
		this.answered = false;
		this.client = client;
		this.ship = ship;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getAnswered() {
		return answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	@Override
	public String toString() {
		return "ShipComplaint [id=" + id + ", ship=" + ship + ", client=" + client + ", text=" + text + ", answer="
				+ answer + ", answered=" + answered + "]";
	}
	
	

}