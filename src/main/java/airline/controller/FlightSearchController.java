package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.repositories.CityRepository;
import airline.services.FlightSearchService;
import airline.viewModels.FlightSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller

public class FlightSearchController {
    CityRepository cityRepository;
    @Autowired
    FlightSearchCriteria flightSearchCriteria;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCities(Model model) {
        cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new FlightSearchCriteria());
        return "FlightSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria") FlightSearchCriteria searchCriteria, Model model) {
        FlightSearchService flightSearch = new FlightSearchService(searchCriteria);
        List<Flight> availableFlights = flightSearch.search();
        model.addAttribute("searchResults",availableFlights);
        return "FlightsList";
    }

}
