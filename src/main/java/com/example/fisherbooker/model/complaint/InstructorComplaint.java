package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;

@Entity
public class InstructorComplaint {

	private Long clientId;
	private Long instructorId;
	private String text;
	private Boolean answered;
	
	public InstructorComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InstructorComplaint(Long clientId, Long instructorId, String text, Boolean answered) {
		super();
		this.clientId = clientId;
		this.instructorId = instructorId;
		this.text = text;
		this.answered=answered;
	}
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getInstructorId() {
		return instructorId;
	}
	public void setShipId(Long shipId) {
		this.instructorId = shipId;
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

	@Override
	public String toString() {
		return "InstructorComplaint [clientId=" + clientId + ", instructorId=" + instructorId + ", text=" + text + "]";
	}
	
}