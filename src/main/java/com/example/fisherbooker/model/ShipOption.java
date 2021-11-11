package com.example.fisherbooker.model;

import java.util.*;

public class ShipOption {
   private String id;
   private String name;
   private String description;
   private int price;
   
   public Ship ship;
   
   
   public Ship getShip() {
      return ship;
   }

   public void setShip(Ship newShip) {
      if (this.ship == null || !this.ship.equals(newShip))
      {
         if (this.ship != null)
         {
            Ship oldShip = this.ship;
            this.ship = null;
            oldShip.removeShipOption(this);
         }
         if (newShip != null)
         {
            this.ship = newShip;
            this.ship.addShipOption(this);
         }
      }
   }

}