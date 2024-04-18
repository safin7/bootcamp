package JavaExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        eligibility(input);




    }

    public static void eligibility(int age) {
        try {
            if (age >= 18) {
                System.out.println("Eligible");
            } else {
                System.out.println("not eligble");

            }
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("Please enter correct age ");

        }

    }



    public static   void divide(int a, int b){
        try {
            System.out.println(a/b);
        }catch (ArithmeticException e){
            e.getMessage();
        }
        System.out.println("tr");

    }
    public static void numberFormat() {
        try {
            String str = "Hello Java";
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    }

