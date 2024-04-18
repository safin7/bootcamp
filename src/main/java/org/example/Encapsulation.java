package org.example;

public class Encapsulation {
    public static void main(String[] args) {

    }

}
class BankAccount{
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+= amount;
            System.out.println(amount+ " has been deposited");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount <= balance){

        }
    }
}
