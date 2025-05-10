import java.util.*;

public class PortfolioManager {
    private InvestmentPortfolio portfolio = new InvestmentPortfolio();
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void addRealEstate(String location, double price, double rental) {
        portfolio.addInvestment(new RealEstateInvestment(location, price, rental));
    }

    public void addGold(double grams, double pricePerGram) {
        portfolio.addInvestment(new GoldInvestment(grams, pricePerGram));
    }

    public void addCrypto(String coin, double units, double price) {
        portfolio.addInvestment(new CryptoInvestment(coin, units, price));
    }

    public void addBankAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void editAsset(int index, Scanner sc) {
        List<Investment> assets = portfolio.getAssets();
        if (index >= 0 && index < assets.size()) {
            assets.get(index).edit(sc);
        }
    }

    public void removeAssetByIndex(int index) {
        portfolio.removeInvestment(index);
    }

    public List<Investment> listAssets() {
        return portfolio.getAssets();
    }

    public double calculateZakat() {
        double investmentsTotal = portfolio.calculateZakat();

        double bankTotal = 0;
        for (BankAccount account : bankAccounts) {
            bankTotal += account.getBalance();
        }

        double nisab = 425000;
        double totalAssets = investmentsTotal + bankTotal;

        if (totalAssets < nisab) return 0;
        return totalAssets * 0.025;
    }
}
