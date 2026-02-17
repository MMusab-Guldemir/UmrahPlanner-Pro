package src.service;
import src.dao.BookingDAO;
import java.util.List;

import src.model.Booking;
import src.model.User;

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
            throw new IllegalArgumentException("Booking cannot be null");
        }
        double totalPrice = PriceCalculator.calculateTotalBookingPrice(booking);
        booking.setTotalPrice(totalPrice);
        bookingDAO.save(booking);
    }

    public void updateBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
        if (bookingDAO.getById(booking.getBookingId()) == null) {
            throw new IllegalArgumentException("Booking not found with id: " + booking.getBookingId());
        }
        double totalPrice = PriceCalculator.calculateTotalBookingPrice(booking);
        booking.setTotalPrice(totalPrice);
        bookingDAO.update(booking);
    }

    public void cancelBooking(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be null or empty");
        }
        Booking booking = bookingDAO.getById(id);
        if (booking == null) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }
        
        booking.setStatus("İptal Edildi");
        bookingDAO.update(booking);
        
    }

    public Booking getBookingById(String id) {
        Booking booking = bookingDAO.getById(id);

        if (booking == null) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookingDAO.getByUser(userId);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingDAO.getByStatus(status);
    }

    public List<Booking> getBookingsByDateRange(LocalDate start, LocalDate end) {
        return bookingDAO.getByDateRange(start, end);
    }

    public void confirmBooking(String id) {
        Booking booking = bookingDAO.getById(id);

        if (booking == null) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        } 

        if (!booking.getStatus().equals("Beklemede")) {
            throw new IllegalArgumentException("Only pending bookings can be confirmed");
        }

        booking.setStatus("Onaylandı");
        bookingDAO.update(booking);
    }

    public int getBookingCount() {
        return bookingDAO.getAll().size();
    }

    public double calculateBookingWithDiscount(Booking booking, User user) {
        double totalPrice = PriceCalculator.calculateTotalBookingPrice(booking);
        return PriceCalculator.applyDiscount(totalPrice, user);
    }



}
