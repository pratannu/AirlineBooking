package airline.repositories;

import airline.model.Flight;
import airline.model.AirPlane;
import java.time.LocalDate;
import java.time.Month;

import java.util.*;

public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();
    public ArrayList<AirPlane> planeNames;


    public ArrayList<Flight> getFlights() {


        AirPlaneRepository airPlaneRepository = new AirPlaneRepository();


        Flight flight1 = new Flight("F1", "HYD", "BLR", LocalDate.now(), 100, 3, 20,7 ,10,5, airPlaneRepository.getPlaneName("Boeing 787"));
        Flight flight2 = new Flight("F2", "HYD", "PUN",LocalDate.of(2017, Month.SEPTEMBER,17), 195, 100, 50,20,  10,4, airPlaneRepository.getPlaneName("AirBus 310"));
        Flight flight3 = new Flight("F3", "BLR", "PUN", LocalDate.of(2017, Month.SEPTEMBER,30), 150,9, 100,40, 20,13,airPlaneRepository.getPlaneName("Lockheed Constellation"));
        Flight flight4 = new Flight("F4", "HYD", "BLR", LocalDate.of(2017, Month.DECEMBER,15), 60, 30, 20, 11, 5,2, airPlaneRepository.getPlaneName("Bristol Brabazon"));


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;

    }
}
