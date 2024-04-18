package org.example;

public class abstraction2 {
    public static void main(String[] args) {
        Warrior knight = new Knight("Lancer Loft");
        Warrior archer = new Archer("Robin Hood");
        Warrior wizard = new Wizard("Wizard Gandalf");

        knight.attack();
        archer.attack();
        wizard.attack();

        archer.defend();
        wizard.defend();
        knight.defend();

        knight.takeDamage(10);
        archer.takeDamage(20);
        wizard.takeDamage(30);
    }
}
