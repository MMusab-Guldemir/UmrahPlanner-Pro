package src.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.model.Booking;


public class BookingDAO {
    private List<Booking> bookings;
    
    public BookingDAO() {
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getAll() {
        return new ArrayList<>(bookings);
    }

    public Booking getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    public void save(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
        bookings.add(booking);
    }

    public void update(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }

        for (Booking existing : bookings) {
            if (existing.getBookingId().equals(booking.getBookingId())) {
                bookings.remove(existing);
                break;
            }
        }
        save(booking);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                bookings.remove(booking);
                break;
            }
        }
    }

    public List<Booking> getByUser(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        } 

        List<Booking> result = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getUser().getUserId().equalsIgnoreCase(userId)) {
                result.add(booking);
            }
        }
        return result;
    }

    public List<Booking> getByStatus(String status) {
        if (status == null || status.trim().isEmpty()){
            throw new IllegalArgumentException("Status cannot be null or empty");
        }

        for (Booking booking : bookings) {
            if (booking.getStatus().equalsIgnoreCase(status)) {

            }
        }
        return null;
    }

    public List getByDateRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("End date cannot be null");
        }

        List<Booking> result = new ArrayList<>();
        
        for (Booking booking : bookings) {
            LocalDate travelDate = booking.getTravelDate();

            if (!travelDate.isBefore(start) && !travelDate.isAfter(end)) {
                throw new IllegalArgumentException("Start date cannot be after end date");
            }
            result.add(booking);
        }

        return null;
    }


}
