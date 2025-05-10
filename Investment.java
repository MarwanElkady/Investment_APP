import java.util.Scanner;

public interface Investment {
    double calculateCurrentValue();
    double calculateROI();
    void edit(Scanner sc);
}
