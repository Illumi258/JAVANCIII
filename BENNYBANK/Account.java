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
        addTransaction("INITIAL DEPOSIT", initialDeposit);
    }

    public void addTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount));
    }

    public void displayHistory() {
        System.out.println("\n--- History for Account: " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("DEPOSIT", amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            addTransaction("WITHDRAWAL", amount);
            return true;
        } else {
            // Insufficient funds error message
            System.out.println("Error: Insufficient balance. Current balance: " + balance + ", Attempted: " + amount);
            return false;
        }
    }

    public boolean transferOut(double amount, String toAccount) {
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be positive.");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            addTransaction("SENT TO " + toAccount, amount);
            return true;
        } else {
            // Insufficient funds error message for transfers
            System.out.println("Error: Transfer failed. Insufficient funds in account " + accountNumber);
            return false;
        }
    }

    public void transferIn(double amount, String fromAccount) {
        balance += amount;
        addTransaction("RECEIVED FROM " + fromAccount, amount);
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
}