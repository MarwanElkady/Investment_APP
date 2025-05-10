/**
 * The {@code AuthService} class implements the {@code UserManagement} interface to provide
 * user registration, login, and retrieval functionalities. It manages user data using a
 * {@code HashMap} with email as the key and {@code User} objects as values.
 */
import java.util.*;

public class AuthService implements UserManagement {
    private Map<String, User> users = new HashMap<>();

    /**
     * Registers a new user with the provided details.
     *
     * @param name        the name of the user
     * @param email       the email address of the user (used as a unique identifier)
     * @param phone       the phone number of the user
     * @param password    the password for the user account
     * @param preferences a list of user preferences
     * @return {@code true} if registration is successful, {@code false} if the email is already registered
     */
    public boolean register(String name, String email, String phone, String password, List<String> preferences) {
        if (users.containsKey(email)) return false;
        User newUser = new User(name, email, phone, password, preferences);
        users.put(email, newUser);
        System.out.println("Registered successfully! Redirecting to login...");
        return true;
    }

    /**
     * Authenticates a user by verifying the provided email and password.
     *
     * @param email    the email address of the user
     * @param password the password to verify
     * @return {@code true} if the email exists and the password matches, {@code false} otherwise
     */
    public boolean login(String email, String password) {
        return users.containsKey(email) && users.get(email).getPassword().equals(password);
    }

    /**
     * Retrieves the user associated with the specified email.
     *
     * @param email the email address of the user to retrieve
     * @return the {@code User} object associated with the email, or {@code null} if no user is found
     */
    public User getUser(String email) {
        return users.get(email);
    }
}
