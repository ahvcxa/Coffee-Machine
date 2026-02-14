package CoffeeMachine.service;


import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users;

    public UserManager() {
        users = new HashMap<>();
                
        users.put("owner", "1234");

    }
    
    public boolean checkLogin(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}