package org.example;

public class StringMethods {
    public static void main(String[] args) {
        String s = "This is a string";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.length());
        System.out.println(s.concat("java is fun"));
        System.out.println(s.indexOf("a"));
        System.out.println(s.substring(4,10));
        System.out.println(s.startsWith("hello"));
        System.out.println(s.endsWith("fun"));
        System.out.println(s.charAt(0));
    }
}
