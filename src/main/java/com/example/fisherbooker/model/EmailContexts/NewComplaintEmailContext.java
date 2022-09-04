package com.example.fisherbooker.model.EmailContexts;

import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.model.DTO.ComplaintRequestDTO;


	public class NewComplaintEmailContext extends EmailContext {
	//	private String token;
		
		public <T> void init(T context) {
			// we can do any common configuration setup here
			// like setting up some base URL and context			
			ComplaintRequestDTO crDTO =(ComplaintRequestDTO) context;
			
			put("clientusername", crDTO.getClient_username());
			put("ownerusername", crDTO.getOwner_username());
			put("text", crDTO.getText());
			put("answer", crDTO.getAnswer());			
						
			setTemplateLocation("new-complaint");
			setSubject("New complaint");
			setFrom("potuc3@gmail.com");
			
		}

	}
	
