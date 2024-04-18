package org.example;

public class Calculator {

    public static void add( int i, int j){
        System.out.println("Result of addition is "+ (i+j));
    }
    public static void subtract(int i, int j){
        System.out.println("Result of subtraction is "+ (i-j));
    }
    public static void multiply(int i, int j){
        System.out.println("Result of multiplication is "+ (i*j));
    }
    public static void divide(int numerator, int denominator) {
        if(denominator ==0){
            System.out.println("Cannot divide by zero");
        }else
        System.out.println("Result of division is "+ (numerator/denominator));
    }
    public static void mod(int i, int j){
        System.out.println(i%j);
    }
    public static void increment(int i){
        System.out.println(++i);
    }
    public static void decrement(int j){
        System.out.println(++j);
    }

}
