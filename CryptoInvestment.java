/**
 * The {@code CryptoInvestment} class implements the {@code Investment} interface to represent
 * a cryptocurrency investment. It stores details about the cryptocurrency, including the coin name,
 * number of units, and price per unit, and provides methods to calculate the current value, return
 * on investment (ROI), edit investment details, and retrieve a string representation of the investment.
 */
import java.util.Scanner;

public class CryptoInvestment implements Investment {
    private String coinName;
    private double units;
    private double unitPrice;

    /**
     * Constructs a new {@code CryptoInvestment} with the specified coin name, number of units,
     * and price per unit.
     *
     * @param coinName  the name of the cryptocurrency (e.g., Bitcoin, Ethereum)
     * @param units     the number of units owned
     * @param unitPrice the price per unit of the cryptocurrency
     */
    public CryptoInvestment(String coinName, double units, double unitPrice) {
        this.coinName = coinName;
        this.units = units;
        this.unitPrice = unitPrice;
    }

    /**
     * Calculates the current total value of the cryptocurrency investment.
     *
     * @return the current value, calculated as the product of units and unit price
     */
    @Override
    public double calculateCurrentValue() {
        return units * unitPrice;
    }

    /**
     * Calculates the return on investment (ROI) for the cryptocurrency.
     * This implementation returns a fixed ROI of 7%.
     *
     * @return the ROI as a {@code double}, currently fixed at 0.07 (7%)
     */
    @Override
    public double calculateROI() {
        return 0.07;
    }

    /**
     * Edits the investment details by prompting the user to input new values for units
     * and unit price using a {@code Scanner}.
     *
     * @param sc the {@code Scanner} used to read user input
     */
    @Override
    public void edit(Scanner sc) {
        System.out.print("New units: ");
        this.units = sc.nextDouble();
        System.out.print("New price per unit: ");
        this.unitPrice = sc.nextDouble();
    }

    /**
     * Returns a string representation of the cryptocurrency investment.
     *
     * @return a string containing the coin name, number of units, and price per unit
     */
    @Override
    public String toString() {
        return "Crypto: " + coinName + ", Units: " + units + ", Price/Unit: " + unitPrice;
    }
}