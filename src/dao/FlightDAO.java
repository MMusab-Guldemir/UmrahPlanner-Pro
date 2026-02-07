package src.dao;

import src.model.Flight;
import java.util.List;
import java.lang.classfile.attribute.PermittedSubclassesAttribute;
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

    public void update(Flight flight)

        
}
