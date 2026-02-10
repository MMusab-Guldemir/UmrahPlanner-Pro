package src.dao;

import java.util.List;

import javax.swing.text.DefaultEditorKit.BeepAction;

import java.lang.classfile.TypeAnnotation.ThrowsTarget;
import java.rmi.Remote;
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
                users.remove(users);
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

}
