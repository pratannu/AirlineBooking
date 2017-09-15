package airline.viewModels;

import airline.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.*;

@Service
public class FlightSearchCriteria {
    private String source;
    private String destination;
    private int numberOfSeats;
    private final int DEFAULT_NUMBER_OF_SEAT = 1;
    private LocalDate departureDate;

    public List getPlaneNames() {
        return planeNames;
    }

    public void setPlaneNames(List planeNames) {
        this.planeNames = planeNames;
    }

    private String travelClass;
    private List planeNames;

       FlightRepository flightRepository;

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public FlightSearchCriteria() {
        this.numberOfSeats = DEFAULT_NUMBER_OF_SEAT;

    }


    public String getDepartureDate() {
        if (departureDate == null)
            return null;
        else
        return departureDate.toString();
    }

    public void setDepartureDate(String departureDate) {
        if( departureDate.equals(""))
                this.departureDate = null;
        else
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


}
