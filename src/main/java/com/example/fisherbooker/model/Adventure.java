package com.example.fisherbooker.model;

import java.util.*;

public class Adventure {
   private int id;
   private int name;
   private int description;
   private int capacity;
   private int price;
   private int cancelRate;
   
   public java.util.Set<FishingOption> fishingOption;
   public java.util.Collection<Address> address;
   public java.util.Set<AdventurePicture> adventurePicture;
   public java.util.Set<AdventureFastReservation> adventureFastReservation;
   public java.util.Set<Rule> rule;
   public java.util.Set<AdventureReservation> adventureReservation;
   public FishingInstructor fishingInstructor;
   
   
   public java.util.Set<FishingOption> getFishingOption() {
      if (fishingOption == null)
         fishingOption = new java.util.HashSet<FishingOption>();
      return fishingOption;
   }
   
   public java.util.Iterator getIteratorFishingOption() {
      if (fishingOption == null)
         fishingOption = new java.util.HashSet<FishingOption>();
      return fishingOption.iterator();
   }
   
   public void setFishingOption(java.util.Set<FishingOption> newFishingOption) {
      removeAllFishingOption();
      for (java.util.Iterator iter = newFishingOption.iterator(); iter.hasNext();)
         addFishingOption((FishingOption)iter.next());
   }
   
   public void addFishingOption(FishingOption newFishingOption) {
      if (newFishingOption == null)
         return;
      if (this.fishingOption == null)
         this.fishingOption = new java.util.HashSet<FishingOption>();
      if (!this.fishingOption.contains(newFishingOption))
         this.fishingOption.add(newFishingOption);
   }
   
   public void removeFishingOption(FishingOption oldFishingOption) {
      if (oldFishingOption == null)
         return;
      if (this.fishingOption != null)
         if (this.fishingOption.contains(oldFishingOption))
            this.fishingOption.remove(oldFishingOption);
   }
   
   public void removeAllFishingOption() {
      if (fishingOption != null)
         fishingOption.clear();
   }
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

   public java.util.Set<AdventurePicture> getAdventurePicture() {
      if (adventurePicture == null)
         adventurePicture = new java.util.HashSet<AdventurePicture>();
      return adventurePicture;
   }
   
  
   public java.util.Iterator getIteratorAdventurePicture() {
      if (adventurePicture == null)
         adventurePicture = new java.util.HashSet<AdventurePicture>();
      return adventurePicture.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdventurePicture */
   public void setAdventurePicture(java.util.Set<AdventurePicture> newAdventurePicture) {
      removeAllAdventurePicture();
      for (java.util.Iterator iter = newAdventurePicture.iterator(); iter.hasNext();)
         addAdventurePicture((AdventurePicture)iter.next());
   }
   
 
   public void addAdventurePicture(AdventurePicture newAdventurePicture) {
      if (newAdventurePicture == null)
         return;
      if (this.adventurePicture == null)
         this.adventurePicture = new java.util.HashSet<AdventurePicture>();
      if (!this.adventurePicture.contains(newAdventurePicture))
         this.adventurePicture.add(newAdventurePicture);
   }
   
   
   public void removeAdventurePicture(AdventurePicture oldAdventurePicture) {
      if (oldAdventurePicture == null)
         return;
      if (this.adventurePicture != null)
         if (this.adventurePicture.contains(oldAdventurePicture))
            this.adventurePicture.remove(oldAdventurePicture);
   }
   

   public void removeAllAdventurePicture() {
      if (adventurePicture != null)
         adventurePicture.clear();
   }
   public java.util.Set<AdventureFastReservation> getAdventureFastReservation() {
      if (adventureFastReservation == null)
         adventureFastReservation = new java.util.HashSet<AdventureFastReservation>();
      return adventureFastReservation;
   }
   
   public java.util.Iterator getIteratorAdventureFastReservation() {
      if (adventureFastReservation == null)
         adventureFastReservation = new java.util.HashSet<AdventureFastReservation>();
      return adventureFastReservation.iterator();
   }
   

   public void setAdventureFastReservation(java.util.Set<AdventureFastReservation> newAdventureFastReservation) {
      removeAllAdventureFastReservation();
      for (java.util.Iterator iter = newAdventureFastReservation.iterator(); iter.hasNext();)
         addAdventureFastReservation((AdventureFastReservation)iter.next());
   }
   
  
   public void addAdventureFastReservation(AdventureFastReservation newAdventureFastReservation) {
      if (newAdventureFastReservation == null)
         return;
      if (this.adventureFastReservation == null)
         this.adventureFastReservation = new java.util.HashSet<AdventureFastReservation>();
      if (!this.adventureFastReservation.contains(newAdventureFastReservation))
         this.adventureFastReservation.add(newAdventureFastReservation);
   }
   
   
   public void removeAdventureFastReservation(AdventureFastReservation oldAdventureFastReservation) {
      if (oldAdventureFastReservation == null)
         return;
      if (this.adventureFastReservation != null)
         if (this.adventureFastReservation.contains(oldAdventureFastReservation))
            this.adventureFastReservation.remove(oldAdventureFastReservation);
   }
   
   
   public void removeAllAdventureFastReservation() {
      if (adventureFastReservation != null)
         adventureFastReservation.clear();
   }

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
   
   public java.util.Set<AdventureReservation> getAdventureReservation() {
      if (adventureReservation == null)
         adventureReservation = new java.util.HashSet<AdventureReservation>();
      return adventureReservation;
   }
   
  
   public java.util.Iterator getIteratorAdventureReservation() {
      if (adventureReservation == null)
         adventureReservation = new java.util.HashSet<AdventureReservation>();
      return adventureReservation.iterator();
   }
   
   
   public void setAdventureReservation(java.util.Set<AdventureReservation> newAdventureReservation) {
      removeAllAdventureReservation();
      for (java.util.Iterator iter = newAdventureReservation.iterator(); iter.hasNext();)
         addAdventureReservation((AdventureReservation)iter.next());
   }
   
   
   public void addAdventureReservation(AdventureReservation newAdventureReservation) {
      if (newAdventureReservation == null)
         return;
      if (this.adventureReservation == null)
         this.adventureReservation = new java.util.HashSet<AdventureReservation>();
      if (!this.adventureReservation.contains(newAdventureReservation))
         this.adventureReservation.add(newAdventureReservation);
   }
   
  
   public void removeAdventureReservation(AdventureReservation oldAdventureReservation) {
      if (oldAdventureReservation == null)
         return;
      if (this.adventureReservation != null)
         if (this.adventureReservation.contains(oldAdventureReservation))
            this.adventureReservation.remove(oldAdventureReservation);
   }
   
 
   public void removeAllAdventureReservation() {
      if (adventureReservation != null)
         adventureReservation.clear();
   }

   public FishingInstructor getFishingInstructor() {
      return fishingInstructor;
   }
   
   
   public void setFishingInstructor(FishingInstructor newFishingInstructor) {
      if (this.fishingInstructor == null || !this.fishingInstructor.equals(newFishingInstructor))
      {
         if (this.fishingInstructor != null)
         {
            FishingInstructor oldFishingInstructor = this.fishingInstructor;
            this.fishingInstructor = null;
            oldFishingInstructor.removeAdventure(this);
         }
         if (newFishingInstructor != null)
         {
            this.fishingInstructor = newFishingInstructor;
            this.fishingInstructor.addAdventure(this);
         }
      }
   }

}