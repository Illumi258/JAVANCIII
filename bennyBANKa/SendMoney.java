import java.util.ArrayList;

public class SendMoney {
    public static boolean execute(User sender, String recipientAccNum, double amount, ArrayList<User> users) {
        User recipient = null;

        for (User u : users) {
            if (u.getAccountNumber().equals(recipientAccNum)) {
                recipient = u;
                break;
            }
        }

        if (recipient == null) {
            System.out.println("Error: Recipient account not found.");
            return false;
        }

        if (recipient.getAccountNumber().equals(sender.getAccountNumber())) {
            System.out.println("Error: You cannot send money to yourself.");
            return false;
        }

        if (sender.getAccount().transferOut(amount, recipientAccNum)) {
            recipient.getAccount().transferIn(amount, sender.getAccountNumber());
            return true;
        } else {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
    }
}