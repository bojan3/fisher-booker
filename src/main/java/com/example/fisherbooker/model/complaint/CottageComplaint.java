package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.FishingInstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CottageComplaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id", nullable = false)
	public Cottage cottage;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;
	
	private String text;
	private String answer;
	private Boolean answered;
	
	public CottageComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CottageComplaint(Client clientId, Cottage cottageId, String text, Boolean answered) {
		super();
		this.client = clientId;
		this.cottage = cottageId;
		this.text = text;
		this.answered=answered;
	}
	
	public Client getClientId() {
		return client;
	}
	public void setClientId(Client clientId) {
		this.client = clientId;
	}
	public Cottage getCottageId() {
		return cottage;
	}
	public void setCottageId(Cottage cottageId) {
		this.cottage = cottageId;
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
	
	
	
	
}
