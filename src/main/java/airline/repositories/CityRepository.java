package airline.repositories;

import airline.model.City;
import org.springframework.stereotype.Service;

import java.util.*;


public class CityRepository {
    public List<City> getCities() {
        List<City> cities = new ArrayList<City>();
        cities.add(new City("HYD", "Hyderabad"));
        cities.add(new City("BLR", "Bengaluru"));
        cities.add(new City("PUN", "Pune"));
        return cities;
    }


}
