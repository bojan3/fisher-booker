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
public class CottageComplaint extends Complaint {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	public Cottage cottage;


	public CottageComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CottageComplaint(Client client, Cottage cottage, String text) {
		super();
		this.client = client;
		this.cottage = cottage;
		this.text = text;
		this.answered = false;
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
		return super.toString()+"Cottage:"+this.cottage;
	}
	
}
