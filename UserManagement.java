/**
 * The {@code UserManagement} interface defines the contract for managing user authentication
 * and registration in the Tharwa Investments system. Implementing classes, such as {@code AuthService},
 * must provide functionality for registering new users and authenticating existing users.
 */
import java.util.List;

public interface UserManagement {

    /**
     * Registers a new user with the provided details.
     *
     * @param name        the name of the user
     * @param email       the email address of the user (used as a unique identifier)
     * @param phone       the phone number of the user
     * @param password    the password for the user account
     * @param preferences a list of the user's investment preferences (e.g., Gold, Real Estate, Crypto)
     * @return {@code true} if registration is successful, {@code false} if the email is already registered
     */
    boolean register(String name, String email, String phone, String password, List<String> preferences);

    /**
     * Authenticates a user by verifying the provided email and password.
     *
     * @param email    the email address of the user
     * @param password the password to verify
     * @return {@code true} if the email exists and the password matches, {@code false} otherwise
     */
    boolean login(String email, String password);
}