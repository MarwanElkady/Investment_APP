import java.util.*;

public class AuthService implements UserManagement {
    private Map<String, User> users = new HashMap<>();

    public boolean register(String name, String email, String phone, String password, List<String> preferences) {
        if (users.containsKey(email)) return false;
        User newUser = new User(name, email, phone, password, preferences);
        users.put(email, newUser);
        System.out.println("Registered successfully! Redirecting to login...");
        return true;
    }

    public boolean login(String email, String password) {
        return users.containsKey(email) && users.get(email).getPassword().equals(password);
    }

    public User getUser(String email) {
        return users.get(email);
    }
}
