package airline.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private int economySeats;
    private int firstClassSeats;
    private int businessClassSeats;

    public Flight() {}

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Flight(String flightNumber, String source, String destination, LocalDate departureDate, int economySeats, int firstClassSeats, int businessClassSeats){
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.economySeats = economySeats;
        this.businessClassSeats = businessClassSeats;
        this.firstClassSeats = firstClassSeats;
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
}
