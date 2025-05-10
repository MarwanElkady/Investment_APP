/**
 * The {@code GoldInvestment} class implements the {@code Investment} interface to represent
 * a gold investment. It stores details about the gold, including the weight in grams and price
 * per gram, and provides methods to calculate the current value, return on investment (ROI),
 * edit investment details, and retrieve a string representation of the investment.
 */
import java.util.Scanner;

public class GoldInvestment implements Investment {
    private double grams;
    private double pricePerGram;

    /**
     * Constructs a new {@code GoldInvestment} with the specified weight in grams and price per gram.
     *
     * @param grams         the weight of the gold in grams
     * @param pricePerGram  the price per gram of gold
     */
    public GoldInvestment(double grams, double pricePerGram) {
        this.grams = grams;
        this.pricePerGram = pricePerGram;
    }

    /**
     * Calculates the current total value of the gold investment.
     *
     * @return the current value, calculated as the product of grams and price per gram
     */
    @Override
    public double calculateCurrentValue() {
        return grams * pricePerGram;
    }

    /**
     * Calculates the return on investment (ROI) for the gold investment.
     * This implementation returns a fixed ROI of 5%.
     *
     * @return the ROI as a {@code double}, currently fixed at 0.05 (5%)
     */
    @Override
    public double calculateROI() {
        return 0.05;
    }

    /**
     * Edits the investment details by prompting the user to input new values for grams
     * and price per gram using a {@code Scanner}.
     *
     * @param sc the {@code Scanner} used to read user input
     */
    @Override
    public void edit(Scanner sc) {
        System.out.print("New grams: ");
        this.grams = sc.nextDouble();
        System.out.print("New price per gram: ");
        this.pricePerGram = sc.nextDouble();
    }

    /**
     * Returns a string representation of the gold investment.
     *
     * @return a string containing the weight in grams and price per gram
     */
    @Override
    public String toString() {
        return "Gold: " + grams + "g @ " + pricePerGram + "/g";
    }
}