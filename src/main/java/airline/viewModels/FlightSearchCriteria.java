package airline.viewModels;

import airline.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;

@Service
public class FlightSearchCriteria {
    private String source;
    private String destination;
    private int numberOfSeats;
    private final int DEFAULT_NUMBER_OF_SEAT = 1;
    private LocalDate departureDate;
    private String travelclass;

       FlightRepository flightRepository;

    public FlightSearchCriteria() {
        this.numberOfSeats = DEFAULT_NUMBER_OF_SEAT;
//        this.departureDate =   LocalDate.now();
        //this.travelclass = travelclass;
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

    public String getTravelclass() {
        return travelclass;
    }

    public void setTravelclass(String travelclass) {
        this.travelclass = travelclass;
    }
}
