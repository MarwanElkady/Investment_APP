// Full Tharwa Investments App in one Java file
import java.util.*;

interface UserManagement {
    boolean register(String name, String email, String phone, String password, String[] preferences);
    boolean login(String email, String password);
}

interface Investment {
    double calculateCurrentValue();
    double calculateROI();
}

interface BankAccount {
    boolean syncAccount();
    double getBalance();
    String getBankName();
}

class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<String> preferences;

    public User(String name, String email, String phone, String password, List<String> preferences) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.preferences = preferences;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}

class InvestmentPortfolio {
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
        double zakat = 0;
        for (Investment inv : assets) {
            zakat += inv.calculateCurrentValue() * 0.025;
        }
        return zakat;
    }
}

class RealEstateInvestment implements Investment {
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

    @Override
    public String toString() {
        return "RealEstate: " + location + ", Price: " + price + ", Income: " + rentalIncome;
    }
}

class BasicBankAccount implements BankAccount {
    private String bankName;
    private String accountNumber;
    private double balance;

    public BasicBankAccount(String bankName, String accountNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = Math.random() * 100000; // simulate fetch
    }

    public boolean syncAccount() {
        this.balance = Math.random() * 100000;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankName() {
        return bankName;
    }
}

class AuthService implements UserManagement {
    private Map<String, User> users = new HashMap<>();

    public boolean register(String name, String email, String phone, String password, String[] preferences) {
        if (users.containsKey(email)) return false;
        User newUser = new User(name, email, phone, password, Arrays.asList(preferences));
        users.put(email, newUser);
        System.out.println("Registered successfully! Redirecting to login...");
        return true;
    }

    public boolean login(String email, String password) {
        if (!users.containsKey(email)) return false;
        return users.get(email).getPassword().equals(password);
    }
}

class PortfolioManager {
    private InvestmentPortfolio portfolio = new InvestmentPortfolio();

    public void addRealEstate(String location, double price, double rental) {
        RealEstateInvestment r = new RealEstateInvestment(location, price, rental);
        portfolio.addInvestment(r);
    }

    public void removeAssetByIndex(int index) {
        portfolio.removeInvestment(index);
    }

    public List<Investment> listAssets() {
        return portfolio.getAssets();
    }

    public double calculateZakat() {
        return portfolio.calculateZakat();
    }
}

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        PortfolioManager manager = new PortfolioManager();
        List<BankAccount> bankAccounts = new ArrayList<>();

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
            System.out.print("Enter preferences (comma separated): ");
            String[] prefs = sc.nextLine().split(",");
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
                System.out.println("\n1. Add Real Estate\n2. View Zakat\n3. View Portfolio\n4. Remove Asset\n5. Connect Bank Account\n6. View Bank Balances\n7. Exit");
                int action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 1:
                        System.out.print("Enter location: ");
                        String loc = sc.nextLine();
                        System.out.print("Enter price: ");
                        double pr = sc.nextDouble();
                        System.out.print("Enter rental income: ");
                        double ri = sc.nextDouble();
                        manager.addRealEstate(loc, pr, ri);
                        break;
                    case 2:
                        System.out.println("Zakat due: " + manager.calculateZakat() + " EGP");
                        break;
                    case 3:
                        List<Investment> assets = manager.listAssets();
                        for (int i = 0; i < assets.size(); i++) {
                            System.out.println(i + ": " + assets.get(i));
                        }
                        break;
                    case 4:
                        System.out.print("Enter index to remove: ");
                        int idx = sc.nextInt();
                        manager.removeAssetByIndex(idx);
                        break;
                    case 5:
                        System.out.print("Enter bank name: ");
                        String bank = sc.nextLine();
                        System.out.print("Enter account number: ");
                        String acc = sc.nextLine();
                        BankAccount b = new BasicBankAccount(bank, acc);
                        b.syncAccount();
                        bankAccounts.add(b);
                        System.out.println("Bank account connected.");
                        break;
                    case 6:
                        for (BankAccount ba : bankAccounts) {
                            System.out.println(ba.getBankName() + ": " + ba.getBalance() + " EGP");
                        }
                        break;
                    case 7:
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
