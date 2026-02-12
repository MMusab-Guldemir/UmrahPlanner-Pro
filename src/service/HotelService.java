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
            throw new IllegalArgumentException("Hotel cannot be null");
        }
        hotelDAO.save(hotel);
    }

    public void updateHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }
        Hotel existing = hotelDAO.getById(hotel.getHotelId());
        if (existing == null) {
            throw new IllegalArgumentException("Hotel not found with id: " + hotel.getHotelId());
        }
        hotelDAO.update(hotel);

    }

    public void deleteHotel(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Hotel ID cannot be null or empty");
        }
        Hotel existing = hotelDAO.getById(id);

        if (existing == null) {
            throw new IllegalArgumentException("Hotel not found with id: " + id);
        }

        hotelDAO.delete(id);
    }

    public Hotel getHotelById(String id) {
        Hotel existing = hotelDAO.getById(id);
        if (existing == null) { 
            throw new IllegalArgumentException("Hotel not found with id: " + id);
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

    public List<Hotel> getMakkahHotels() {
        return hotelDAO.getByCity("Mekke");
    }

    public List<Hotel> getMadinahHotels() {
        return hotelDAO.getByCity("Medine");
    }

    public int getHotelCount() {
        return hotelDAO.getAll().size();
    }
}
