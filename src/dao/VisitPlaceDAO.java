package src.dao;

import java.util.List;
import java.util.ArrayList;
import src.model.VisitPlace;;
public class VisitPlaceDAO {
    
    private List<VisitPlace> field;

    public VisitPlaceDAO() {
        this.field = new ArrayList<>();
    }

    public List<VisitPlace> getAll() {
        return new ArrayList<>(field);
    }   

    public VisitPlace getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (VisitPlace visitPlace : field) {
            if (visitPlace.getPlaceId().equals(id)) {
                return visitPlace;
            }
        }
        return null;
    }

    public void save(VisitPlace place) {
        if (place == null) {
            throw new IllegalArgumentException();
        }
        field.add(place);
    }

    public void update(VisitPlace place) {
        if (place == null) {
            throw new IllegalArgumentException();
        }

        for (VisitPlace visitPlace : field) {
            if (visitPlace.getPlaceId().equals(place.getPlaceId())) {
                field.remove(field);
                break;
            }
        }
        save(place);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (VisitPlace visitPlace : field) {
            if (visitPlace.getPlaceId().equals(id)) {
                field.remove(field);
                break;
            }
        }
    }
    
    

}
