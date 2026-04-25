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
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("WITHDRAWAL", amount);
            return true;
        }
        return false;
    }

    public boolean transferOut(double amount, String toAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("SENT TO " + toAccount, amount);
            return true;
        }
        return false;
    }

    public void transferIn(double amount, String fromAccount) {
        balance += amount;
        addTransaction("RECEIVED FROM " + fromAccount, amount);
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
}