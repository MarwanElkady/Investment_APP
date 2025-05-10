/**
 * The {@code BankAccount} interface defines the contract for managing a bank account.
 * Implementing classes must provide functionality for synchronizing the account,
 * retrieving the balance, retrieving the bank name, and updating the balance.
 */
public interface BankAccount {

    /**
     * Synchronizes the account with the bank's system to ensure the account data is up-to-date.
     *
     * @return {@code true} if synchronization is successful, {@code false} otherwise
     */
    boolean syncAccount();

    /**
     * Retrieves the current balance of the bank account.
     *
     * @return the current balance as a {@code double}
     */
    double getBalance();

    /**
     * Retrieves the name of the bank associated with the account.
     *
     * @return the name of the bank as a {@code String}
     */
    String getBankName();

    /**
     * Sets a new balance for the bank account.
     *
     * @param newBalance the new balance to set
     */
    void setBalance(double newBalance);
}