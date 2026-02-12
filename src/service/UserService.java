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
}
