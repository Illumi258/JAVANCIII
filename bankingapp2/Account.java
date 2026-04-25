import java.util.ArrayList;

public class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountHolder, String accountNumber, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        
        // Record the opening of the account
        addTransaction("INITIAL", initialDeposit);
    }

    private void addTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount));
    }

    public void displayHistory() {
        System.out.println("\n--- Transaction History for " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public String getAccountNumber() { 
        return accountNumber; 
    }

    public double getBalance() { 
        return balance; 
    }

    public String getHolder() { 
        return accountHolder; 
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("DEPOSIT", amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("WITHDRAW", amount);
            return true;
        }
        return false;
    }
}