package src.dao;

import java.util.ArrayList;
import java.util.List;
import src.model.Booking;


public class BookingDAO {
    private List<Booking> Bookings;
    
    public BookingDAO() {
        this.Bookings = new ArrayList<>();
    }

    public List<Booking> getAll() {
        return new ArrayList<>(Bookings);
    }

    public Booking getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (Booking booking : Bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    public void save(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("");
        }
        Bookings.add(booking);
    }

    public void update(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("");
        }

        for (Booking existing : Bookings) {
            if (existing.getBookingId().equals(booking.getBookingId())) {
                Bookings.remove(booking);
                break;
            }
        }
        save(booking);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }
        
        for (Booking booking : Bookings) {
            if (booking.getBookingId().equals(id)) {
                Bookings.remove(booking);
                break;
            }
        }
    }
}
