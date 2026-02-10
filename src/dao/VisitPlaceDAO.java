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
            throw new IllegalArgumentException("");
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
            throw new IllegalArgumentException();
        }
        places.add(place);
    }

    public void update(VisitPlace place) {
        if (place == null) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException("");
        }



        for (VisitPlace visitPlace : places) {
            if (visitPlace.getPlaceId().equals(id)) {
                places.remove(visitPlace);
                break;
            }
        }
    }

    public VisitPlace getByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getCity().equalsIgnoreCase(city)) {
                result.add(visitPlace);
            }
        }
        return null;
    }

    public VisitPlace getByImportance(String importance) {
        if (importance == null || importance.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getImportance().equalsIgnoreCase(importance)) {
                result.add(visitPlace);
            }
        }
        return null;
    }
    
    public VisitPlace getByType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.getType().equalsIgnoreCase(type)) {
                result.add(visitPlace);
            }
        }
        return null;
    }

    public VisitPlace getInculeded() {

        List<VisitPlace> result = new ArrayList<>();

        for (VisitPlace visitPlace : places) {
            if (visitPlace.isIncluded()) {
                result.add(visitPlace);
            }
        }
        return null;
    }
    

}
