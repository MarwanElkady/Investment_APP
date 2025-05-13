/**
 * Tharwa Investments App
 * A console-based investment and bank management application.
 * Supports Gold, Real Estate, and Crypto asset tracking and Zakat calculation.
 *
 * Author(s): Seif Wael - Mohamed Waleed - Marwan Ibraheem
 * Version: 1.0
 */
/**
 * The {@code MainApp} class serves as the entry point for the Tharwa Investments application.
 * It provides a console-based interface for user authentication, portfolio management, and bank account
 * management. Users can sign up, log in, add/edit/remove investments, connect bank accounts, view balances,
 * and calculate zakat (charitable contribution) based on their total assets.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    /**
     * The main method that runs the Tharwa Investments application.
     * It handles user authentication via {@code AuthService}, manages investment and bank account operations
     * via {@code PortfolioManager}, and provides a menu-driven interface for user interactions.
     *
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        PortfolioManager manager = new PortfolioManager();

        System.out.println("Welcome to Tharwa Investments\n1. Sign Up\n2. Log In");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Enter phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            System.out.println("Select investment interests (1=Gold, 2=Real Estate, 3=Crypto), separated by commas:");
            String[] input = sc.nextLine().split(",");
            List<String> prefs = new ArrayList<>();
            for (String opt : input) {
                if (opt.trim().equals("1")) prefs.add("Gold");
                if (opt.trim().equals("2")) prefs.add("Real Estate");
                if (opt.trim().equals("3")) prefs.add("Crypto");
            }
            auth.register(name, email, phone, pass, prefs);
        }

        System.out.println("Now, enter login info.");
        System.out.print("Email: ");
        String loginEmail = sc.nextLine();
        System.out.print("Password: ");
        String loginPass = sc.nextLine();

        if (auth.login(loginEmail, loginPass)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Add Asset\n2. View Zakat\n3. View Portfolio\n4. Edit Asset\n5. Remove Asset\n6. Connect Bank Account\n7. View Bank Balances\n8. Edit Bank Balance\n9. Exit");
                int action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 1:
                        System.out.println("Choose asset type: 1) Real Estate 2) Gold 3) Crypto");
                        int type = sc.nextInt();
                        sc.nextLine();
                        if (type == 1) {
                            System.out.print("Enter location: ");
                            String loc = sc.nextLine();
                            System.out.print("Enter price: ");
                            double pr = sc.nextDouble();
                            System.out.print("Enter rental income: ");
                            double ri = sc.nextDouble();
                            manager.addRealEstate(loc, pr, ri);
                        } else if (type == 2) {
                            System.out.print("Enter grams: ");
                            double grams = sc.nextDouble();
                            System.out.print("Enter price per gram: ");
                            double ppg = sc.nextDouble();
                            manager.addGold(grams, ppg);
                        } else if (type == 3) {
                            System.out.print("Enter coin name: ");
                            String coin = sc.nextLine();
                            System.out.print("Enter units: ");
                            double units = sc.nextDouble();
                            System.out.print("Enter price per unit: ");
                            double unitPrice = sc.nextDouble();
                            manager.addCrypto(coin, units, unitPrice);
                        }
                        break;
                    case 2:
                        double investmentsTotal = 0;
                        for (Investment inv : manager.listAssets()) {
                            investmentsTotal += inv.calculateCurrentValue();
                        }
                        
                        double bankTotal = 0;
                        for (BankAccount account : manager.getBankAccounts()) {
                            bankTotal += account.getBalance();
                        }
                        
                        double totalAssets = investmentsTotal + bankTotal;
                        double nisab = 425000; // EGP equivalent of 85g gold
                        double zakatDue = totalAssets >= nisab ? totalAssets * 0.025 : 0;
                        
                        System.out.println("\n=== Zakah Calculation ===");
                        System.out.printf("Investments Value: %.2f EGP%n", investmentsTotal);
                        System.out.printf("Bank Accounts Value: %.2f EGP%n", bankTotal);
                        System.out.printf("Total Assets: %.2f EGP%n", totalAssets);
                        System.out.printf("Nisab Threshold: %.2f EGP%n", nisab);
                        if (totalAssets >= nisab) {
                            System.out.printf("Zakah Due (2.5%%): %.2f EGP%n", zakatDue);
                        } else {
                            System.out.println("No Zakah due (Total assets below Nisab)");
                        }
                        break;
                    case 3:
                        List<Investment> assets = manager.listAssets();
                        for (int i = 0; i < assets.size(); i++) {
                            System.out.println(i + ": " + assets.get(i));
                        }
                        break;
                    case 4:
                        System.out.print("Enter asset index to edit: ");
                        int edx = sc.nextInt();
                        sc.nextLine();
                        manager.editAsset(edx, sc);
                        break;
                    case 5:
                        System.out.print("Enter index to remove: ");
                        int idx = sc.nextInt();
                        manager.removeAssetByIndex(idx);
                        break;
                    case 6:
                        System.out.print("Enter bank name: ");
                        String bank = sc.nextLine();
                        System.out.print("Enter account number: ");
                        String acc = sc.nextLine();
                        System.out.print("Enter starting balance: ");
                        double bal = sc.nextDouble();
                        BankAccount b = new BasicBankAccount(bank, acc, bal);
                        manager.addBankAccount(b);
                        System.out.println("Bank account added.");
                        break;
                    case 7:
                        for (int i = 0; i < manager.getBankAccounts().size(); i++) {
                            BankAccount ba = manager.getBankAccounts().get(i);
                            System.out.println(i + ": " + ba.getBankName() + " - Balance: " + ba.getBalance() + " EGP");
                        }
                        break;
                    case 8:
                        System.out.print("Enter bank index to edit: ");
                        int bidx = sc.nextInt();
                        if (bidx >= 0 && bidx < manager.getBankAccounts().size()) {
                            System.out.print("Enter new balance: ");
                            double nb = sc.nextDouble();
                            manager.getBankAccounts().get(bidx).setBalance(nb);
                            System.out.println("Balance updated.");
                        }
                        break;
                    case 9:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid login.");
        }

        sc.close();
    }
}