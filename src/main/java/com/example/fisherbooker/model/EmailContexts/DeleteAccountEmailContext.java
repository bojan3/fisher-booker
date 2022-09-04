package com.example.fisherbooker.model.EmailContexts;

import com.example.fisherbooker.model.DTO.ComplaintRequestDTO;
import com.example.fisherbooker.model.DTO.DeleteAccountEmailContextDTO;

public class DeleteAccountEmailContext extends EmailContext {

	public <T> void init(T context) {
		// we can do any common configuration setup here
		// like setting up some base URL and context			
		DeleteAccountEmailContextDTO daecDTO =(DeleteAccountEmailContextDTO) context;
		
		put("clientusername", daecDTO.getAccount().getUsername());
		put("answer", daecDTO.getAnswer());			
		
		setTemplateLocation("deleteaccount");
		setSubject("Delete account answer");
		setFrom("potuc3@gmail.com");	
		setTo(daecDTO.getAccount().getEmail());
		}	
}
