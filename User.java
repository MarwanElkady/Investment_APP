/**
 * The {@code User} class represents a user in the Tharwa Investments system.
 * It stores user details such as name, email, phone number, password, and investment preferences.
 * This class provides getter methods to access these details, primarily used by the {@code AuthService}
 * for user management and authentication.
 */
import java.util.List;

public class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<String> preferences;

    /**
     * Constructs a new {@code User} with the specified details.
     *
     * @param name        the name of the user
     * @param email       the email address of the user
     * @param phone       the phone number of the user
     * @param password    the password for the user account
     * @param preferences a list of the user's investment preferences (e.g., Gold, Real Estate, Crypto)
     */
    public User(String name, String email, String phone, String password, List<String> preferences) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.preferences = preferences;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the user's name as a {@code String}
     */
    public String getName() { 
        return name; 
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return the user's phone number as a {@code String}
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return the user's email address as a {@code String}
     */
    public String getEmail() { 
        return email; 
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the user's password as a {@code String}
     */
    public String getPassword() { 
        return password; 
    }

    /**
     * Retrieves the list of the user's investment preferences.
     *
     * @return a {@code List} of {@code String} representing the user's investment preferences
     */
    public List<String> getPreferences() { 
        return preferences; 
    }
}