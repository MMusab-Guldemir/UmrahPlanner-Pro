package src.model;

import java.util.Arrays;

public class Hotel {

    private String hotelId;
    private String hotelName;
    private String city;
    private int starRating;
    private String roomType;
    private int distanceToHaram;
    private double pricePerNight;
    private int numberOfNights;
    private double rating;
    private String[] amenities; // Olanaklar [örneğin: WiFi, kahvaltı, havuz] vb.
    private boolean haramView;

    public Hotel(String hotelName, String city, int starRating, String roomType, double pricePerNight) {
        if (hotelName == null || hotelName.trim().isEmpty()) {
            throw new IllegalArgumentException("Hotel name cannot be empty");
        }

        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }

        this.hotelId = "HTL-" + System.currentTimeMillis() % 100000;
        this.hotelName = hotelName;
        this.roomType = (roomType != null) ? roomType : "Standard";
        this.rating = 0.0;
        this.numberOfNights = 1;
        this.haramView = false;
        this.amenities = new String[0];
        this.distanceToHaram = 0;
        setCity(city);
        setPricePerNight(pricePerNight);
        setStarRating(starRating);
    }

    public String getHotelId() {
        return hotelId;
    }
  
    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public int getStarRating() {
        return starRating;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getDistanceToHaram() {
        return distanceToHaram;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getRating() {
        return rating;
    }

    public String[] getAmenities() {
        return Arrays.copyOf(amenities, amenities.length);
    }

    public boolean isHaramView() {
        return haramView;
    }

    public String getDistanceDescription() {
        if (distanceToHaram <= 0) {
            return "Belirtimedi";
        }
        else if (distanceToHaram < 100) {
            return distanceToHaram + "m Çok Yakın (0-100m)";
        } else if (distanceToHaram < 300) {
            return distanceToHaram + "m Yakın (100-300m)";
        } else if (distanceToHaram < 500) {
            return distanceToHaram + "m Orta (300-500m)";
        } else {
            return distanceToHaram + "m Uzak (500m+)";
        }
    }
    
    public String getStarDisplay() {
        return "★".repeat(starRating) + "☆".repeat(5 - starRating);
    }

    public double getTotalPrice() {
        return pricePerNight * numberOfNights;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight <= 0) {
            throw new IllegalArgumentException("Price per night must be positive");
        } 
        this.pricePerNight = pricePerNight;
    }

    public void setAmenities(String[] amenities) {
        if (amenities == null) {
            this.amenities = new String[0];
            return;
        }
        this.amenities = Arrays.copyOf(amenities, amenities.length);
    }

    public void setStarRating(int starRating) {
        if (starRating < 1 || starRating > 5) {
            throw new IllegalArgumentException("Star rating must be between 1 and 5");
        }
        this.starRating = starRating;
    }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights < 1) {
            throw new IllegalArgumentException("Number of nights must be at least 1");
        }
        this.numberOfNights = numberOfNights;
    }

    public void setDistanceToHaram(int distanceToHaram) {
        if (distanceToHaram < 0) {
            throw new IllegalArgumentException("Distance to Haram cannot be negative");
        }
        this.distanceToHaram = distanceToHaram;
    }

    public void setRating(double rating) {
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0");
        }
        this.rating = rating;
    }

    public void setHaramView(boolean haramView) {
        this.haramView = haramView;
    }
    
    public void setHotelName(String hotelName) {
        if (hotelName == null || hotelName.trim().isEmpty()) {
            throw new IllegalArgumentException("Hotel name cannot be empty");
        }
        this.hotelName = hotelName;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        } 
        if (!(city.equals("Mekke") || city.equals("Medine"))) {
            throw new IllegalArgumentException("City must be either 'Mekke' or 'Medine'");
        }
        this.city = city; 
    }

    public void setRoomType(String roomType) {
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new IllegalArgumentException("Room type cannot be empty");
        }
        this.roomType = roomType;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hotel other = (Hotel) obj;
        return hotelId != null ? hotelId.equals(other.hotelId) : other.hotelId == null;
    }

    @Override
    public int hashCode() {
        return hotelId != null ? hotelId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Hotel %s in %s, %d stars, Room: %s, Price per night: $%.2f", 
                hotelName, city, starRating, roomType, pricePerNight);
    }


}
