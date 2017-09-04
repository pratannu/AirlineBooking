package airline.repositories;

import airline.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("F1", "HYD", "BLR",120, LocalDate.now());
        Flight flight2 = new Flight("F2", "HYD", "PUN",150, LocalDate.of(2017, Month.OCTOBER,20) );
        Flight flight3 = new Flight("F3", "BLR", "PUN",30, LocalDate.of(2017, Month.SEPTEMBER,4));
        Flight flight4 = new Flight("F4", "HYD", "BLR",10, LocalDate.of(2017, Month.MAY,15));


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }
}
