package src.service;
import src.dao.BookingDAO;
import java.util.List;
import src.model.Booking;
import java.time.LocalDate;
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

    public void createBooking(Booking booking) {
        if (booking == null)  {
            throw new IllegalArgumentException();
        }
        PriceCalculator.calculateTotalBookingPrice(booking);
        booking.setTotalPrice(booking.getTotalPrice());
        bookingDAO.save(booking);
    }

    public void updateBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException();
        }
        if (bookingDAO.getById(booking.getBookingId()) == null) {
            throw new IllegalArgumentException();
        }

        booking.setTotalPrice(booking.getTotalPrice());
        bookingDAO.update(booking);
    }

}
