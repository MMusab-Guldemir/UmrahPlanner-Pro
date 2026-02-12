package src.service;

import src.model.Flight;
import src.model.Hotel;

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


}
