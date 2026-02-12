package src.dao;

import java.util.List;
import java.util.ArrayList;
import src.model.Hotel;

public class HotelDAO {
    private List<Hotel> hotels;
    
    public HotelDAO() {
        hotels = new ArrayList<>();
    }
    
    public List<Hotel> getAll() {
        return new ArrayList<>(hotels);
    }

    public Hotel getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        for (Hotel hotel : hotels) {
            if (hotel.getHotelId().equals(id)) {
                return hotel;
            }
        }
        return null;
    }

    public void save(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }
        hotels.add(hotel);
    }

    public void update(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }

        for (Hotel exsiting : hotels) {
            if (exsiting.getHotelId().equals(hotel.getHotelId())) {
                hotels.remove(exsiting);
                break;
            }
        }
        save(hotel);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (Hotel hotel : hotels) {
            if (hotel.getHotelId().equals(id)) {
                hotels.remove(hotel);
                break;
            }
        }
    }


    public List<Hotel> getByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        List<Hotel> result = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (hotel.getCity().equalsIgnoreCase(city)) {
                result.add(hotel);
            }
        }

        return result;
    }

    public List<Hotel> getByStars(int stars) {
        List<Hotel> result = new ArrayList<>();

        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Stars must be between 1 and 5");
        }
        for (Hotel hotel : hotels) {
            if (hotel.getStarRating() == stars) { 
                result.add(hotel);
            }
        }
        return result;
    }

    public List<Hotel> getByPriceRange(double minPrice, double maxPrice) {

        if (minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Min Price cannot be bigger than Max Price");
        }

        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            double price = hotel.getPricePerNight();

            if (price >= minPrice && price <= maxPrice) {
                result.add(hotel);
            }
        }
        return result;
    }
}
