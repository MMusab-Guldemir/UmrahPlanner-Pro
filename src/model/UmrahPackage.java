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
            throw new IllegalArgumentException("Package name cannot be empty");
        }
        if (!packageType.equals("Economy") && !packageType.equals("Comfort") && !packageType.equals("Premium")) {
            throw new IllegalArgumentException("Package type must be Economy, Comfort or Premium");
        }
        if (duration < 1) {
            throw new IllegalArgumentException("Duration must be at least 1 day");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be greater than 0");
        }

        this.packageName = packageName;
        this.packageType = packageType;
        this.packageId = "PKG-" + System.currentTimeMillis() % 100000;
        this.description = "";
        this.duration = duration;
        this.basePrice = basePrice;
        this.includedVisitPlaces = new ArrayList<>();
        this.hasVisa = false;
        this.hasInsurance = false;

        if (packageType.equals("Economy")) {
            this.includedFlightClass = "Economy";
            this.includedHotelStars = 3;
            this.hasGuide = false;
        } else if (packageType.equals("Comfort")) {
            this.includedFlightClass = "Economy";
            this.includedHotelStars = 4;
            this.hasGuide = true;
        } else {
            this.includedFlightClass = "Business";
            this.includedHotelStars = 5;
            this.hasGuide = true;
        }
    }

    public String getPackageId() {
        return packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getIncludedFlightClass() {
        return includedFlightClass;
    }

    public int getIncludedHotelStars() {
        return includedHotelStars;
    }

    public List<String> getVisitPlaces() {
        return new ArrayList<>(includedVisitPlaces);
    }

    public boolean isHasGuide() {
        return hasGuide;
    }

    public boolean isHasVisa() {
        return hasVisa;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setPackageName(String packageName) {
        if (packageName == null || packageName.trim().isEmpty()) {
            throw new IllegalArgumentException("Package name cannot be empty");
        }
        this.packageName = packageName;
    }

    public void setDescription(String description) {
        if (description == null) {
            this.description = "";
            return;
        }
        this.description = description;
    }

    public void setDuration(int duration) {
        if (duration < 1) {
            throw new IllegalArgumentException("Duration must be at least 1 day");
        }
        this.duration = duration;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be greater than 0");
        }
        this.basePrice = basePrice;
    }

    public void setVisitPlaces(List<String> places) {
        if (places == null) {
            this.includedVisitPlaces = new ArrayList<>();
            return;
        }
        this.includedVisitPlaces = new ArrayList<>(places);
    }

    public void setHasVisa(boolean hasVisa) {
        this.hasVisa = hasVisa;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public void addVisitPlace(String place) {
        if (place == null) {
            return;
        }
        includedVisitPlaces.add(place);
    }

    public void removeVisitPlace(String place) {
        if (place == null) {
            return;
        }
        includedVisitPlaces.remove(place);
    }
    
    public String getPackageSummary() {
        return String.format("%s (%s) | %d gün | $%.2f | %d★ Otel | %s Uçuş | Rehber: %s",
            packageName, packageType, duration, basePrice, 
            includedHotelStars, includedFlightClass, 
            hasGuide ? "Var" : "Yok");
}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UmrahPackage other = (UmrahPackage) obj;
        return packageId != null && packageId.equals(other.packageId);
    }

    @Override
    public int hashCode() {
        return packageId != null ? packageId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("UmrahPackage{id='%s', name='%s', type='%s', duration=%d, price=%.2f}",
                packageId, packageName, packageType, duration, basePrice);
    }
}