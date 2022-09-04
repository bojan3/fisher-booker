package com.example.fisherbooker;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.runner.RunWith;

//import ;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.fisherbooker.model.DeleteAccountRequest;
import com.example.fisherbooker.repository.AccountRepository;
import com.example.fisherbooker.repository.DeleteAccountRequestRepository;
import com.example.fisherbooker.service.impl.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDeleteAccountTransactionTest {
	
    @Autowired
	private AccountServiceImpl accountService;
	
    @Autowired
    private DeleteAccountRequestRepository drr;

    @Autowired
    private AccountRepository arr;
    
	@Before
	void setup() {
		//Creating prototype delete account request
	DeleteAccountRequest req = new DeleteAccountRequest();
	req.setAccount(arr.getById((long) 2));
	req.setDescription("hocu da obrisem ovaj nalog");
	drr.save(req);
	System.out.println("Zahtevi za brisanje naloga");
	System.out.println(drr.findAll());
	
	}

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testOptimisticLockingScenario() throws Throwable {	

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<?> future1 = executor.submit(new Runnable() {
			
			@Override
			public void run() {
		        System.out.println("Startovan Thread 1");
				//Product productToUpdate = productService.findById(1L);// ocitan objekat sa id 1
				//productToUpdate.setPrice(800L);// izmenjen ucitan objekat
				
		        try {
					accountService.denydeleteAccountRequest((long) 2,"ne moze da se obrise nalog iz Treda 1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        try { Thread.sleep(3000); } catch (InterruptedException e) {}// thread uspavan na 3 sekunde da bi drugi thread mogao da izvrsi istu operaciju
				//productService.save(productToUpdate);// bacice ObjectOptimisticLockingFailureException
				
			}
		});
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
		        System.out.println("Startovan Thread 2");
				//Product productToUpdate = productService.findById(1L);// ocitan isti objekat sa id 1 kao i iz prvog threada
				//productToUpdate.setPrice(900L);// izmenjen ucitan objekat
				/*
				 * prvi ce izvrsiti izmenu i izvrsi upit:
				 * Hibernate: 
				 *     update
				 *         product
				 *     set
				 *         name=?,
        		 *         origin=?,
                 *         price=?,
                 *         version=? 
                 *     where
                 *         id=? 
                 *         and version=?
                 *         
                 * Moze se primetiti da automatski dodaje na upit i proveru o verziji
				 */
				//productService.save(productToUpdate);
		        try {
					accountService.denydeleteAccountRequest((long) 2,"ne moze da se obrise nalog iz Treda 2");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		try {
		    future1.get(); // podize ExecutionException za bilo koji izuzetak iz prvog child threada
		} catch (ExecutionException e) {
		    System.out.println("Exception from thread " + e.getCause().getClass()); // u pitanju je bas ObjectOptimisticLockingFailureException
		    throw e.getCause();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();

	}
	
	
	
	
	
	
	
	
	
}
