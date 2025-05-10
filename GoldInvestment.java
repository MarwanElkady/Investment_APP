import java.util.Scanner;

public class GoldInvestment implements Investment {
    private double grams;
    private double pricePerGram;

    public GoldInvestment(double grams, double pricePerGram) {
        this.grams = grams;
        this.pricePerGram = pricePerGram;
    }

    public double calculateCurrentValue() {
        return grams * pricePerGram;
    }

    public double calculateROI() {
        return 0.05;
    }

    public void edit(Scanner sc) {
        System.out.print("New grams: ");
        this.grams = sc.nextDouble();
        System.out.print("New price per gram: ");
        this.pricePerGram = sc.nextDouble();
    }

    public String toString() {
        return "Gold: " + grams + "g @ " + pricePerGram + "/g";
    }
}
