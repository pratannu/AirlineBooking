package airline.model;

import java.util.ArrayList;
import java.util.List;

public class AirPlane {
   private String planeName;
   private double economyPrice;
   private double firstPrice;
   private double businessPrice;

   public AirPlane(){

   }

   public AirPlane(String planeName, double economyPrice, double firstPrice, double businessPrice){
       this.planeName = planeName;
       this.economyPrice = economyPrice;
       this.firstPrice=firstPrice;
       this.businessPrice=businessPrice;


   }



    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

        public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;

    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }
    public String getPlaneName() {
        return planeName;
    }
    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }



}
