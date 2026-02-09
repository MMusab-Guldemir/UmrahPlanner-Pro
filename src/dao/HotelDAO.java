package src.dao;

import java.util.List;
import java.util.ArrayList;
import src.model.Hotel;

public class HotelDAO {
    List<Hotel> hotels;
    
    public HotelDAO() {
        hotels = new ArrayList<>();
    }
    
    public List<Hotel> getAll() {
        return new ArrayList<>(hotels);
    }

    public Hotel getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException()
        }
        for (Hotel hotel : hotels) {
            if (hotel.getHotelId().equals(id)) {
                return hotel;
            }
        }
        return null;
    }
}
