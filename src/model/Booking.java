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
    private Hotel medinaHotel;
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

    

}
