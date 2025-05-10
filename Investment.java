/**
 * The {@code Investment} interface defines the contract for managing investment assets.
 * Implementing classes must provide functionality to calculate the current value, calculate
 * the return on investment (ROI), and edit investment details using a {@code Scanner}.
 */
import java.util.Scanner;

public interface Investment {

    /**
     * Calculates the current total value of the investment.
     *
     * @return the current value of the investment as a {@code double}
     */
    double calculateCurrentValue();

    /**
     * Calculates the return on investment (ROI) for the investment.
     *
     * @return the ROI as a {@code double}, typically expressed as a decimal (e.g., 0.05 for 5%)
     */
    double calculateROI();

    /**
     * Edits the investment details by prompting the user for new values using a {@code Scanner}.
     *
     * @param sc the {@code Scanner} used to read user input
     */
    void edit(Scanner sc);
}