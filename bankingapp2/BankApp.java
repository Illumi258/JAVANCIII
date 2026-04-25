import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            if (currentUser == null) {
                showAuthMenu();
            } else {
                showBankingMenu();
            }
        }
    }

    private static void showAuthMenu() {
        System.out.println("\n--- Welcome to Java Bank ---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choice: ");
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                register();
                break;
            case "2":
                login();
                break;
            case "3":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    private static void register() {
        System.out.print("Create Username: ");
        String user = scanner.nextLine();
        System.out.print("Create Password: ");
        String pass = scanner.nextLine();
        System.out.print("Initial Deposit: ");
        
        try {
            double deposit = Double.parseDouble(scanner.nextLine());
            // Create the account and link it to the user
            String accNum = "ACC" + (users.size() + 100);
            Account newAcc = new Account(user, accNum, deposit);
            users.add(new User(user, pass, newAcc));
            System.out.println("Registration successful! Account Number: " + accNum);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Registration failed.");
        }
    }

    private static void login() {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(user) && u.authenticate(pass)) {
                currentUser = u;
                System.out.println("Login Successful! Welcome, " + user);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private static void showBankingMenu() {
        System.out.println("\n--- Dashboard (" + currentUser.getUsername() + ") ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
        System.out.print("Choice: ");

        String choice = scanner.nextLine();
        Account acc = currentUser.getAccount();

        switch (choice) {
            case "1":
                System.out.println("Current Balance: $" + acc.getBalance());
                break;
            case "2":
                System.out.print("Amount to deposit: ");
                try {
                    acc.deposit(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Deposit successful.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount.");
                }
                break;
            case "3":
                System.out.print("Amount to withdraw: ");
                try {
                    double amt = Double.parseDouble(scanner.nextLine());
                    if (acc.withdraw(amt)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount.");
                }
                break;
            case "4":
                currentUser = null;
                System.out.println("Logged out.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}