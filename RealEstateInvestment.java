/**
 * The {@code RealEstateInvestment} class implements the {@code Investment} interface to represent
 * a real estate investment. It stores details about the property, including its location, price,
 * and monthly rental income, and provides methods to calculate the current value, return on investment
 * (ROI), edit investment details, and retrieve a string representation of the investment.
 */
import java.util.Scanner;

public class RealEstateInvestment implements Investment {
    private String location;
    private double price;
    private double rentalIncome;

    /**
     * Constructs a new {@code RealEstateInvestment} with the specified location, price, and monthly rental income.
     *
     * @param location      the location of the real estate property
     * @param price         the purchase price of the property
     * @param rentalIncome  the monthly rental income generated by the property
     */
    public RealEstateInvestment(String location, double price, double rentalIncome) {
        this.location = location;
        this.price = price;
        this.rentalIncome = rentalIncome;
    }

    /**
     * Calculates the current total value of the real estate investment.
     * The value is computed as the sum of the property price and the annual rental income
     * (monthly rental income multiplied by 12).
     *
     * @return the current value of the investment as a {@code double}
     */
    @Override
    public double calculateCurrentValue() {
        return price + rentalIncome * 12;
    }

    /**
     * Calculates the return on investment (ROI) for the real estate investment.
     * The ROI is computed as the annual rental income (monthly rental income multiplied by 12)
     * divided by the property price.
     *
     * @return the ROI as a {@code double}, expressed as a decimal
     */
    @Override
    public double calculateROI() {
        return (rentalIncome * 12) / price;
    }

    /**
     * Edits the investment details by prompting the user to input new values for the price
     * and monthly rental income using a {@code Scanner}.
     *
     * @param sc the {@code Scanner} used to read user input
     */
    @Override
    public void edit(Scanner sc) {
        System.out.print("New price: ");
        this.price = sc.nextDouble();
        System.out.print("New rental income: ");
        this.rentalIncome = sc.nextDouble();
    }

    /**
     * Returns a string representation of the real estate investment.
     *
     * @return a string containing the location, price, and monthly rental income
     */
    @Override
    public String toString() {
        return "RealEstate: " + location + ", Price: " + price + ", Income: " + rentalIncome;
    }
}