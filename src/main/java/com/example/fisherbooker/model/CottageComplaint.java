package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
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

	@Override
	public String toString() {
		return "CottageComplaint [id=" + id + ", cottage=" + cottage + ", client=" + client + ", text=" + text
				+ ", answer=" + answer + "]";
	}

	
	
	public CottageComplaint(Long id, Cottage cottage, Client client, String text, String answer) {
		super();
		this.id = id;
		this.cottage = cottage;
		this.client = client;
		this.text = text;
		this.answer = answer;
	}

	public CottageComplaint(Cottage cottage, Client client, String text, String answer) {
		super();
		this.cottage = cottage;
		this.text = text;
		this.answer = answer;
		this.client = client;
	}
	
}
