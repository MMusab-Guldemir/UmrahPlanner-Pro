package src.service;
import src.model.Flight;
import java.util.List;
import src.dao.FlightDAO;;
public class FlightService {
    private FlightDAO flightDAO;

    public FlightService() {
        this.flightDAO = new FlightDAO();
    }
}
