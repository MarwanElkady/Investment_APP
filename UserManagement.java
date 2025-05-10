import java.util.List;

public interface UserManagement {
    boolean register(String name, String email, String phone, String password, List<String> preferences);
    boolean login(String email, String password);
}
