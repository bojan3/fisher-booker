package com.example.fisherbooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fisherbooker.model.GlobalNumber;
import com.example.fisherbooker.service.AdminService;
import com.example.fisherbooker.service.GlobalNumberService;

@RestController
@RequestMapping("api/admin")
public class AdminController {

//	@Autowired
	private AdminService adminservice;
	private GlobalNumberService gns;
	
	
	
	public AdminController(AdminService as, GlobalNumberService gs){
		this.gns=gs;
		this.adminservice=as;
	}
	
	
	@PostMapping("/income/new")
	@ResponseBody
	public ResponseEntity<String> ChangeIncome(@RequestBody String income) {
		System.out.println("ulazimo u kontroler da bismo uneli novu vrednost:");
		System.out.println(income);
		GlobalNumber gn = new GlobalNumber();
		gn= this.gns.GetByID((long)1);
		float f=Float.parseFloat(income);
		gn.setValuex(f);
		this.gns.Save(gn);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/income")
	public ResponseEntity<String> getIncomePrecentage(){
		//GlobalNumber gn = this.gns.GetByID((long) 1);
		
		GlobalNumber gn = new GlobalNumber();
		gn= this.gns.GetByID((long)1);
		
		System.out.println(gn);
		
		return new ResponseEntity<String>(gn.getValuex().toString(), HttpStatus.OK);
	}
	
	
	
	
}
