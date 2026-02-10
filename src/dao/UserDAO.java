package src.dao;

import java.util.List;
import java.util.ArrayList;
import src.model.User;

public class UserDAO {
    
    private List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    public User getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (User user : users) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }
        users.add(user);
    }

    public void update(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        for (User user1 : users) {
            if (user1.getUserId().equals(user.getUserId())) {
                users.remove(user1);
                break;
            }
        }
        save(user);
    }

    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }
        
        for (User user : users) {
            if (user.getUserId().equals(id)) {
                users.remove(user);
                break;
            }
        }
    }

    public User getByTcNumber(String tc) {
        if (tc == null || tc.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        for (User user : users) {
            if (user.getTcNumber().equals(tc)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getByFullName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getFullName().equalsIgnoreCase(name)) {
                result.add(user);
            }
        }
        return users;
    }

    public List<User> getByNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }

        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getNationality().equalsIgnoreCase(nationality)) {
                result.add(user);
            }
        }
        return users;
    }

    

}
