import java.util.Scanner;

public class CryptoInvestment implements Investment {
    private String coinName;
    private double units;
    private double unitPrice;

    public CryptoInvestment(String coinName, double units, double unitPrice) {
        this.coinName = coinName;
        this.units = units;
        this.unitPrice = unitPrice;
    }

    public double calculateCurrentValue() {
        return units * unitPrice;
    }

    public double calculateROI() {
        return 0.07;
    }

    public void edit(Scanner sc) {
        System.out.print("New units: ");
        this.units = sc.nextDouble();
        System.out.print("New price per unit: ");
        this.unitPrice = sc.nextDouble();
    }

    public String toString() {
        return "Crypto: " + coinName + ", Units: " + units + ", Price/Unit: " + unitPrice;
    }
}
