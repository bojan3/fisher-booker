package com.example.fisherbooker.model;

import java.util.*;

public class CottageReservation {
   private int id;
   private int startDate;
   private int endDate;
   private int price;
   private int duration;
   private int capacity;
   private int additionalServices;
   
   public Cottage cottage;
   
   
   /*public Cottage getCottage() {
      return cottage;
   }
   
   public void setCottage(Cottage newCottage) {
      if (this.cottage == null || !this.cottage.equals(newCottage))
      {
         if (this.cottage != null)
         {
            Cottage oldCottage = this.cottage;
            this.cottage = null;
            oldCottage.removeCottageReservation(this);
         }
         if (newCottage != null)
         {
            this.cottage = newCottage;
            this.cottage.addCottageReservation(this);
         }
      }
   }*/

}