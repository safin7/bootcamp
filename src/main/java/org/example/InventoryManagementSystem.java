package org.example;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(5);


        inventory.addProduct(new Product("Apple", 0.50, 100));
        inventory.addProduct(new Product("Banana", 0.30, 150));


        inventory.customerPurchase("Apple", 2);


        inventory.shopPurchase("Banana", 50);


        inventory.displayInventory();
    }
}
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void purchase(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Not enough inventory for product: " + this.name);
        }
    }
}

class Inventory {
    private Product[] products;
    private int count;

    public Inventory(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Inventory is full, cannot add more products.");
        }
    }

    public void customerPurchase(String productName, int quantity) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                products[i].purchase(quantity);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    public void shopPurchase(String productName, int quantity) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                products[i].setQuantity(products[i].getQuantity() + quantity);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    public void displayInventory() {
        System.out.println("Inventory at the end of the day:");
        for (int i = 0; i < count; i++) {
            System.out.println("Product: " + products[i].getName() +
                    ", Price: " + products[i].getPrice() +
                    ", Quantity: " + products[i].getQuantity());
        }
    }
}


