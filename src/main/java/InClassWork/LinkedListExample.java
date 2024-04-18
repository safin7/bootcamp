package InClassWork;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
     reverseArray();
    }
    public static void LinkedListExample(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println(linkedList);
    }
    public static void reverseArray(){
        int[ ] arr = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int num:arr){
            linkedList.add(num);
        }
        Collections.reverse(linkedList);

        int index =0;
        for(int num: linkedList){
            arr[index++]= num;

        }
        System.out.println();
        System.out.println("reversed array: ");
        for(int num: arr){
            System.out.println(num + " ");
        }


    }
}
