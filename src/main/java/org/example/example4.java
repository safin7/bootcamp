package org.example;

public class example4 {
    int id;

    String name;

    example4(int i , String s){
        id =i;
        name = s;
    }
    void display(){
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        example4 obj1 = new example4(10,"john");
        obj1.display();
    }

}


