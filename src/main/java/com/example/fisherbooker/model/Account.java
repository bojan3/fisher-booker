package com.example.fisherbooker.model;

import javax.persistence.Entity;

/*@Entity*/
public class Account {
   private String email;
   private String password;
   private String name;
   private String lastName;
   private String phoneNumber;
   private UserRoles role;
   
   public Address address;

}