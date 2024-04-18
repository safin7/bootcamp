package org.example;

public class EncapsulationExample2 {
    public static void main(String[] args) {
        Person person = new Person("John",21,"sdas@famfas.com");
        person.showInfo();

    }

}
class Person{
    private String name;

    private int age;
    private String Email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public void showInfo(){
        System.out.println(name+" "+age + " " + Email);

    }
}
