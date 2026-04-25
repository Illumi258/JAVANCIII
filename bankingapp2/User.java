public class User {
    private String username;
    private String password;
    private Account account; // Link to the user's bank account

    public User(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public String getUsername() { return username; }
    
    public boolean authenticate(String pass) {
        return this.password.equals(pass);
    }

    public Account getAccount() { return account; }
}