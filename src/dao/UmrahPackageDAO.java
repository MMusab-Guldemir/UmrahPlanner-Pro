package src.dao;

import src.model.UmrahPackage;
import java.util.List;
import java.util.ArrayList;
public class UmrahPackageDAO {
    
    private List<UmrahPackage> umrahPackages;

    public UmrahPackageDAO() {
        this.umrahPackages = new ArrayList<>();
    }

    public List<UmrahPackage> getAll() {
        return new ArrayList<>(umrahPackages);
    }

    public UmrahPackage getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : umrahPackages) {
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
        umrahPackages.add(pkg);
    } 

    public void update(UmrahPackage pkg) {
        if (pkg == null) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : umrahPackages) {
            if (umrahPackage.getPackageId().equals(pkg.getPackageId())) {
                umrahPackages.remove(umrahPackage);
            }
        }
        save(pkg);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (UmrahPackage umrahPackage : umrahPackages) {
            if (umrahPackage.getPackageId().equals(id)) {
                umrahPackages.remove(umrahPackage);
                break;
            }
        }        
    }
}
 