package org.example;

public class Homework {
    public static void main(String[] args) {
        System.out.println("Answer 1");
        System.out.println(isTeen(11,24,13));
        System.out.println("Answer 2");
        System.out.println(inTrouble(true,false));
        System.out.println("Answer 3");
        System.out.println(talkingParrot(15,true));
        System.out.println("Answer 4");
        System.out.println(tempMeasure(44,140));
        System.out.println("Answer 5");
        System.out.println(sameLastDigit(27,27));
        System.out.println("Answer 6");
        System.out.println(twoSum(20,20));
        System.out.println("Answer 7");
        System.out.println(isTen(5,5));
        System.out.println("Answer 8");
        System.out.println(largest(52,19));
        System.out.println("Answer 9");
        System.out.println(inRange(14,124));
        System.out.println("Answer 10");
        System.out.println(isMultiple(25,13));
    }
    public static boolean isTeen(int i, int j, int k){
       return ((i>=13 && i<=19) || (j>=13 && j<=19) || k>=13 && k<=19);
        }
    public static boolean inTrouble(boolean aSmile, boolean bSmile) {
        return (aSmile && bSmile) || (!aSmile && !bSmile);
    }
    public static boolean talkingParrot(int hour, boolean  isTalking){
        return isTalking && (hour < 7 || hour > 20);
    }
    public static boolean tempMeasure(int i, int j ){
        return (i<0 && j>100) || (j<0 && i>100);
    }
    public static boolean sameLastDigit(int i,int j){
        return i % 10 == j % 10;
    }

    public static int twoSum(int i, int j){
        if(i == j ){
            return (i+j)*2;
        }else return i+j;
    }

    public static boolean isTen(int a, int b ){
        return (a == 10 || b == 10) || (a + b) == 10;

    }
    //wrong answer
    //Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or return 0 if neither is in that range.
    public static int largest(int a, int b){
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }


    public static boolean inRange(int i, int j){
        return (i >= 10 && i <= 20) || (j >= 10 && j <= 20);
    }

    public static boolean isMultiple(int i, int j){
        return (i % 3 == 0 || i % 5 == 0) || ((j % 3 == 0 || j % 5 == 0));

    }




    }




