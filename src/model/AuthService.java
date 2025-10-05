package model;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> users = new HashMap<>();

    //Register new user
    public boolean register(User user) {
        if (users.containsKey(user.getUsername())) {
            return false; 
        }
        users.put(user.getUsername(), user);
        return true;
    }

    // Login user
    public User login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }
}
