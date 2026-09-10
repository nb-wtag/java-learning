public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this. customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount){
        if(amount < 0) { 
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            System.out.println("Deposit successful! New balance is: " + balance);
        }
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Invalid! Not enough money to withdraw");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Amount remaining: " + balance);
        }
    }

    public String getAccountNumber(){ return accountNumber; }
    public void setAccountNumber(String accountNumber){ this.accountNumber = accountNumber; }

    public double getBalance(){ return balance; }
    public void setBalance(double balance){ this.balance = balance; }

    public String getCustomerName(){ return customerName; }
    public void setCustomerName(String customerName){ this.customerName = customerName; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }

}

