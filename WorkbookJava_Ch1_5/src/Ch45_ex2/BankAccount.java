package Ch45_ex2;

public class BankAccount
{

    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance)
    {
        this.accountNumber = accountNumber;
        this.owner = owner;
        setBalance(balance);
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        if (accountNumber == null || accountNumber.isBlank())
        {
            System.out.println("Invalid account number.");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        if (owner == null || owner.isBlank())
        {
            System.out.println("Invalid owner name.");
            return;
        }
        this.owner = owner;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        if (balance < 0)
        {
            System.out.println("Balance cannot be negative. Setting to 0.");
            this.balance = 0;
        } else
        {
            this.balance = balance;
        }
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        this.balance += amount;
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
    }

    public void withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance)
        {
            System.out.println("Insufficient funds.");
            return;
        }
        this.balance -= amount;
        System.out.printf("Withdrew %.2f. New balance: %.2f%n", amount, balance);
    }

    public void displayInfo()
    {
        System.out.printf("Account %s | Owner: %s | Balance: %.2f%n", accountNumber, owner, balance);
    }
}
