package airline.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import airline.model.AirPlane;



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
                  int economySeats, int firstClassSeats, int businessClassSeats, AirPlane planeNames
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
        //this.economyPrice = economyPrice;
        //this.firstPrice = firstPrice;
        //this.businessPrice = businessPrice;
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

    public double calculatePrice(String travelclass, int numberOfSeats){
        double totalPrice = 0;
        switch (travelclass) {
            case "ECONOMY":
                totalPrice = this.airplane.getEconomyPrice() * numberOfSeats;
                break;
            case "FIRST":
                totalPrice = this.airplane.getFirstPrice() * numberOfSeats;
                break;
            case "BUSINESS":
                totalPrice = this.airplane.getBusinessPrice() * numberOfSeats;
                break;
        };
        return totalPrice;
    }
}
