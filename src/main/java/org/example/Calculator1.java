package org.example;

public class Calculator1 {

    public double add(double a, double b) {
        return a + b;
    }
    public double add(double a, double b, double c) {
        return a + b + c;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public double subtract(double a, double b, double c) {
        return a - b - c;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double multiply(double a, double b, double c) {
        return a * b * c;
    }


    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
        }
        return a / b;
    }

    public double divide(double a, double b, double c) {
        if (b == 0 || c == 0) {
            System.out.println("Cannot divide by zero");
        }
        return a / b / c;
    }


    public double mod(double a, double b) {
        return a % b;
    }

    public double mod(double a, double b, double c) {
        return a % b % c;
    }

}
class calcMain{
    public static void main(String[] args) {
        Calculator1 calc = new Calculator1();

        System.out.println(calc.add(1.5, 2.5));
        System.out.println(calc.add(1, 2, 3));
        System.out.println(calc.subtract(10, 5));
        System.out.println(calc.subtract(20, 5, 3));
        System.out.println(calc.multiply(3, 4));
        System.out.println(calc.multiply(2, 3, 4));
        System.out.println(calc.divide(10, 2));
        System.out.println(calc.divide(20, 2, 2));
        System.out.println(calc.mod(10, 3));
        System.out.println(calc.mod(20, 3, 2));


    }

}