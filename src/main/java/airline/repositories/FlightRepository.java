package airline.repositories;

import airline.model.Flight;
import airline.model.TravelClass;

import java.time.LocalDate;
import java.time.Month;

import java.util.*;

public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("F1", "HYD", "BLR", LocalDate.now(), 120, 20, 10);
        Flight flight2 = new Flight("F2", "HYD", "PUN",LocalDate.of(2017, Month.OCTOBER,20), 200, 50, 10);
        Flight flight3 = new Flight("F3", "BLR", "PUN", LocalDate.of(2017, Month.SEPTEMBER,4), 150, 100, 20);
        Flight flight4 = new Flight("F4", "HYD", "BLR", LocalDate.of(2017, Month.MAY,15), 60, 20, 5);


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;

    }
}
