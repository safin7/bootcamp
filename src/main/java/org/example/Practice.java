package org.example;

public class Practice {
    public static void main(String[] args) {
        System.out.println(nCopies("hello",5));
    }
    public static String nCopies(String str, int n){
        String result = " ";
        for(int i=0;i<n;i++){
            result = result.concat(str);
        }
        return result;
    }
    public static boolean x(String str) {
        return str.contains("xx");
    }

    public static int countNines(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 9) {
                count++;
            }
        }
        return count;
    }

    public static String removeYak(String str) {
        return str.replaceAll("y.k", "");
    }


}


