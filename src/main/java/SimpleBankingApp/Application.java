package SimpleBankingApp;

public class Application {
    private Customer customer;

    public Application(Customer customer) {
        this.customer = customer;
    }

    public void deposit(double amount) {
        customer.setBalance(customer.getBalance() + amount);
        System.out.println("Deposit Successful New Balance: " + customer.getBalance());
    }

    public void withdraw(double amount, int pin) {
        if (pin == customer.getPinNumber()) {
            if (customer.getBalance() >= amount) {
                customer.setBalance(customer.getBalance() - amount);
                System.out.println("Withdrawal Succesful New Balance: " + customer.getBalance());
            } else System.out.println("Incorrect Balance");
        } else System.out.println("incorrect pin");
    }
    public  void checkBalance(int pin){
        if(pin == customer.getPinNumber()){
            System.out.println("Current balance " + customer.getBalance());
        }else System.out.println("Incorrect pin ");
    }
}