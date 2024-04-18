package InClassWork;

public class ClassWork {
    public static void main(String[] args) {
        System.out.println(stringBits("Heeololeo"));
        int[] arr = {1, 1, 1, 1, 2, 3};
        System.out.println(array123(arr));
        System.out.println(stringSplosion("hello"));
        System.out.println(frontTimes("chocolate ", 3));
        System.out.println(helloName("Bob"));
        System.out.println(firstHalf("afsbca"));
        System.out.println(seeColor("reddaed"));
        int[] arr1 = {1,2,3,45,1};
        int[] arr2 = {1,24,5,6,3};
        System.out.println(commonEnd(arr1,arr2));
        System.out.println(start1(arr1,arr2));

    }

    public static String stringBits(String str) {
        String newString = "";

        for (int i = 0; i < str.length(); i += 2) {
            newString += str.charAt(i);

        }
        return newString;
    }

    public static Boolean array123(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] == 1) && (arr[i + 1] == 2) && (arr[i + 2] == 3)) {
                return true;
            }
        }
        return false;
    }

    public static String stringSplosion(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            result += str.substring(0, i + 1);

        }
        return result;

    }

    public static String frontTimes(String str, int repeat) {
        String result = "";
        String front;
        if (str.length() < 3) {
            front = str;
        } else {
            front = str.substring(0, 3);
        }
        for (int i = 0; i < repeat; i++) {
            result += front;

        }
        return result;

    }

    public static String helloName(String name) {
        return "Hello " + name;
    }

    public static String firstHalf(String str) {
        if (str.length() % 2 == 0) {
            return str.substring(0, str.length() / 2);
        } else return "not even";
    }

    public static Boolean endsLy(String str) {
        return str.endsWith("ly");

    }

    public static String seeColor(String str){
        if(str.startsWith("red")){
            return "red";
        }
        else if(str.startsWith("blue")){
            return "blue";
        }
        else return "";
    }
    public static Boolean commonEnd(int[] arr1, int[] arr2){
        int arr1len= arr1.length;
        int arr2len = arr2.length;
        if((arr1[0]==arr2[0]) || (arr1[arr1len-1]==arr2[arr2len-1])){
            return true;
        }else return false;
    }

    public static int start1(int[] arr1, int[] arr2) {
        int count = 0;

        if (arr1.length > 0 && arr1[0] == 1) {
            count++;
        }
        if (arr2.length > 0 && arr2[0] == 1) {
            count++;
        }

        return count;
    }

    public static int  Addition(int num1, int num2){
        int sum = num1+num2;
        return sum;
    }

}
