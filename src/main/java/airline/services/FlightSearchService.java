package airline.services;

import airline.model.Flight;
import airline.repositories.FlightRepository;
import airline.viewModels.FlightSearchCriteria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightSearchService {
    private String source;
    private String destination;
    private LocalDate departureDate;
    private int numberOfSeats;

    public FlightSearchService(FlightSearchCriteria flightSearchCriteria) {
        this.source = flightSearchCriteria.getSource();
        this.destination = flightSearchCriteria.getDestination();
        this.numberOfSeats = flightSearchCriteria.getNumberOfSeats();
        this.departureDate = LocalDate.parse(flightSearchCriteria.getDepartureDate());
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
        FlightRepository flightRepository = new FlightRepository();
        List<Flight> availableFlights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.getFlights()) {
            if (compareRoute(flight) && checkSeatAvailability(flight) && checkDepartureDate(flight))
                availableFlights.add(flight);
        }
        return availableFlights;
    }

}
