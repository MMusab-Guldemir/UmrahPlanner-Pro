package src.model;

import java.util.ArrayList;
import java.util.List;

public class UmrahPackage {
    private String packageId;
    private String packageName;
    private String packageType;
    private String description;
    private int duration;
    private double basePrice;
    private String includedFlightClass;
    private int includedHotelStars;
    private List<String> includedVisitPlaces;
    private boolean hasGuide;
    private boolean hasVisa;
    private boolean hasInsurance;

    public UmrahPackage(String packageName, String packageType, int duration, double basePrice) {
        if (packageName == null || packageName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!packageType.equals("Economy") || !packageType.equals("Comfort") 
                        || !packageType.equals("Premium")) {
            throw new IllegalArgumentException();
        }
        if (duration < 0) {
            throw new IllegalArgumentException();
        }
        if (basePrice < 0) {
            throw new IllegalArgumentException();
        }

        this.packageName = packageName;
        this.packageType = packageType;
        this.packageId = "PKG-" + System.currentTimeMillis() % 100000;
        this.description = description;
        this.includedFlightClass = includedFlightClass;
        this.includedHotelStars = includedHotelStars;
        this.includedVisitPlaces = new ArrayList<>();
        this.hasGuide = hasGuide;
        this.hasVisa = hasVisa;
        this.hasInsurance = hasInsurance;
    }
}
