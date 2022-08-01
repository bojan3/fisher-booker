package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstructorComplaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "instructor_id", nullable = false)
	public FishingInstructor instructor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;
	
	private String text;
	private String answer;
	private Boolean answered;
	
	
	public InstructorComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InstructorComplaint(Client clientId, FishingInstructor instructorId, String text, Boolean answered) {
		super();
		this.client = clientId;
		this.instructor = instructorId;
		this.text = text;
		this.answered=answered;
	}
	
	public Client getClientId() {
		return client;
	}
	public void setClientId(Client clientId) {
		this.client = clientId;
	}
	public FishingInstructor getInstructorId() {
		return instructor;
	}
	public void setInstructor(FishingInstructor instructorId) {
		this.instructor = instructorId;
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