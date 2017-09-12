package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.repositories.CityRepository;
import airline.repositories.FlightRepository;
import airline.services.FlightSearchService;
import airline.viewModels.FlightSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import airline.model.AirPlane;

import java.util.*;


@Controller

public class FlightSearchController {
    CityRepository cityRepository;
    Flight flight;
    AirPlane airplane;

    @Autowired
    FlightSearchCriteria flightSearchCriteria;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCities(Model model) {
        cityRepository = new CityRepository();
        airplane = new AirPlane();
        flight = new Flight();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("travelclass", Arrays.asList(TravelClass.values()));
        model.addAttribute("airplane", Arrays.asList(new AirPlane().getPlaneName()));
        model.addAttribute("searchCriteria", new FlightSearchCriteria());
        return "FlightSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria") FlightSearchCriteria searchCriteria, Model model) {
        FlightSearchService flightSearch = new FlightSearchService(searchCriteria);
        List<Flight> availableFlights = flightSearch.search();
        model.addAttribute("searchResults",availableFlights);
        model.addAttribute("searchCriteria", searchCriteria);
        return "FlightsList";
    }

}
