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

    public Flight getById(String Id) {
        if (Id == null || Id.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(Id)) {
                return flight;
            } 
        }
        return null;
    }

    public void save(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException();
        }
        flights.add(flight);
    }

    public void update(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException();
        }

        for (Flight flight1 : flights) {
            if (flight1.getFlightId().equals(flight.getFlightId())) {
                flights.remove(flight1);
                break;
            }
        }
        save(flight);
    }

    public void delete(Flight flightId) {
        if (flightId == null) {
            throw new IllegalArgumentException();
        }
        flights.remove(flightId);
    }



        
}
