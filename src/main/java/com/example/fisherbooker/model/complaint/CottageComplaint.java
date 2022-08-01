package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;

@Entity
public class CottageComplaint {

	private Long clientId;
	private Long cottageId;
	private String text;
	private Boolean answered;
	
	public CottageComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CottageComplaint(Long clientId, Long cottageId, String text, Boolean answered) {
		super();
		this.clientId = clientId;
		this.cottageId = cottageId;
		this.text = text;
		this.answered=answered;
	}
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getCottageId() {
		return cottageId;
	}
	public void setCottageId(Long cottageId) {
		this.cottageId = cottageId;
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
		return "CottageComplaint [clientId=" + clientId + ", cottageId=" + cottageId + ", text=" + text + "]";
	}
	
}
