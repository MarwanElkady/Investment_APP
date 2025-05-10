public class BasicBankAccount implements BankAccount {
    private String bankName;
    private String accountNumber;
    private double balance;

    public BasicBankAccount(String bankName, String accountNumber, double initialBalance) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public boolean syncAccount() {
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public String getBankName() {
        return bankName;
    }
}
