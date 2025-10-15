package Ch45_ex2;

public class BankApp {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("RO001", "Alice", 1000);
        BankAccount acc2 = new BankAccount("RO002", "Bob", 500);
        BankAccount acc3 = new BankAccount("RO003", "Charlie", 0);

        acc1.displayInfo();
        acc2.displayInfo();
        acc3.displayInfo();

        System.out.println("\n--- Transactions ---");

        acc1.deposit(200);
        acc2.deposit(150);
        acc3.deposit(300);

        acc1.withdraw(100);
        acc2.withdraw(700);
        acc3.withdraw(50);

        System.out.println("\n--- Final Balances ---");
        acc1.displayInfo();
        acc2.displayInfo();
        acc3.displayInfo();
    }
}