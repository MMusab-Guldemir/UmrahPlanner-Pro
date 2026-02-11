package src.dao;

import src.model.UmrahPackage;
import java.util.List;
import java.util.ArrayList;
public class UmrahPackageDAO {
    
    private List<UmrahPackage> UmrahPackages;

    public UmrahPackageDAO() {
        this.UmrahPackages = new ArrayList<>();
    }

    public List<UmrahPackage> getAll() {
        return new ArrayList<>(UmrahPackages);
    }

    public UmrahPackage getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : UmrahPackages) {
            if (umrahPackage.getPackageId().equals(id)) {
                return umrahPackage;
            }
        }
        return null;
    }

    public void save(UmrahPackage pkg) {
        if (pkg == null) {
            throw new IllegalArgumentException("");
        }
        UmrahPackages.add(pkg);
    } 

    public void update(UmrahPackage pkg) {
        if (pkg == null) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : UmrahPackages) {
            if (umrahPackage.getPackageId().equals(pkg.getPackageId())) {
                UmrahPackages.remove(pkg);
            }
        }
        save(pkg);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : UmrahPackages) {
            if (umrahPackage.getPackageId().equals(id)) {
                UmrahPackages.remove(UmrahPackages);
            }
        }        
    }
}
 