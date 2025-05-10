import java.util.Scanner;

public class RealEstateInvestment implements Investment {
    private String location;
    private double price;
    private double rentalIncome;

    public RealEstateInvestment(String location, double price, double rentalIncome) {
        this.location = location;
        this.price = price;
        this.rentalIncome = rentalIncome;
    }

    public double calculateCurrentValue() {
        return price + rentalIncome * 12;
    }

    public double calculateROI() {
        return (rentalIncome * 12) / price;
    }

    public void edit(Scanner sc) {
        System.out.print("New price: ");
        this.price = sc.nextDouble();
        System.out.print("New rental income: ");
        this.rentalIncome = sc.nextDouble();
    }

    public String toString() {
        return "RealEstate: " + location + ", Price: " + price + ", Income: " + rentalIncome;
    }
}
