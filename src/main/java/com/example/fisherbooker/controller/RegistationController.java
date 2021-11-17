package com.example.fisherbooker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.service.CottageOwnerService;
import com.example.fisherbooker.service.InstructorService;
import com.example.fisherbooker.service.ShipOwnerService;

@RestController
@RequestMapping("/api/registration")

public class RegistationController {
	private CottageOwnerService cos;
	private ShipOwnerService sos;
 	private InstructorService is;
	
}
