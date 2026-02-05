package src.model;

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
        this.city = city;
        this.starRating = starRating;
        this.roomType = roomType;
        setPricePerNight(pricePerNight);

        this.rating = 0.0;
        this.numberOfNights = 1;
        this.haramView = false;
        setStarRating(starRating);
        this.amenities = new String[0];

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
        return amenities;
    }

    public boolean isHaramView() {
        return haramView;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setDistanceToHaram(int distanceToHaram) {
        this.distanceToHaram = distanceToHaram;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setHaramView(boolean haramView) {
        this.haramView = haramView;
    }

    public String getStarDisplay() {
        return "★".repeat(starRating) + "☆".repeat(5 - starRating);
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
