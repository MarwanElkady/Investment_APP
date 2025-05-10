public interface BankAccount {
    boolean syncAccount();
    double getBalance();
    String getBankName();
    void setBalance(double newBalance);
}
