package com.example.fisherbooker.model;

import java.util.*;

public class CottageOwner {
   public java.util.Collection<Cottage> cottage;
   public java.util.Set<Account> account;
   
   
   public java.util.Collection<Cottage> getCottage() {
      if (cottage == null)
         cottage = new java.util.HashSet<Cottage>();
      return cottage;
   }
   
   public java.util.Iterator getIteratorCottage() {
      if (cottage == null)
         cottage = new java.util.HashSet<Cottage>();
      return cottage.iterator();
   }
   
  
   public void setCottage(java.util.Collection<Cottage> newCottage) {
      removeAllCottage();
      for (java.util.Iterator iter = newCottage.iterator(); iter.hasNext();)
         addCottage((Cottage)iter.next());
   }
   
   
   public void addCottage(Cottage newCottage) {
      if (newCottage == null)
         return;
      if (this.cottage == null)
         this.cottage = new java.util.HashSet<Cottage>();
      if (!this.cottage.contains(newCottage))
         this.cottage.add(newCottage);
   }
   
 
   public void removeCottage(Cottage oldCottage) {
      if (oldCottage == null)
         return;
      if (this.cottage != null)
         if (this.cottage.contains(oldCottage))
            this.cottage.remove(oldCottage);
   }
   
  
   public void removeAllCottage() {
      if (cottage != null)
         cottage.clear();
   }
  
   public java.util.Set<Account> getAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account;
   }
   
  
   public java.util.Iterator getIteratorAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account.iterator();
   }
   
  
   public void setAccount(java.util.Set<Account> newAccount) {
      removeAllAccount();
      for (java.util.Iterator iter = newAccount.iterator(); iter.hasNext();)
         addAccount((Account)iter.next());
   }
   
  
   public void addAccount(Account newAccount) {
      if (newAccount == null)
         return;
      if (this.account == null)
         this.account = new java.util.HashSet<Account>();
      if (!this.account.contains(newAccount))
         this.account.add(newAccount);
   }
   
   public void removeAccount(Account oldAccount) {
      if (oldAccount == null)
         return;
      if (this.account != null)
         if (this.account.contains(oldAccount))
            this.account.remove(oldAccount);
   }
   

   public void removeAllAccount() {
      if (account != null)
         account.clear();
   }

}