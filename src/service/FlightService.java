package src.service;
import src.model.Flight;

import java.util.ArrayList;
import java.util.List;
import src.dao.FlightDAO;

public class FlightService {
    private FlightDAO flightDAO;

    public FlightService() {
        this.flightDAO = new FlightDAO();
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        flightDAO.save(flight);
    }

    public void updateFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        if (flightDAO.getById(flight.getFlightId()) == null) {
            throw new IllegalArgumentException("Flight not found with id: " + flight.getFlightId());
        }
        flightDAO.update(flight);
    } 

    public void deleteFlight(String id ){
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight ID cannot be null or empty");
        }
        Flight existing = flightDAO.getById(id);
        if (existing == null) {
            throw new IllegalArgumentException("Flight not found with id: " + id);
        }

        flightDAO.delete(id);
    }

    public List<Flight> getAllflights() {
        return flightDAO.getAll();
    }

    public Flight getById(String id) {
        Flight existing = flightDAO.getById(id);
        if (existing == null) {
            throw new IllegalArgumentException("Flight not found with id: " + id);
        }
        return existing;
    }

    public List<Flight> findByCity(String city) {
        return flightDAO.getByCity(city);
    }

    public List<Flight> findByAirline(String airline) {
        return flightDAO.getByAirline(airline);
    }

    public List<Flight> findByPriceRange(double min, double max) {
        return flightDAO.getByPriceRange(min, max);
    }
     
    public int getFlightCount() {
        return flightDAO.getAll().size();
    }

    public List<Flight> getAvailableFlights() {
        List<Flight> allFlights = flightDAO.getAll();
        List<Flight> result = new ArrayList<>();

        for (Flight flight : allFlights) {
            if (flight.getAvailableSeats() > 0) {
                result.add(flight);
            }
        }
        return result;
    }
}
