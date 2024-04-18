package org.example;

public class example3 {
    int id;

    String name;

    void  insert(int i, String s){
        id =i;
        name = s;
    }
    void display(){
        System.out.println(id +" "+ name);
    }

}
class Employee{
    public static void main(String[] args) {


        example3 e1 = new example3();
        example3 e2 = new example3();

        e1.insert(100, "java");
        e2.insert(200,"C++");

        e1.display();
        e2.display();
    }

}
