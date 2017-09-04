package airline.services;

import airline.model.Flight;
import airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    private String source;
    private String destination;
    private int numberOfSeats;
    private final int DEFAULT_NUMBER_OF_SEAT = 1;
    private LocalDate departureDate;


    FlightRepository flightRepository;

    public FlightSearchService() {
        this.numberOfSeats = DEFAULT_NUMBER_OF_SEAT;
        this.departureDate = LocalDate.now();
    }

    public String getDepartureDate() {
        return departureDate.toString();
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = LocalDate.parse(departureDate);
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    private boolean compareRoute(Flight flight){
        return source.equals(flight.getSource()) && destination.equals(flight.getDestination());
    }

    private boolean checkSeatAvailability(Flight flight){
        return flight.getAvailableSeats()>=numberOfSeats;
    }

    private boolean checkDepartureDate(Flight flight){
        return departureDate.isEqual(flight.getDepartureDate());
    }
    public List<Flight> search() {
        flightRepository = new FlightRepository();
        List<Flight> availableFlights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.getFlights()) {
            if (compareRoute(flight) && checkSeatAvailability(flight) && checkDepartureDate(flight))
                availableFlights.add(flight);
        }
        return availableFlights;
    }

}
