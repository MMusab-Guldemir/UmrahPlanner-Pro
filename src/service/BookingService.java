package src.service;
import src.dao.BookingDAO;

public class BookingService {
    private BookingDAO bookingDAO;
    private UserService userService;
    private HotelService hotelService;
    private FlightService flightService;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
        this.userService = new UserService();
        this.hotelService = new HotelService();
        this.flightService = new FlightService();
    }

}
