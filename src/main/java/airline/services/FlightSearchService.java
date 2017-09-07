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
    private String travelclass;

    public FlightSearchService(FlightSearchCriteria flightSearchCriteria) {
        this.source = flightSearchCriteria.getSource();
        this.destination = flightSearchCriteria.getDestination();
        this.numberOfSeats = flightSearchCriteria.getNumberOfSeats();
        if( flightSearchCriteria.getDepartureDate() == null)
            this.departureDate = null;
        else
             this.departureDate = LocalDate.parse(flightSearchCriteria.getDepartureDate());
        this.travelclass = flightSearchCriteria.getTravelclass();
    }

    private boolean compareRoute(Flight flight){
        return source.equals(flight.getSource()) && destination.equals(flight.getDestination());
    }

    private boolean checkSeatAvailability(Flight flight){
        return flight.getSeatsByTravelClass(travelclass) >= numberOfSeats;
    }

    private boolean checkDepartureDate(Flight flight){
        if(departureDate == null)
            return true;
        else
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
