package com.example.fisherbooker.model;

public class ShipReservation {
   private int id;
   private int startDate;
   private int endDate;
   
   public java.util.Set<ShipOption> shipOption;
   public Ship ship;
   
   
   public java.util.Set<ShipOption> getShipOption() {
      if (shipOption == null)
         shipOption = new java.util.HashSet<ShipOption>();
      return shipOption;
   }
   
   public java.util.Iterator getIteratorShipOption() {
      if (shipOption == null)
         shipOption = new java.util.HashSet<ShipOption>();
      return shipOption.iterator();
   }
   
   
   public void setShipOption(java.util.Set<ShipOption> newShipOption) {
      removeAllShipOption();
      for (java.util.Iterator iter = newShipOption.iterator(); iter.hasNext();)
         addShipOption((ShipOption)iter.next());
   }
   

   public void addShipOption(ShipOption newShipOption) {
      if (newShipOption == null)
         return;
      if (this.shipOption == null)
         this.shipOption = new java.util.HashSet<ShipOption>();
      if (!this.shipOption.contains(newShipOption))
         this.shipOption.add(newShipOption);
   }
   
  
   public void removeShipOption(ShipOption oldShipOption) {
      if (oldShipOption == null)
         return;
      if (this.shipOption != null)
         if (this.shipOption.contains(oldShipOption))
            this.shipOption.remove(oldShipOption);
   }
   

   public void removeAllShipOption() {
      if (shipOption != null)
         shipOption.clear();
   }

}