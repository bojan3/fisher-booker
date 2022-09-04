package com.example.fisherbooker.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.fisherbooker.model.DTO.ComplaintRequestDTO;
import com.example.fisherbooker.model.EmailContexts.NewComplaintEmailContext;
import com.example.fisherbooker.model.complaint.Complaint;
import com.example.fisherbooker.model.complaint.CottageComplaint;
import com.example.fisherbooker.model.complaint.InstructorComplaint;
import com.example.fisherbooker.model.complaint.ShipComplaint;
import com.example.fisherbooker.repository.ComplaintRepository;
import com.example.fisherbooker.repository.RegistrationRequestRepository;

@Service
public class ComplaintService {

	public ComplaintRepository complaintrepository;
	
	@Autowired
	public EmailService emailservice;

	@Autowired
	public ComplaintService(ComplaintRepository cr, EmailService emailService) {
		this.complaintrepository = cr;
		this.emailservice = emailService;
	}

	public List<Complaint> listAll() {
		return this.complaintrepository.findAll();
	}
	
	public List<Complaint> listAllUnanswered() {
		return this.complaintrepository.findAllUnanswered();
	}
	
	public List<CottageComplaint> listAllCottage() {
		return this.complaintrepository.findAllCottageComplaints();
	}
	
	public List<ShipComplaint> listAllShip() {
		return this.complaintrepository.findAllShipComplaints();
	}
	
	public List<InstructorComplaint> listAllAdventure() {
		return this.complaintrepository.findAllAdventureComplaints();
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)//, rollbackFor = Throwable.class)
	public Boolean respond(ComplaintRequestDTO complaintRequestDTO) throws Exception {
		Boolean response = false;
		try {
		Complaint c = this.complaintrepository.FindOneByID(complaintRequestDTO.getId());
		c.setAnswer(complaintRequestDTO.getAnswer());
		c.setAnswered(true);
		//this.complaintrepository.answer(c.getAnswer(),c.getId());
		this.complaintrepository.save(c);
//		this.complaintrepository.delete(c);
		response = true;
		}
		catch(Exception e){
			System.out.print("Greska u koracima");
		}
		finally {
			return response;
		}
		
	
	}
	
	
	
	
	
	
	
}