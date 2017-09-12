package airline.repositories;

import airline.model.Flight;
import airline.model.TravelClass;
import airline.model.AirPlane;
import java.time.LocalDate;
import java.time.Month;

import java.util.*;

public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();
    public ArrayList<AirPlane> planeNames;
   // private ArrayList<AirPlane> list1;

    public ArrayList<Flight> getFlights() {
       // AirPlane airplane= new AirPlane();
       // airplane.addPlaneNames();


      // planeNames = airplane.addPlaneNames();
       // planeNames.subList(0,3);

        AirPlaneRepository airPlaneRepository = new AirPlaneRepository();
       // System.out.println("I am trying" + airPlaneRepository.getPlaneName("Boeing 787"));

        Flight flight1 = new Flight("F1", "HYD", "BLR", LocalDate.now(), 120, 20, 10, airPlaneRepository.getPlaneName("Boeing 787"));
        Flight flight2 = new Flight("F2", "HYD", "PUN",LocalDate.of(2017, Month.OCTOBER,20), 200, 50, 10, airPlaneRepository.getPlaneName("AirBus 310"));
        Flight flight3 = new Flight("F3", "BLR", "PUN", LocalDate.of(2017, Month.SEPTEMBER,4), 150, 100, 20,airPlaneRepository.getPlaneName("Lockheed Constellation"));
        Flight flight4 = new Flight("F4", "HYD", "BLR", LocalDate.of(2017, Month.MAY,15), 60, 20, 5, airPlaneRepository.getPlaneName("Bristol Brabazon"));


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;

    }
}
