public class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor to initialize the account
    public Account(String accountHolder, String accountNumber, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    // Getters for retrieving info
    public String getAccountNumber() { 
        return accountNumber; 
    }

    public double getBalance() { 
        return balance; 
    }

    public String getHolder() { 
        return accountHolder; 
    }

    // Method to add money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to remove money (returns false if balance is too low)
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}