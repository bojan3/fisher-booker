package com.example.fisherbooker.model;

import java.util.*;

/** @pdOid 717d2415-39e6-4c1b-84f1-2c26c52fb35e */
public class FishingInstructor {
   /** @pdOid 54096376-0f6d-4fee-bdd1-e7bc45842bc1 */
   private String biography;
   
   /** @pdRoleInfo migr=no name=Account assc=association18 mult=1..1 */
   public Account account;
   /** @pdRoleInfo migr=no name=Adventure assc=association27 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   public java.util.Set<Adventure> adventure;
   
   
   /** @pdGenerated default getter */
   public java.util.Set<Adventure> getAdventure() {
      if (adventure == null)
         adventure = new java.util.HashSet<Adventure>();
      return adventure;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdventure() {
      if (adventure == null)
         adventure = new java.util.HashSet<Adventure>();
      return adventure.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdventure */
   public void setAdventure(java.util.Set<Adventure> newAdventure) {
      removeAllAdventure();
      for (java.util.Iterator iter = newAdventure.iterator(); iter.hasNext();)
         addAdventure((Adventure)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdventure */
   public void addAdventure(Adventure newAdventure) {
      if (newAdventure == null)
         return;
      if (this.adventure == null)
         this.adventure = new java.util.HashSet<Adventure>();
      if (!this.adventure.contains(newAdventure))
      {
         this.adventure.add(newAdventure);
         newAdventure.setFishingInstructor(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAdventure */
   public void removeAdventure(Adventure oldAdventure) {
      if (oldAdventure == null)
         return;
      if (this.adventure != null)
         if (this.adventure.contains(oldAdventure))
         {
            this.adventure.remove(oldAdventure);
            oldAdventure.setFishingInstructor((FishingInstructor)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdventure() {
      if (adventure != null)
      {
         Adventure oldAdventure;
         for (java.util.Iterator iter = getIteratorAdventure(); iter.hasNext();)
         {
            oldAdventure = (Adventure)iter.next();
            iter.remove();
            oldAdventure.setFishingInstructor((FishingInstructor)null);
         }
      }
   }

}