package src.service;
import src.model.User;
import src.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;


public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }

        User existing = userDAO.getByTcNumber(user.getTcNumber());

        if (existing != null) {
            throw new IllegalArgumentException("");
        }

        userDAO.save(user);
    }

    public User updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }
        
        User existing = userDAO.getById(user.getUserId());
        
        if (existing == null) {
            throw new IllegalArgumentException("");
        }
        userDAO.update(user);
        return existing;        
    }

    public User deleteUser(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(""); 
        }

        User existing = userDAO.getById(id);

        if (existing == null) {
            throw new IllegalArgumentException("");
        }

        userDAO.delete(id);
        return existing;
    }

    public User getUserById(String id) {
        User existing = userDAO.getById(id);
        if (existing == null) {
            throw new IllegalArgumentException("");
        }
        return existing;
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User findByTcNumber(String tc) {
        return userDAO.getByTcNumber(tc);
    }

    public List<User> findByFullName(String name) {
        return userDAO.getByFullName(name);
    }

    public List<User> findBBByNationality(String nationality) {
        return userDAO.getByNationality(nationality);
    }

}
