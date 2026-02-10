package src.dao;

import java.util.List;
import java.util.ArrayList;
import src.model.VisitPlace;
public class VisitPlaceDAO {
    
    private List<VisitPlace> places;

    public VisitPlaceDAO() {
        this.places = new ArrayList<>();
    }

    public List<VisitPlace> getAll() {
        return new ArrayList<>(places);
    }   

    public VisitPlace getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getPlaceId().equals(id)) {
                return visitPlace;
            }
        }
        return null;
    }

    public void save(VisitPlace place) {
        if (place == null) {
            throw new IllegalArgumentException("VisitPlace cannot be null");
        }
        places.add(place);
    }

    public void update(VisitPlace place) {
        if (place == null) {
            throw new IllegalArgumentException("VisitPlace cannot be null");
        }

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getPlaceId().equals(place.getPlaceId())) {
                places.remove(visitPlace);
                break;
            }
        }
        save(place);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }



        for (VisitPlace visitPlace : places) {
            if (visitPlace.getPlaceId().equals(id)) {
                places.remove(visitPlace);
                break;
            }
        }
    }

    public List<VisitPlace> getByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getCity().equalsIgnoreCase(city)) {
                result.add(visitPlace);
            }
        }
        return result;
    }

    public List<VisitPlace> getByImportance(String importance) {
        if (importance == null || importance.trim().isEmpty()) {
            throw new IllegalArgumentException("Importance cannot be null or empty");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getImportance().equalsIgnoreCase(importance)) {
                result.add(visitPlace);
            }
        }
        return result;
    }
    
    public List<VisitPlace> getByType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getType().equalsIgnoreCase(type)) {
                result.add(visitPlace);
            }
        }
        return result;
    }

    public List<VisitPlace> getIncluded() {

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.isIncluded()) {
                result.add(visitPlace);
            }
        }
        return result;
    }
    

}
