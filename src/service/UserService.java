package src.service;
import src.model.User;
import src.dao.UserDAO;

import java.lang.classfile.attribute.PermittedSubclassesAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

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

    

}
