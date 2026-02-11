package src.dao;

import src.model.UmrahPackage;
import java.util.List;
import java.util.ArrayList;
public class UmrahPackageDAO {
    
    private List<UmrahPackage> packages;

    public UmrahPackageDAO() {
        this.packages = new ArrayList<>();
    }

    public List<UmrahPackage> getAll() {
        return new ArrayList<>(packages);
    }

    public UmrahPackage getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getPackageId().equals(id)) {
                return umrahPackage;
            }
        }
        return null;
    }

    public void save(UmrahPackage pkg) {
        if (pkg == null) { 
            throw new IllegalArgumentException("UmrahPackage cannot be null");
        }
        packages.add(pkg);
    } 

    public void update(UmrahPackage pkg) {
        if (pkg == null) {
            throw new IllegalArgumentException("UmrahPackage cannot be null");
        }

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getPackageId().equals(pkg.getPackageId())) {
                packages.remove(umrahPackage);
                break;
            }
        }
        save(pkg);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getPackageId().equals(id)) {
                packages.remove(umrahPackage);
                break;
            }
        }        
    }

    public List<UmrahPackage> getByType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Package type cannot be null or empty");
        }

        List<UmrahPackage> result = new ArrayList<>();

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getPackageType().equalsIgnoreCase(type)) {
                result.add(umrahPackage);
            }
        }
        return result;
    }

    public List<UmrahPackage> getByPriceRange(double min, double max) {
        if (min < 0 || max < 0) { 
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (min > max) {
            throw new IllegalArgumentException("Min price cannot be greater than max");
        }
        List<UmrahPackage> result = new ArrayList<>();

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getBasePrice() >= min && umrahPackage.getBasePrice() <= max) {
                    result.add(umrahPackage);
            }
        }
        return result;
    }

    public List<UmrahPackage> getByDuration(int minDays, int maxDays) {
        if (minDays < 1) {
            throw new IllegalArgumentException("Min days must be at least 1");
        }
        if (minDays > maxDays) {
            throw new IllegalArgumentException("Min days cannot be greater than max days");
        }

        List<UmrahPackage> result = new ArrayList<>();

        for (UmrahPackage umrahPackage : packages) {
            if (umrahPackage.getDuration() >= minDays) {
                if (umrahPackage.getDuration() <= maxDays) {
                    result.add(umrahPackage);
                }
            }
        }
        return result;
    }

}
 