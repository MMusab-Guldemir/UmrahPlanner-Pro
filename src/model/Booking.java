package src.model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Booking {
    
    private String bookingId;
    private User user;
    private Flight outboundFlight;
    private Flight returnFlight;
    private Hotel makkahHotel;
    private Hotel madinahHotel;
    private List<VisitPlace> visitPlaces;
    private int numberOfTravelers;
    private LocalDate travelDate;
    private boolean hasGuide;
    private double guideFee;
    private boolean hasVisa;
    private double visaFee;
    private boolean hasInsurance;
    private double insuranceFee;
    private double totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private String notes;


    public Booking(User user, int numberOfTravelers, LocalDate travelDate, Flight outboundFlight, Flight returnFlight, Hotel makkahHotel, Hotel madinahHotel) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }        
        if (numberOfTravelers <= 0) {
            throw new IllegalArgumentException("Number of travelers must be at least 1");
        }
        if (travelDate == null || travelDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Travel date cannot be in the past or null");
        }
        if (outboundFlight == null) {
            throw new IllegalArgumentException("Outbound flight cannot be null");
        }
        if (makkahHotel == null) {
            throw new IllegalArgumentException("Makkah hotel cannot be null");
        }
        
        this.user = user;
        this.numberOfTravelers = numberOfTravelers;
        this.travelDate = travelDate;
        this.outboundFlight = outboundFlight;
        this.returnFlight = returnFlight;
        this.makkahHotel = makkahHotel;
        this.madinahHotel = madinahHotel;
        this.bookingId = "BKG-" + System.currentTimeMillis() % 100000;
        this.createdAt = LocalDateTime.now();
        this.status = "Beklemede";
        this.visitPlaces = new ArrayList<>();
        this.hasGuide = false;
        this.guideFee = 0.0;
        this.hasVisa = false;
        this.visaFee = 0.0;
        this.hasInsurance = false;
        this.insuranceFee = 0.0;
        this.totalPrice = 0.0;
        this.notes = "";

    }


    public String getBookingId() {
        return bookingId;
    }


    public User getUser() {
        return user;
    }


    public Flight getOutboundFlight() {
        return outboundFlight;
    }


    public Flight getReturnFlight() {
        return returnFlight;
    }


    public Hotel getMakkahHotel() {
        return makkahHotel;
    }


    public Hotel getMadinahHotel() {
        return madinahHotel;
    }


    public List<VisitPlace> getVisitPlaces() {
        return new ArrayList<>(visitPlaces);
    }


    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }


    public LocalDate getTravelDate() {
        return travelDate;
    }


    public boolean isHasGuide() {
        return hasGuide;
    }


    public double getGuideFee() {
        return guideFee;
    }


    public boolean isHasVisa() {
        return hasVisa;
    }


    public double getVisaFee() {
        return visaFee;
    }


    public boolean isHasInsurance() {
        return hasInsurance;
    }


    public double getInsuranceFee() {
        return insuranceFee;
    }


    public double getTotalPrice() {
        return totalPrice;
    }


    public String getStatus() {
        return status;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getPricePerPerson() {
        return totalPrice / numberOfTravelers;
    }

    public String getNotes() {
        return notes;
    }


    public void setOutboundFlight(Flight outboundFlight) {
        this.outboundFlight = outboundFlight;
    }


    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }


    public void setMakkahHotel(Hotel makkahHotel) {
        this.makkahHotel = makkahHotel;
    }


    public void setMadinahHotel(Hotel madinahHotel) {
        this.madinahHotel = madinahHotel;
    }


    public void setVisitPlaces(List<VisitPlace> visitPlaces) {
        if (visitPlaces == null) {
            this.visitPlaces = new ArrayList<>();
            return;
        }
        this.visitPlaces = new ArrayList<>();
    }


    public void setNumberOfTravelers(int numberOfTravelers) {
        if (numberOfTravelers <= 0) {
            throw new IllegalArgumentException("Number of travelers must be at least 1");
        }
        this.numberOfTravelers = numberOfTravelers;
    }


    public void setTravelDate(LocalDate travelDate) {
        if (travelDate == null || travelDate.isBefore(LocalDate.now())){ 
            throw new IllegalArgumentException("Travel date cannot be null or in the past");
        }
        this.travelDate = travelDate;
    }


    public void setHasGuide(boolean hasGuide) {
        this.hasGuide = hasGuide;
    }


    public void setGuideFee(double guideFee) {
        if (guideFee < 0) {
            throw new IllegalArgumentException("Guide fee cannot be negative");
        }
        this.guideFee = guideFee;
    }


    public void setHasVisa(boolean hasVisa) {
        this.hasVisa = hasVisa;
    }


    public void setVisaFee(double visaFee) {
        if (visaFee < 0) {
            throw new IllegalArgumentException("Visa fee cannot be negative");
        }
        this.visaFee = visaFee;
    }


    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }


    public void setInsuranceFee(double insuranceFee) {
        if (insuranceFee < 0) {
            throw new IllegalArgumentException("Insurance fee cannot be negative");
        }
        this.insuranceFee = insuranceFee;
    }


    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public void setNotes(String notes) {
        if (notes == null) {
            this.notes = "";
            return;
        }
        this.notes = notes;
    }

    public void addVisitPlace(VisitPlace place) {
        if (place == null ) {
            return;
        }
        visitPlaces.add(place);
    }

    public void removeVisitPlace(VisitPlace place) {
        if (place == null) {
            return;
        }
        visitPlaces.remove(place);
    }

    public void calculateTotalPrice() {
        double total = 0.0;

        total += outboundFlight.getPrice() * numberOfTravelers;

        if (returnFlight != null) {
            total += returnFlight.getPrice() * numberOfTravelers;
        }

        total += makkahHotel.getTotalPrice() * numberOfTravelers;

        if (madinahHotel != null) {
            total += madinahHotel.getTotalPrice() * numberOfTravelers;
        }

        for (VisitPlace place : visitPlaces) {
            total += place.getEntryFee() * numberOfTravelers;
        }
        total += guideFee;
        total += visaFee * numberOfTravelers;
        total += insuranceFee * numberOfTravelers;

        this.totalPrice = total;
        
    }


    public String getBookingSummary() {
        return String.format(
            "Booking: %s | User: %s | Travelers: %d | Date: %s | Total: $%.2f | Status: %s",
            bookingId, user.getFullName(), numberOfTravelers, travelDate, totalPrice, status
        );
    }
    
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Booking other = (Booking) obj;
        return bookingId != null && bookingId.equals(other.bookingId);
    }

    @Override 
    public int hashCode() {
        return bookingId != null ? bookingId.hashCode() : 0;
    } 

    @Override
    public String toString() {
        return String.format("Booking{id='%s', user='%s', travelers=%d, status='%s', total=%.2f}",
            bookingId, user.getFullName(), numberOfTravelers, status, totalPrice);
    }

}
