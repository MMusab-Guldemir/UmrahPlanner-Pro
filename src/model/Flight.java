package src.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Flight {
    
    private String flightId;
    private String flightNumber;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightClass;
    private double price;
    private int availableSeats;
    private double rating;
    private boolean isDirect;


    public Flight(String flightNumber, String airline, String flightClass, double price) {

        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }

        if (airline == null || airline.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline cannot be empty");
        }

        this.flightId = "FLT-" + System.currentTimeMillis() % 100000;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.flightClass = flightClass;
        setPrice(price);

        this.isDirect = true;
        this.rating = 0.0;
        this.availableSeats = 100;
    }

    

    public String getDepartureCity() {
        return departureCity;
    }



    public String getArrivalCity() {
        return arrivalCity;
    }



    public LocalDateTime getDepartureTime() {
        return departureTime;
    }



    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }



    public String getFlightClass() {
        return flightClass;
    }



    public int getAvailableSeats() {
        return availableSeats;
    }



    public double getRating() {
        return rating;
    }



    public boolean isDirect() {
        return isDirect;
    }



    public String getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public double getPrice() {
        return price;
    }

    public double calculateDuration() {
        if (departureTime == null || arrivalTime == null) {
            return -1; // Duration cannot be calculated
        }
        return departureTime.until(arrivalTime, ChronoUnit.HOURS);
    }
    
    public String getFlightSummary() {
        return String.format("Flight %s by %s, Class: %s, Price: $%.2f", airline, flightNumber, flightClass, price);
    }

    public void setPrice(double price) {
                if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } 
        this.price = price;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }


    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setRating(double rating) {
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0");
        }
        this.rating = rating;
    }

    public void setAvailableSeats(int seats) {
        if (seats < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative");
        }
        this.availableSeats = seats;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        if (arrivalTime != null && departureTime != null 
            && arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Arrival time cannot be before departure time");
        }
        this.arrivalTime = arrivalTime;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Flight other = (Flight) obj;
        return flightId != null && flightId.equals(other.flightId);
    }

    @Override 
    public int hashCode() {
        return flightId != null ? flightId.hashCode() : 0;
    }


    @Override
    public String toString() {
        return String.format("%s - %s | %s | %s | $%.2f",
                                 flightNumber, flightId, airline, flightClass, price);
    }
}
