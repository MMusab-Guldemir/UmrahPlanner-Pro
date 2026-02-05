package src.model;

import java.security.PublicKey;
import java.time.LocalDateTime;

import javax.swing.plaf.basic.BasicBorders;

public class Flight {
    
    String flightId;
    String flightNumber;
    String airline;
    String departureCity;
    String arrivalCity;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    String flightClass;
    double price;
    int availableSeats;
    double rating;
    boolean isDirect;

    public Flight(String flightNumber, String airline, String flightClass, double price) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.flightClass = flightClass;
        this.price = price;

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
        return departureTime.until(arrivalTime, java.time.temporal.ChronoUnit.HOURS);
    }
    
    public String getFlightSummary() {
        return String.format("Flight %s by %s, Class: %s, Price: $%.2f", airline, flightNumber, flightClass, price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return null;
    }
}
