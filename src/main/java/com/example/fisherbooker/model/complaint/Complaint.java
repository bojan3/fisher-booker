package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	protected Client client;
	protected String text;
	protected String answer;
	protected Boolean answered;
	
	@Version
	protected Long version;

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(Client client, String text) {
		super();
		this.client = client;
		this.text = text;
		this.answered = false;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client clientId) {
		this.client = clientId;
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
		return "Complaint [id=" + id + ", client=" + client + ", text=" + text + ", answer=" + answer + ", answered="
				+ answered + "]";
	}
	
	 

}
