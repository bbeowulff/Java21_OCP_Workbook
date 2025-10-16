package Ch45_ex7;

interface Payable
{
    void pay(double amount);
}

interface Refundable
{
    void refund(double amount);
}

class CreditCard implements Payable, Refundable
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }

    @Override
    public void refund(double amount)
    {
        System.out.println("Refunded $" + amount + " to Credit Card.");
    }
}

class PayPal implements Payable, Refundable
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid $" + amount + " via PayPal.");
    }

    @Override
    public void refund(double amount)
    {
        System.out.println("Refunded $" + amount + " through PayPal.");
    }
}

class Crypto implements Payable
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid $" + amount + " using Cryptocurrency.");
    }
}

public class PaymentSystemInterface
{
    static void processPayment(Payable p, double amount)
    {
        p.pay(amount);
    }

    public static void main(String[] args)
    {
        Payable card = new CreditCard();
        Payable paypal = new PayPal();
        Payable crypto = new Crypto();

        processPayment(card, 100.0);
        processPayment(paypal, 50.0);
        processPayment(crypto, 25.0);

        System.out.println();

        Refundable r = new PayPal();
        r.refund(20.0);
    }
}
