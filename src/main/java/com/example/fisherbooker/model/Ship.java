package com.example.fisherbooker.model;

public class Ship {
   private String id;
   private String name;
   private ShipType type;
   private float length;
   private String description;
   private float averageMark;
   private int rentPrice;
   private int engineNumber;
   private int enginePower;
   private float maxSpeed;
   private int capacity;
   private float cancelRate;
   
   public java.util.Set<Rule> rule;
   public java.util.Set<NavigationEquipment> navigationEquipment;
   public java.util.Set<FishingEquipment> fishingEquipment;
   public java.util.Collection<ShipPicture> shipPicture;
   public java.util.Collection<ShipFastReservation> shipFastReservation;
   public Address address;
   public java.util.Set<ShipOption> shipOption;
   public ShipReservation shipReservation;
   
   
   public java.util.Set<Rule> getRule() {
      if (rule == null)
         rule = new java.util.HashSet<Rule>();
      return rule;
   }
   
   public java.util.Iterator getIteratorRule() {
      if (rule == null)
         rule = new java.util.HashSet<Rule>();
      return rule.iterator();
   }
   
  
   public void setRule(java.util.Set<Rule> newRule) {
      removeAllRule();
      for (java.util.Iterator iter = newRule.iterator(); iter.hasNext();)
         addRule((Rule)iter.next());
   }
   
 
   public void addRule(Rule newRule) {
      if (newRule == null)
         return;
      if (this.rule == null)
         this.rule = new java.util.HashSet<Rule>();
      if (!this.rule.contains(newRule))
         this.rule.add(newRule);
   }
   
  
   public void removeRule(Rule oldRule) {
      if (oldRule == null)
         return;
      if (this.rule != null)
         if (this.rule.contains(oldRule))
            this.rule.remove(oldRule);
   }
   
   public void removeAllRule() {
      if (rule != null)
         rule.clear();
   }
   public java.util.Set<NavigationEquipment> getNavigationEquipment() {
      if (navigationEquipment == null)
         navigationEquipment = new java.util.HashSet<NavigationEquipment>();
      return navigationEquipment;
   }
   
   public java.util.Iterator getIteratorNavigationEquipment() {
      if (navigationEquipment == null)
         navigationEquipment = new java.util.HashSet<NavigationEquipment>();
      return navigationEquipment.iterator();
   }
   
   public void setNavigationEquipment(java.util.Set<NavigationEquipment> newNavigationEquipment) {
      removeAllNavigationEquipment();
      for (java.util.Iterator iter = newNavigationEquipment.iterator(); iter.hasNext();)
         addNavigationEquipment((NavigationEquipment)iter.next());
   }
   
   public void addNavigationEquipment(NavigationEquipment newNavigationEquipment) {
      if (newNavigationEquipment == null)
         return;
      if (this.navigationEquipment == null)
         this.navigationEquipment = new java.util.HashSet<NavigationEquipment>();
      if (!this.navigationEquipment.contains(newNavigationEquipment))
         this.navigationEquipment.add(newNavigationEquipment);
   }
   
   public void removeNavigationEquipment(NavigationEquipment oldNavigationEquipment) {
      if (oldNavigationEquipment == null)
         return;
      if (this.navigationEquipment != null)
         if (this.navigationEquipment.contains(oldNavigationEquipment))
            this.navigationEquipment.remove(oldNavigationEquipment);
   }
   
   public void removeAllNavigationEquipment() {
      if (navigationEquipment != null)
         navigationEquipment.clear();
   }
   public java.util.Set<FishingEquipment> getFishingEquipment() {
      if (fishingEquipment == null)
         fishingEquipment = new java.util.HashSet<FishingEquipment>();
      return fishingEquipment;
   }
   
   public java.util.Iterator getIteratorFishingEquipment() {
      if (fishingEquipment == null)
         fishingEquipment = new java.util.HashSet<FishingEquipment>();
      return fishingEquipment.iterator();
   }

   public void setFishingEquipment(java.util.Set<FishingEquipment> newFishingEquipment) {
      removeAllFishingEquipment();
      for (java.util.Iterator iter = newFishingEquipment.iterator(); iter.hasNext();)
         addFishingEquipment((FishingEquipment)iter.next());
   }
   
