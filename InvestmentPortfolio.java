import java.util.ArrayList;
import java.util.List;

public class InvestmentPortfolio {
    private List<Investment> assets = new ArrayList<>();

    public void addInvestment(Investment inv) {
        assets.add(inv);
    }

    public void removeInvestment(int index) {
        if (index >= 0 && index < assets.size()) {
            assets.remove(index);
        }
    }

    public List<Investment> getAssets() {
        return assets;
    }

    public double calculateZakat() {
        double total = 0;
        for (Investment inv : assets) {
            total += inv.calculateCurrentValue();
        }
        return total;
    }
}
