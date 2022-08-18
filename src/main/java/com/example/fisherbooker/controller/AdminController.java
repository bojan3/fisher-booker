package com.example.fisherbooker.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.example.fisherbooker.model.GlobalNumber;
import com.example.fisherbooker.model.ReservationSupportData;
import com.example.fisherbooker.model.DTO.TwoStringsDTO;
import com.example.fisherbooker.service.AdminService;
import com.example.fisherbooker.service.GlobalNumberService;
import com.example.fisherbooker.service.SupportDataService;
import com.fasterxml.jackson.annotation.JsonFormat;



@RestController
@RequestMapping("api/admin")
public class AdminController {

//	@Autowired
	private AdminService adminservice;
	private GlobalNumberService gns;
	private SupportDataService sds;
	
	
	
	public AdminController(AdminService as, GlobalNumberService gs, SupportDataService sds){
		this.gns=gs;
		this.adminservice=as;
		this.sds=sds;
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
	
	@GetMapping("/supportdata")
	public ResponseEntity<List<ReservationSupportData>> getReservationSupportData(){
			
		List<ReservationSupportData> response = new ArrayList<ReservationSupportData>();
		 response = this.sds.getAll();
	
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/interval")
	public ResponseEntity<List<ReservationSupportData>> getReservationSupportDataInInterval(@RequestParam 	
		String start, @RequestParam 
		String end) throws ParseException{
		 			
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(start);
		System.out.println("Start:"+start+"Date:"+date1);
		
		
	    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
	
		System.out.println("Start:"+end+"Date:"+date2);

			
		System.out.println("pozivanje servisa");
		
		List<ReservationSupportData> response = new ArrayList<ReservationSupportData>();
		 response = this.sds.getAllinInterval(date1,date2);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/interval_income")	
	public ResponseEntity<String> getIncome(@RequestBody	
			TwoStringsDTO ts , UriComponentsBuilder ucBuilder)
			throws ParseException{
			 			
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString1());			
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString2());			
			float response = this.sds.sumIncome(date1,date2);
			return new ResponseEntity<>(""+response+"",HttpStatus.OK);
		}
	
	@PostMapping("/interval_income/{type}")	
	public ResponseEntity<String> getIncomeType(@PathVariable String type,@RequestBody	
			TwoStringsDTO ts , UriComponentsBuilder ucBuilder)
			throws ParseException{
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString1());			
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString2());			
			float response = this.sds.sumIncomeTYPE(date1, date2, type);
			return new ResponseEntity<>(""+response+"",HttpStatus.OK);
		}
	
	@PostMapping("/interval_total")	
	public ResponseEntity<String> countTotal(@RequestBody	
			TwoStringsDTO ts , UriComponentsBuilder ucBuilder)
			throws ParseException{
			 			
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString1());			
			
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString2());
			
			float response = this.sds.count(date1,date2);
			return new ResponseEntity<>(""+response+"",HttpStatus.OK);
		}
	
	@PostMapping("/interval_total/{type}")	
	public ResponseEntity<String> countType(@PathVariable String type, @RequestBody	
			TwoStringsDTO ts , UriComponentsBuilder ucBuilder)
			throws ParseException{
			 			
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString1());			
			
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ts.getString2());
			int response = this.sds.countTYPE(date1,date2, type);
			return new ResponseEntity<>(""+response+"",HttpStatus.OK);
		}
	
}
