package SimpleBankingApp;

public class Customer {
    private String name;
    private int accountNumber;
    private int pinNumber;
    private double balance;

    public Customer(String name, int accountNumber, int pinNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
