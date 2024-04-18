package JavaExceptionHandling;

public class Prac {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        seventh(numbers);


    }
    public static void seventh(int[] numbers){
        try {
            int seventhNumber = numbers[6];
            System.out.println("The seventh number is: " + seventhNumber);
        }
        finally {
            System.out.println("sds");
        }

    }
    }


