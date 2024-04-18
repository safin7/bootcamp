package org.example;

public class JavaRecursion {

    public static void main(String[] args) {

        RecursiveMethod.a();
        System.out.println(nthTerm(6));
    }
    public static int nthTerm(int n){
        int ans = 0;
        for (int i = 1; i <= n; i++)
            ans += i;

        return ans;

    }

    static class RecursiveMethod {
        static int count = 0;

        static void a() {
            count++;
            if (count <= 10) {
                System.out.println("number " + count);
                a(); // Correct recursive call
            }
        }

        static int factorial(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }

        static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }
}
