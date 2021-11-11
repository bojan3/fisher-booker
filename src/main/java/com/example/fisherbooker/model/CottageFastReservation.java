package com.example.fisherbooker.model;

import java.util.*;

public class CottageFastReservation {
   private int id;
   private java.util.Date startDate;
   private int price;
   private java.util.Date endDate;
   private int duration;
   private int capacity;
   private int additionalServices;
   
   public Cottage cottage;
   
   
   public Cottage getCottage() {
      return cottage;
   }
   
   public void setCottage(Cottage newCottage) {
      if (this.cottage == null || !this.cottage.equals(newCottage))
      {
         if (this.cottage != null)
         {
            Cottage oldCottage = this.cottage;
            this.cottage = null;
            oldCottage.removeCottageFastReservation(this);
         }
         if (newCottage != null)
         {
            this.cottage = newCottage;
            this.cottage.addCottageFastReservation(this);
         }
      }
   }

}