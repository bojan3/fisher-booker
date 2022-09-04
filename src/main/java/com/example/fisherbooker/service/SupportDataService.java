package com.example.fisherbooker.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fisherbooker.model.AdventureReservationSupportData;
import com.example.fisherbooker.model.CottageReservationSupportData;
import com.example.fisherbooker.model.ReservationSupportData;
import com.example.fisherbooker.model.ShipReservationSupportData;
import com.example.fisherbooker.repository.AdventureSupportDataRepository;
import com.example.fisherbooker.repository.CottageSupportDataRepository;
import com.example.fisherbooker.repository.ShipSupportDataRepository;

@Service
public class SupportDataService {

	private AdventureSupportDataRepository asdr;
	private ShipSupportDataRepository shsdr;
	private CottageSupportDataRepository csdr;
	
	public SupportDataService(AdventureSupportDataRepository a, ShipSupportDataRepository sh, CottageSupportDataRepository c) {
		this.asdr = a;
		this.shsdr = sh;
		this.csdr = c;
	}
	
	public  List<ReservationSupportData> getAll(){
				List<ReservationSupportData> rsd = new ArrayList<ReservationSupportData>();
				List<AdventureReservationSupportData> arsd = new ArrayList<AdventureReservationSupportData>();
				List<ShipReservationSupportData> shrsd = new ArrayList<ShipReservationSupportData>();
				List<CottageReservationSupportData> crsd = new ArrayList<CottageReservationSupportData>();
				
				arsd = this.asdr.findAll();
				shrsd = this.shsdr.findAll();
				crsd = this.csdr.findAll();
		 	 
				for(AdventureReservationSupportData a : arsd)
					rsd.add(a);
		 
				for(ShipReservationSupportData sh : shrsd)
					rsd.add(sh);
				
				for(CottageReservationSupportData c : crsd)
					rsd.add(c);
		 		 
				return rsd;
	
	}
	
	public  List<ReservationSupportData> getAllinInterval(Date start, Date end) throws ParseException{
		List<ReservationSupportData> rsd = new ArrayList<ReservationSupportData>();
		List<AdventureReservationSupportData> arsd = new ArrayList<AdventureReservationSupportData>();
		List<ShipReservationSupportData> shrsd = new ArrayList<ShipReservationSupportData>();
		List<CottageReservationSupportData> crsd = new ArrayList<CottageReservationSupportData>();

		
		arsd = this.asdr.findAll();
		shrsd = this.shsdr.findAll();
		crsd = this.csdr.findAll();
 	 
		for(AdventureReservationSupportData a : arsd)
			{
		    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(a.getReservationdate());
		
			if ((date1.compareTo(start)>=0) && (date1.compareTo(end)<=0))
				rsd.add(a);
				}
			
		for(ShipReservationSupportData sh : shrsd) {
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(sh.getReservationdate());

			if ((date2.compareTo(start)>=0) && (date2.compareTo(end)<=0))
			rsd.add(sh);
		}
		
		for(CottageReservationSupportData c : crsd) {
		    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(c.getReservationdate());

			if ((date2.compareTo(start)>=0) && (date2.compareTo(end)<=0))
			rsd.add(c);
		}
		
		return rsd;
		}
	
		
	public float sumIncome(Date start, Date end) throws ParseException {
		float suma=0;
		List<ReservationSupportData> rsd = this.getAllinInterval(start, end);
		for (ReservationSupportData a : rsd)
			suma= suma+ a.getPrice()*a.getSystemIncome();
		return suma;
	}
	
	 
 	public int count(Date start, Date end) throws ParseException {
		List<ReservationSupportData> rsd = this.getAllinInterval(start, end);
		return rsd.size();
	}
	
	public float sumIncomeTYPE(Date start, Date end, String type) throws ParseException {
		System.out.println(type);
		float suma=0;
		List<ReservationSupportData> rsd = this.getAllinInterval(start, end);
		for (ReservationSupportData a : rsd)
			{if(a.getDtype().equals(type))
			suma= suma+ a.getPrice()*a.getSystemIncome();
			}
		return suma;
	}
	
	 
 	public int countTYPE(Date start, Date end, String type) throws ParseException {
		System.out.println(type);
 		List<ReservationSupportData> rsd = new ArrayList<ReservationSupportData>();
		for (ReservationSupportData rs : this.getAllinInterval(start, end)) {
			if(rs.getDtype().equals(type))
				rsd.add(rs);
		}
		return rsd.size();
	}
	
	
	
	
	
}