   public void addFishingEquipment(FishingEquipment newFishingEquipment) {
      if (newFishingEquipment == null)
         return;
      if (this.fishingEquipment == null)
         this.fishingEquipment = new java.util.HashSet<FishingEquipment>();
      if (!this.fishingEquipment.contains(newFishingEquipment))
         this.fishingEquipment.add(newFishingEquipment);
   }
   
   public void removeFishingEquipment(FishingEquipment oldFishingEquipment) {
      if (oldFishingEquipment == null)
         return;
      if (this.fishingEquipment != null)
         if (this.fishingEquipment.contains(oldFishingEquipment))
            this.fishingEquipment.remove(oldFishingEquipment);
   }
   
   public void removeAllFishingEquipment() {
      if (fishingEquipment != null)
         fishingEquipment.clear();
   }
   public java.util.Collection<ShipPicture> getShipPicture() {
      if (shipPicture == null)
         shipPicture = new java.util.HashSet<ShipPicture>();
      return shipPicture;
   }
   
   public java.util.Iterator getIteratorShipPicture() {
      if (shipPicture == null)
         shipPicture = new java.util.HashSet<ShipPicture>();
      return shipPicture.iterator();
   }
   
   public void setShipPicture(java.util.Collection<ShipPicture> newShipPicture) {
      removeAllShipPicture();
      for (java.util.Iterator iter = newShipPicture.iterator(); iter.hasNext();)
         addShipPicture((ShipPicture)iter.next());
   }
   

   public void addShipPicture(ShipPicture newShipPicture) {
      if (newShipPicture == null)
         return;
      if (this.shipPicture == null)
         this.shipPicture = new java.util.HashSet<ShipPicture>();
      if (!this.shipPicture.contains(newShipPicture))
         this.shipPicture.add(newShipPicture);
   }
   
   public void removeShipPicture(ShipPicture oldShipPicture) {
      if (oldShipPicture == null)
         return;
      if (this.shipPicture != null)
         if (this.shipPicture.contains(oldShipPicture))
            this.shipPicture.remove(oldShipPicture);
   }
   
   public void removeAllShipPicture() {
      if (shipPicture != null)
         shipPicture.clear();
   }
   public java.util.Collection<ShipFastReservation> getShipFastReservation() {
      if (shipFastReservation == null)
         shipFastReservation = new java.util.HashSet<ShipFastReservation>();
      return shipFastReservation;
   }
   
   public java.util.Iterator getIteratorShipFastReservation() {
      if (shipFastReservation == null)
         shipFastReservation = new java.util.HashSet<ShipFastReservation>();
      return shipFastReservation.iterator();
   }
   
 
   public void setShipFastReservation(java.util.Collection<ShipFastReservation> newShipFastReservation) {
      removeAllShipFastReservation();
      for (java.util.Iterator iter = newShipFastReservation.iterator(); iter.hasNext();)
         addShipFastReservation((ShipFastReservation)iter.next());
   }
   
 
   public void addShipFastReservation(ShipFastReservation newShipFastReservation) {
      if (newShipFastReservation == null)
         return;
      if (this.shipFastReservation == null)
         this.shipFastReservation = new java.util.HashSet<ShipFastReservation>();
      if (!this.shipFastReservation.contains(newShipFastReservation))
         this.shipFastReservation.add(newShipFastReservation);
   }
   

   public void removeShipFastReservation(ShipFastReservation oldShipFastReservation) {
      if (oldShipFastReservation == null)
         return;
      if (this.shipFastReservation != null)
         if (this.shipFastReservation.contains(oldShipFastReservation))
            this.shipFastReservation.remove(oldShipFastReservation);
   }
   
   
   public void removeAllShipFastReservation() {
      if (shipFastReservation != null)
         shipFastReservation.clear();
   }

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
      {
         this.shipOption.add(newShipOption);
         newShipOption.setShip(this);      
      }
   }
   

   public void removeShipOption(ShipOption oldShipOption) {
      if (oldShipOption == null)
         return;
      if (this.shipOption != null)
         if (this.shipOption.contains(oldShipOption))
         {
            this.shipOption.remove(oldShipOption);
            oldShipOption.setShip((Ship)null);
         }
   }
   

   public void removeAllShipOption() {
      if (shipOption != null)
      {
         ShipOption oldShipOption;
         for (java.util.Iterator iter = getIteratorShipOption(); iter.hasNext();)
         {
            oldShipOption = (ShipOption)iter.next();
            iter.remove();
            oldShipOption.setShip((Ship)null);
         }
      }
   }

}