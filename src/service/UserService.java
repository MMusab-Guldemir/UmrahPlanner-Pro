package src.service;
import src.model.User;
import src.dao.UserDAO;
import java.util.List;


public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        User existing = userDAO.getByTcNumber(user.getTcNumber());

        if (existing != null) {
            throw new IllegalArgumentException("User with this TC number already exists");
        }

        userDAO.save(user);
    }

    public void updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        
        User existing = userDAO.getById(user.getUserId());
        
        if (existing == null) {
            throw new IllegalArgumentException("User not found with id: " + user.getUserId());
        }
        userDAO.update(user);
    }

    public void deleteUser(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty"); 
        }

        User existing = userDAO.getById(id);

        if (existing == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }

        userDAO.delete(id);
    }

    public User getUserById(String id) {
        User existing = userDAO.getById(id);
        if (existing == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
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

    public List<User> findByNationality(String nationality) {
        return userDAO.getByNationality(nationality);
    }

    public boolean isUserExists(String tcNumber)  {
        return userDAO.getByTcNumber(tcNumber) != null;
    }

    public int getUserCount() {
        return userDAO.getAll().size();
    }

    public boolean validateUser(User user) {
        if (user == null) {
            return false;
        }
        if (user.getFirstName() == null ||user.getFirstName().trim().isEmpty()) {
            return false;
        }
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            return false;
        }
        if (user.getTcNumber().length() != 11)  {
            return false;
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().trim().isEmpty()) {
            return false;
        }

        return true;
    }

}
