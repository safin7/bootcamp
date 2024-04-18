package SimpleBankingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ronaldo",12351451,123,12412.42);
        Application application = new Application(customer);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my banking application!");
        System.out.println("Enter your Pin");
        int pin = scanner.nextInt();
        if (pin==customer.getPinNumber()){
            System.out.println("Pin is correct!!, Choose an option");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter amount to be deposited");
                    double depositAmount = scanner.nextDouble();
                    application.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Select Withdrawal amount");
                    double with = scanner.nextDouble();
                    application.withdraw(with,pin);
                    break;
                case 3:
                    System.out.println("Enter the pin to check balance");
                    int checkBalancePin = scanner.nextInt();
                    application.checkBalance(checkBalancePin);
                    break;
                default:
                    System.out.println("Invalid Option");
            }


        }else System.out.println("incorrect pin ");
    }
}

