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
public class InstructorComplaint extends Complaint {


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	public FishingInstructor instructor;

	public InstructorComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstructorComplaint(Client client, FishingInstructor instructor, String text) {
		super();
		this.client = client;
		this.instructor = instructor;
		this.text = text;
		this.answered = false;
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

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return super.toString()+"Instructor:"+this.instructor.getAccount().getUsername();
	}
	
}