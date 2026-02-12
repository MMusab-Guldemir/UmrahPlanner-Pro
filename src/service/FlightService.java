package src.service;
import src.model.Flight;
import java.util.List;

import src.dao.FlightDAO;;
public class FlightService {
    private FlightDAO flightDAO;

    public FlightService() {
        this.flightDAO = new FlightDAO();
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException();
        }
        flightDAO.save(flight);
    }

    public void updateFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException();
        }
        if (flightDAO.getById(flight.getFlightId()) == null) {
            throw new IllegalArgumentException();
        }
        flightDAO.update(flight);
    } 

    public void deleteFlight(String id ){
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        Flight existing = flightDAO.getById(id);
        if (existing == null) {
            throw new IllegalArgumentException();
        }

        flightDAO.delete(id);
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAll();
    }
}
