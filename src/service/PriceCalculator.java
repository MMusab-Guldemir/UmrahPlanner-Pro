package src.service;

import src.model.Booking;
import src.model.Flight;
import src.model.Hotel;
import src.model.UmrahPackage;
import src.model.User;
import src.model.VisitPlace;

public class PriceCalculator {
    private static final double VISA_FEE = 150.0;
    private static final double GUIDE_FEE_PER_DAY = 50.0;
    private static final double INSURANCE_FEE = 75.0;
    private static final double ECONOMY_MULTIPLIER = 1.0;
    private static final double COMFORT_MULTIPLIER = 1.5;
    private static final double PREMIUM_MULTIPLIER = 2.0;

    public static double calculateFlightCost(Flight flight, int travelers) {
        if (flight == null) {
            throw new IllegalArgumentException();
        }
        if (travelers < 1) {
            throw new IllegalArgumentException();
        }
        return flight.getPrice() * travelers;
    }

    public static double calculateHotelCost(Hotel hotel, int travelers) {
        if (hotel == null) {
            throw new IllegalArgumentException();
        }

        return hotel.getTotalPrice() * travelers;
    }

    public static double calculateGuideFee(int duration, boolean hasGuide) {
        if (hasGuide == false) {
            return 0;
        }
        return GUIDE_FEE_PER_DAY * duration; 
    }

    public static double calculateVisaFee(int travelers, boolean hasVisa) {
        if (hasVisa == false) {
            return 0;
        } 
        return VISA_FEE * travelers;
    }

    public static double calculateInsuranceFee(int travelers, boolean hasInsurance) {
        if (hasInsurance == false) {
            return 0;
        }
        return INSURANCE_FEE * travelers;
    }

    public static double calculatePackagePrice(UmrahPackage pkg, int travelers) {
        if (pkg == null) {
            throw new IllegalArgumentException();
        }

        double multiplier = ECONOMY_MULTIPLIER;

        if (pkg.getPackageType().equals("Comfort")) {
            multiplier = COMFORT_MULTIPLIER;
        } else if (pkg.getPackageType().equals("Premium")) {
            multiplier = PREMIUM_MULTIPLIER;
        }
        
        return pkg.getBasePrice() * travelers * multiplier;
           
    }

    public static double calculateTotalBookingPrice(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException();
        }
        double total = 0.0;
        int travelers = booking.getNumberOfTravelers();

        total += booking.getOutboundFlight().getPrice() * travelers;

        if (booking.getReturnFlight() != null) {
            total += booking.getReturnFlight().getPrice() * travelers;
        }

        total += booking.getMakkahHotel().getTotalPrice() * travelers;

        if (booking.getMadinahHotel() != null) {
            total += booking.getMadinahHotel().getTotalPrice() * travelers;
        }

        for (VisitPlace place : booking.getVisitPlaces()) {
            total += place.getEntryFee() * travelers;
        }

        total += booking.getGuideFee();

        if (booking.isHasVisa()) {
            total += VISA_FEE * travelers;
        }

        if (booking.isHasInsurance()) {
            total += INSURANCE_FEE * travelers;
        }
        
        return total;
           
    }

    public static double applyDiscount(double totalPrice, User user) {
        if (user.getPreviousUmrahCount() >= 3) {
            return totalPrice * 0.90;
        }

        else if (user.getPreviousUmrahCount() >= 1) {
            return totalPrice * 0.95; 
        }

        return totalPrice;
    }
}
