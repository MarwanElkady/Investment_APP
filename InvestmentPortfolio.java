/**
 * The {@code InvestmentPortfolio} class manages a collection of investment assets.
 * It provides methods to add and remove investments, retrieve the list of investments,
 * and calculate the total value of the portfolio for zakat (charitable contribution) purposes.
 */
import java.util.ArrayList;
import java.util.List;

public class InvestmentPortfolio {
    private List<Investment> assets = new ArrayList<>();

    /**
     * Adds an investment to the portfolio.
     *
     * @param inv the {@code Investment} to add to the portfolio
     */
    public void addInvestment(Investment inv) {
        assets.add(inv);
    }

    /**
     * Removes an investment from the portfolio at the specified index.
     *
     * @param index the index of the investment to remove
     */
    public void removeInvestment(int index) {
        if (index >= 0 && index < assets.size()) {
            assets.remove(index);
        }
    }

    /**
     * Retrieves the list of investments in the portfolio.
     *
     * @return a {@code List} of {@code Investment} objects representing the portfolio's assets
     */
    public List<Investment> getAssets() {
        return assets;
    }

    /**
     * Calculates the total value of all investments in the portfolio for zakat purposes.
     * The calculation sums the current value of each investment as returned by
     * {@code Investment.calculateCurrentValue()}.
     *
     * @return the total value of the portfolio as a {@code double}
     */
    public double calculateZakat() {
        double total = 0;
        for (Investment inv : assets) {
            total += inv.calculateCurrentValue();
        }
        return total;
    }
}