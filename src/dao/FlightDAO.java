package src.dao;

import src.model.Flight;
import java.util.List;
import java.util.ArrayList;


public class FlightDAO {
    private List<Flight> flights;

    public FlightDAO() {
        this.flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Flight> getAll() {
        return new ArrayList<>(flights);
    }

    public Flight getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(id)) {
                return flight;
            } 
        }
        return null;
    }

    public void save(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        flights.add(flight);
    }

    public void update(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }

        for (Flight flight1 : flights) {
            if (flight1.getFlightId().equals(flight.getFlightId())) {
                flights.remove(flight1);
                break;
            }
        }
        save(flight);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (Flight flight : flights) {
            if (flight.getFlightId().equals(id)) {
                flights.remove(flight);
                break;
            }
        }
    }

    public List<Flight> getByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDepartureCity().equals(city)) {
                result.add(flight);
            }
        }

        return result;
    }

    public List<Flight> getByAirline(String airline) {
        if (airline == null || airline.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline cannot be null or empty");
        }

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getAirline().equals(airline)) {
                result.add(flight);
            }
        }
        return result;
    } 

    public List<Flight> getByPriceRange(double min, double max) {
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Invalid price range");
        }

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getPrice() >= min && flight.getPrice() <= max) {
                result.add(flight);
            }
        }
        return result;
    }
}