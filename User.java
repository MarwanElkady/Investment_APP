import java.util.List;

public class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<String> preferences;

    public User(String name, String email, String phone, String password, List<String> preferences) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.preferences = preferences;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<String> getPreferences() { return preferences; }
}
