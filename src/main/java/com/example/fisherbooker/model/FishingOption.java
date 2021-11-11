package com.example.fisherbooker.model;

import java.util.*;

public class FishingOption {
   private int id;
   private String name;
   private String description;
   private int price;
   
   public java.util.Collection<Address> address;
   
   
   public java.util.Collection<Address> getAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address;
   }
   
   public java.util.Iterator getIteratorAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address.iterator();
   }
   
  
   public void setAddress(java.util.Collection<Address> newAddress) {
      removeAllAddress();
      for (java.util.Iterator iter = newAddress.iterator(); iter.hasNext();)
         addAddress((Address)iter.next());
   }
   
 
   public void addAddress(Address newAddress) {
      if (newAddress == null)
         return;
      if (this.address == null)
         this.address = new java.util.HashSet<Address>();
      if (!this.address.contains(newAddress))
         this.address.add(newAddress);
   }
   

   public void removeAddress(Address oldAddress) {
      if (oldAddress == null)
         return;
      if (this.address != null)
         if (this.address.contains(oldAddress))
            this.address.remove(oldAddress);
   }
   
   public void removeAllAddress() {
      if (address != null)
         address.clear();
   }

}