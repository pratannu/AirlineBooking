package airline.model;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;

import airline.model.AirPlane;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.WEEKS;


public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private int economySeats;
    private int firstClassSeats;
    private int businessClassSeats;
    private double economyPrice;
    private double firstPrice;
    private double businessPrice;
    private AirPlane plane;

    public AirPlane airplane;
    private int bookedSeats;
    private int availableEconomySeats;
    private int availableFirstSeats;
    private int availableBusinessSeats;


    public Flight() {}

   /* public ArrayList<AirPlane> getPlaneNames() {
        return planeNames;
    }

    public void setPlaneNames(ArrayList<AirPlane> planeNames) {
        this.planeNames = planeNames;
    }*/

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Flight(String flightNumber, String source, String destination, LocalDate departureDate,
                  int economySeats,int availableEconomySeats, int firstClassSeats,int availableFirstSeats, int businessClassSeats, int availableBusinessSeats,   AirPlane planeNames
                  ){
        airplane = new AirPlane();
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.economySeats = economySeats;
        this.businessClassSeats = businessClassSeats;
        this.firstClassSeats = firstClassSeats;
        this.airplane = planeNames;
        this.availableEconomySeats = availableEconomySeats;
        this.availableFirstSeats = availableFirstSeats;
        this.availableBusinessSeats = availableBusinessSeats;

    }

    public int getEconomySeats() { return economySeats; }

    public int getFirstClassSeats() { return firstClassSeats; }

    public int getBusinessClassSeats() { return businessClassSeats; }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public int getSeatsByTravelClass(String travelclass){
        int availableSeats = 0;
        switch (travelclass) {
            case "ECONOMY":
                availableSeats = economySeats;
                break;
            case "FIRST":
                availableSeats = firstClassSeats;
                break;
            case "BUSINESS":
                availableSeats = businessClassSeats;
                break;
        };
        return availableSeats;
    }

    public double calculatePrice(String travelClass, int numberOfSeats){
        double totalPrice = 0;
        switch (travelClass) {
            case "ECONOMY":
                totalPrice = CalculateTotalEconomyPrice(this.airplane.getEconomyPrice());
                totalPrice = totalPrice * numberOfSeats;
                break;
            case "FIRST":
                totalPrice = CalculateTotalFirstPrice(this.airplane.getFirstPrice()) ;
                totalPrice = totalPrice * numberOfSeats;
                break;
            case "BUSINESS":
                totalPrice = CalculateTotalBusinessPrice(this.airplane.getBusinessPrice());
                totalPrice = totalPrice * numberOfSeats;
                break;
        };
        return totalPrice;
    }

    public double CalculateTotalEconomyPrice(double economyPrice){
        double economyHikedPrice =0;


        bookedSeats = economySeats - availableEconomySeats;
        if(bookedSeats <=  economySeats * 0.4 ) {
            economyHikedPrice = economyPrice;

        }
        else if((((bookedSeats) >= (economySeats * 0.4)) && ((bookedSeats)<=((economySeats * 0.4) +(economySeats *0.5))))){
             economyHikedPrice = (economyPrice * 0.3) + economyPrice;
            }
        else if((bookedSeats) >= ((economySeats* 0.4) + (economySeats * 0.5)) && ((bookedSeats) <= ((economySeats * 0.4) + (economySeats * 0.5) + (economySeats * 0.1)))){
             economyHikedPrice = (economyPrice * 0.6) + economyPrice;
        }

             return economyHikedPrice;
    }



       public double CalculateTotalBusinessPrice(double businessPrice){
         double businessPriceByWeekDay = 0;

         DayOfWeek day = departureDate.getDayOfWeek();
          if ((day.equals(DayOfWeek.MONDAY)) || (day.equals(DayOfWeek.FRIDAY))||(day.equals(DayOfWeek.SUNDAY))){
              businessPriceByWeekDay = (businessPrice * 0.4) + businessPrice;

           }
           else
               businessPriceByWeekDay = businessPrice;
           return businessPriceByWeekDay;

       }

       public double CalculateTotalFirstPrice(double firstPrice){
           double firstPriceCalculationTenDaysPrevious =0;
           LocalDate date = LocalDate.now();

          long noOfDays= DAYS.between(date, departureDate);

          if (noOfDays <= 10){
              firstPriceCalculationTenDaysPrevious = ((10 - noOfDays )  * (firstPrice * 0.1)) + firstPrice;

          }
          return firstPriceCalculationTenDaysPrevious;

       }

       public boolean checkIsOpen(String travelClass, LocalDate departureDate){
           boolean isOpen = false;
           LocalDate currentDate = LocalDate.now();

          if(travelClass.equals("BUSINESS")) {
              long noOfWeeks = WEEKS.between(currentDate, departureDate);


              if (noOfWeeks < 4) {
                  isOpen = true;
              }

          }
          else if(travelClass.equals("FIRST")){

          }
              long noOfDays= DAYS.between(currentDate, departureDate);

              if (noOfDays <= 10){
                  isOpen = true;
          }
           return isOpen;
       }
}

