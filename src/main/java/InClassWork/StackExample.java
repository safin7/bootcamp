package InClassWork;

import java.util.Stack;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        String original = "Civic";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) { // Use isEmpty instead of empty for better readability
            sb.append(stack.pop());
        }

        return sb.toString(); // Return the reversed string
    }
}



