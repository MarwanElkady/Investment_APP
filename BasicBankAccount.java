/**
 * The {@code BasicBankAccount} class implements the {@code BankAccount} interface to provide
 * basic functionality for managing a bank account. It stores the bank name, account number,
 * and balance, and supports operations to synchronize the account, retrieve the balance,
 * update the balance, and retrieve the bank name.
 */
public class BasicBankAccount implements BankAccount {
    private String bankName;
    private String accountNumber;
    private double balance;

    /**
     * Constructs a new {@code BasicBankAccount} with the specified bank name, account number,
     * and initial balance.
     *
     * @param bankName      the name of the bank
     * @param accountNumber the account number
     * @param initialBalance the initial balance of the account
     */
    public BasicBankAccount(String bankName, String accountNumber, double initialBalance) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Retrieves the account number of the bank account.
     *
     * @return the account number as a {@code String}
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Synchronizes the account with the bank's system. This implementation always returns
     * {@code true}, indicating a successful synchronization.
     *
     * @return {@code true} indicating successful synchronization
     */
    @Override
    public boolean syncAccount() {
        return true;
    }

    /**
     * Retrieves the current balance of the bank account.
     *
     * @return the current balance as a {@code double}
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Sets a new balance for the bank account.
     *
     * @param newBalance the new balance to set
     */
    @Override
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Retrieves the name of the bank associated with the account.
     *
     * @return the name of the bank as a {@code String}
     */
    @Override
    public String getBankName() {
        return bankName;
    }
}