public class App {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount("12345678", 500.00, "Nirvan", "nb@test.com", "51234123");

        //Successful deposit
        account.deposit(10);

        //Invalid deposit
        account.deposit(-5);

        //Successful withdrawal
        account.withdraw(10);

        //Invalid withdrawal
        account.withdraw(1000);
    }
}
