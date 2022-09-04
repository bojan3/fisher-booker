package com.example.fisherbooker.model.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.complaint.CottageComplaint;
import com.example.fisherbooker.model.complaint.InstructorComplaint;
import com.example.fisherbooker.model.complaint.ShipComplaint;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ComplaintRequestDTO {

	
	
	private Long id;
	private String owner_username;
//	private String owner_role;
	private String owner_email;
	
	private String client;
	private String client_email;
	private String client_username;

	private String text;
	private String answer;
	private Boolean answered;
	
	
	public ComplaintRequestDTO() {
		super();
	}
	
	public ComplaintRequestDTO(String client, String owner, String text) {
		super();
		this.client = client;
		this.owner_username = owner;
		this.text = text;
		this.answered=false;
	//	this.owner_username = owner.
		
		
	}
	
	public ComplaintRequestDTO(CottageComplaint cc) {	
		this.answer = cc.getText();
		this.answered = cc.getAnswered();
		this.id = cc.getId();
		this.answer = cc.getAnswer();
		this.client = cc.getClientId().toString();
		this.client_email = cc.getClientId().getAccount().getEmail();
		this.client_username = cc.getClientId().getAccount().getUsername();
	//	this.owner_username = cc.getCottageId().toString();
		this.owner_username = cc.getCottageId().getCottageOwner().getAccount().getUsername();
		this.owner_email = cc.getCottageId().getCottageOwner().getAccount().getEmail();
		this.text = cc.getText();
//		System.out.println(cc.getCottageId().getCottageOwner().getAccount().getUsername());
//		System.out.println(cc.getCottageId().getCottageOwner().getAccount().getEmail());


		
//		this.owner_role = cc.getCottageId().getCottageOwner().getAccount().getRoles().toString();
	}
	
	public ComplaintRequestDTO(ShipComplaint shc) {	
		this.answer = shc.getText();
		this.answered = shc.getAnswered();
		this.id = shc.getId();
		this.answer = shc.getAnswer();
		this.client = shc.getClientId().toString();
		this.client_email = shc.getClientId().getAccount().getEmail();
		this.client_username = shc.getClientId().getAccount().getUsername();
	//	System.out.println(shc.getShipId().getShipOwner().getAccount().getUsername());
		this.owner_username = shc.getShipId().getShipOwner().getAccount().getUsername();
		this.owner_email = shc.getShipId().getShipOwner().getAccount().getEmail();
		this.text = shc.getText();
	//	this.owner_role = shc.getShipId().getShipOwner().getAccount().getRoles().toString();
	//	System.out.println(shc.getShipId().getShipOwner().getAccount().getUsername());
	//	System.out.println(shc.getShipId().getShipOwner().getAccount().getEmail());
	}
	
	public ComplaintRequestDTO(InstructorComplaint cc) {	
		this.answer = cc.getText();
		this.answered = cc.getAnswered();
		this.id = cc.getId();
		this.answer = cc.getAnswer();
		this.client = cc.getClientId().toString();
		this.client_email = cc.getClientId().getAccount().getEmail();
		this.client_username = cc.getClientId().getAccount().getUsername();
		this.owner_username = cc.getInstructorId().getAccount().getUsername();
		this.owner_email = cc.getInstructorId().getAccount().getEmail();
		this.text = cc.getText();

	//	this.owner_role = cc.getInstructorId().getAccount().getRoles().toString();
	}
	
	
	
	public String getClientId() {
		return client;
	}
	public void setClientId(String clientId) {
		this.client = clientId;
	}
	public String getOwnerId() {
		return owner_username;
	}
	public void setOwner(String owner) {
		this.owner_username = owner;
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
	
	public String getAnswere() {
		return answer;
	}
	public void setAnswere(String answered) {
		this.answer = answered;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner_username() {
		return owner_username;
	}

	public void setOwner_username(String owner_username) {
		this.owner_username = owner_username;
	}

//	public String getOwner_role() {
//		return owner_role;
//	}

//	public void setOwner_role(String owner_role) {
//		this.owner_role = owner_role;
//	}

	public String getOwner_email() {
		return owner_email;
	}

	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getClient_email() {
		return client_email;
	}

	public void setClient_email(String client_email) {
		this.client_email = client_email;}

	public String getClient_username() {
		return client_username;	}

	public void setClient_username(String client_username) {
		this.client_username = client_username;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "ComplaintRequestDTO [id=" + id + ", owner_username=" + owner_username //+ ", owner_role=" + owner_role
				 + ", client=" + client 
				+ ", client_username=" + ", text=" + text + ", answer=" + answer + ", answered="
				+ answered + "]";
	}


	
	
	

}

