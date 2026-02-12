package src.service;
import src.model.Hotel;
import src.dao.HotelDAO;
import java.util.List;


public class HotelService {
    private HotelDAO hotelDAO;

    public HotelService() {
        this.hotelDAO = new HotelDAO();
    }

    public void addHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("");
        }
        hotelDAO.save(hotel);
    }

    public void updateHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("");
        }
        Hotel existing = hotelDAO.getById(hotel.getHotelId());
        if (existing == null) {
            throw new IllegalArgumentException("");
        }
        hotelDAO.update(hotel);

    }

    public void deleteHotel(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }
        Hotel existing = hotelDAO.getById(id);

        if (existing == null) {
            throw new IllegalArgumentException("");
        }

        hotelDAO.delete(id);
    }

    public Hotel getHotelById(String id) {
        Hotel existing = hotelDAO.getById(id);
        if (existing == null) { 
            throw new IllegalArgumentException("");
        }
        return existing;
    }

    public List<Hotel> getAllHotels() {
        return hotelDAO.getAll();
    }

    public List<Hotel> findByCity(String city) {
        return hotelDAO.getByCity(city);
    }

    public List<Hotel> findByStars(int stars) {
        return hotelDAO.getByStars(stars);
    }

    public List<Hotel> findByPriceRange(double min, double max) {
        return hotelDAO.getByPriceRange(min, max);
    }


}
