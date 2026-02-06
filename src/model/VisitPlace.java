package src.model;


public class VisitPlace {
    private String placeId;
    private String placeName;
    private String city;
    private String description;
    private double entryFee ;
    private String estimatedDuration;
    private String importance;
    private String type;
    private boolean isIncluded;

    public VisitPlace(String placeName, String city, double entryFee, String importance) {
        if (placeName == null || placeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Place name cannot be empty");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        } 
        if (!(city.equals("Mekke") || city.equals("Medine"))) {
            throw new IllegalArgumentException("City must be either 'Mekke' or 'Medine'");
        }
        if (entryFee < 0) {
            throw new IllegalArgumentException("Entry fee cannot be negative");
        }
        this.placeId = "PLC-" + System.currentTimeMillis() % 100000;
        this.placeName = placeName;
        this.city = city;
        this.entryFee = entryFee;
        this.importance = (importance != null) ? importance : "Tavsiye";

        this.description = "";
        this.estimatedDuration = "";
        this.type = "Dini"; 
        this.isIncluded = false;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

    public String getImportance() {
        return importance;
    }

    public String getType() {
        return type;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public String getPlaceSummary() {
        return placeName + " (" + city + ") - Giriş Ücreti: " + entryFee + " TL, Önem: " + importance;
    }

    public void setPlaceName(String placeName) {
        if (placeName == null || placeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Place name cannot be empty");
        }
        this.placeName = placeName;
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

    public void setEntryFee(double entryFee) {
        if (entryFee < 0) {
            throw new IllegalArgumentException("Entry fee cannot be negative");
        }
        this.entryFee = entryFee;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            description = "";
        }
        this.description = description;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        if (estimatedDuration == null || estimatedDuration.trim().isEmpty()) {
            estimatedDuration = "";
        }
        this.estimatedDuration = estimatedDuration;
    }

    public void setImportance(String importance) {
        if (importance == null || importance.trim().isEmpty()) {
            importance = "Tavsiye";
        }
        this.importance = importance;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            type = "Dini";
        }
        this.type = type;
    }

    public void setIncluded(boolean included) {
        isIncluded = included;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VisitPlace other = (VisitPlace) obj;
        return placeId != null && placeId.equals(other.placeId);
    }

    @Override
    public int hashCode() {
        return placeId != null ? placeId.hashCode() : 0;
    }

    @Override 
    public String toString() {
        return "VisitPlace{" +
                "placeId='" + placeId + '\'' +
                ", placeName='" + placeName + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", entryFee=" + entryFee +
                ", estimatedDuration='" + estimatedDuration + '\'' +
                ", importance='" + importance + '\'' +
                ", type='" + type + '\'' +
                ", isIncluded=" + isIncluded +
                '}';
    }
    
}