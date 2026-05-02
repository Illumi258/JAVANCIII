public class User {
    private String name;
    private String accountNumber;
    private String password;
    private Account account;

    public User(String name, String accountNumber, String password, Account account) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.account = account;
    }

    public String getName() { return name; }
    public String getAccountNumber() { return accountNumber; }
    public boolean authenticate(String pass) { return this.password.equals(pass); }
    public Account getAccount() { return account; }
}