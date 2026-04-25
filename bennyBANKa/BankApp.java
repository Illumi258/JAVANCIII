import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            if (currentUser == null) showAuthMenu();
            else showBankingMenu();
        }
    }

    private static void showAuthMenu() {
        System.out.println("\n--- Java Bank Main Menu ---");
        System.out.println("1. Register (Create Account)\n2. Login (Using Account Number)\n3. Exit");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) register();
        else if (choice.equals("2")) login();
        else if (choice.equals("3")) System.exit(0);
    }

    private static void register() {
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Create Password: ");
        String pass = scanner.nextLine();
        System.out.print("Initial Deposit: ");
        
        try {
            double deposit = Double.parseDouble(scanner.nextLine());
            // Generate a unique account number based on list size
            String accNum = "1000" + (users.size() + 1); 
            
            Account newAcc = new Account(name, accNum, deposit);
            users.add(new User(name, accNum, pass, newAcc));
            
            System.out.println("\nRegistration Successful!");
            System.out.println("IMPORTANT: Your Account Number is: " + accNum);
        } catch (Exception e) {
            System.out.println("Invalid input. Registration failed.");
        }
    }

    private static void login() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        for (User u : users) {
            if (u.getAccountNumber().equals(accNum) && u.authenticate(pass)) {
                currentUser = u;
                System.out.println("\nLogin Successful! Welcome, " + currentUser.getName());
                return;
            }
        }
        System.out.println("Invalid Account Number or Password.");
    }

    private static void showBankingMenu() {
        System.out.println("\n--- Welcome, " + currentUser.getName() + " (" + currentUser.getAccountNumber() + ") ---");
        System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Send Money\n5. Transaction History\n6. Logout");
        System.out.print("Choice: ");
        
        String choice = scanner.nextLine();
        Account acc = currentUser.getAccount();

        switch (choice) {
            case "1": System.out.println("Current Balance: $" + acc.getBalance()); break;
            case "2":
                System.out.print("Amount: ");
                acc.deposit(Double.parseDouble(scanner.nextLine()));
                break;
            case "3":
                System.out.print("Amount: ");
                acc.withdraw(Double.parseDouble(scanner.nextLine()));
                break;
            case "4":
                handleSendMoney();
                break;
            case "5":
                acc.displayHistory();
                break;
            case "6":
                currentUser = null;
                System.out.println("Logged out successfully.");
                break;
        }
    }

    private static void handleSendMoney() {
        System.out.print("Recipient Account #: ");
        String target = scanner.nextLine();
        System.out.print("Amount: ");
        try {
            double amt = Double.parseDouble(scanner.nextLine());
            if (SendMoney.execute(currentUser, target, amt, users)) {
                System.out.println("Transfer successful!");
            }
        } catch (Exception e) {
            System.out.println("Invalid amount entry.");
        }
    }
}