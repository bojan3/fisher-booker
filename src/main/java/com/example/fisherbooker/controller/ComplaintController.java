package com.example.fisherbooker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.DTO.ComplaintRequestDTO;
import com.example.fisherbooker.model.DTO.CreateReviewDTO;
import com.example.fisherbooker.model.EmailContexts.NewComplaintEmailContext;
import com.example.fisherbooker.model.complaint.Complaint;
import com.example.fisherbooker.model.complaint.CottageComplaint;
import com.example.fisherbooker.model.complaint.InstructorComplaint;
import com.example.fisherbooker.model.complaint.ShipComplaint;
import com.example.fisherbooker.service.AdventureService;
import com.example.fisherbooker.service.ComplaintService;
import com.example.fisherbooker.service.EmailService;
import com.example.fisherbooker.service.FishingInstructorService;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {
	public ComplaintService complaintService;
	@Autowired
	private EmailService emailService;

	@Autowired
	public ComplaintController(ComplaintService complaintservice) {
		this.complaintService = complaintservice;
	}

	// ownerId ce drugacije da se dobavlja jednom kada dodamo spring security
	@GetMapping("/unanswered")
	public ResponseEntity<List<ComplaintRequestDTO>> getAllByOwner() {
		List<ComplaintRequestDTO> c = new ArrayList<ComplaintRequestDTO>();
		List<CottageComplaint> cc = this.complaintService.listAllCottage();
		List<InstructorComplaint> ic = this.complaintService.listAllAdventure();
		List<ShipComplaint> sc = this.complaintService.listAllShip();

		for (ShipComplaint sht : sc) {
			c.add(new ComplaintRequestDTO(sht));
		}

		for (InstructorComplaint it : ic) {
			c.add(new ComplaintRequestDTO(it));

		}
		for (CottageComplaint ct : cc) {
			c.add(new ComplaintRequestDTO(ct));
		}
		System.out.println(c);

		return new ResponseEntity<>(c, HttpStatus.OK);

	}

	@PostMapping("/answer")
	public ResponseEntity<Boolean> saveCottageReview(@RequestBody ComplaintRequestDTO complaintRequestDTO) {
		Boolean response = false;
		try {
			if(this.complaintService.respond(complaintRequestDTO)) {		
			try {
			System.out.println(complaintRequestDTO);
			NewComplaintEmailContext context1 = new NewComplaintEmailContext();
			context1.init(complaintRequestDTO);
			context1.setTo(complaintRequestDTO.getClient_email());
			
			try {
				emailService.sendMail(context1);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			NewComplaintEmailContext context2 = new NewComplaintEmailContext();
			context2.init(complaintRequestDTO);
			context2.setTo(complaintRequestDTO.getOwner_email());
			
			try {
				emailService.sendMail(context2);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}	
				catch(Exception e) {
					}
			}
			response = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("vec je odgovoreno");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}