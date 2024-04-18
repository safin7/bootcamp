package org.example;

// Warrior class from previous code
abstract class Warrior {
    private String name;
    private int health;

    public Warrior(String name, int health) {
        this.name = name;
        this.health = health;
    }

    abstract void attack();
    abstract void defend();

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " - " + damage);
        if (this.health <= 0) {
            System.out.println(name + " is dead");
        }
    }

    // Getter for the name, assuming you might need it in subclasses
    public String getName() {
        return name;
    }

    // Getter for health if needed
    public int getHealth() {
        return health;
    }
}

// Archer class
class Archer extends Warrior {

    public Archer(String name) {
        super(name, 80);
    }

    @Override
    void attack() {
        System.out.println("Archer " + getName() + " attacks");
    }

    @Override
    void defend() {
        System.out.println("Archer " + getName() + " defends");
    }
}

// Wizard class
class Wizard extends Warrior {

    public Wizard(String name) {
        super(name, 60);
    }

    @Override
    void attack() {
        System.out.println("Wizard " + getName() + " attacks!");
    }

    @Override
    void defend() {
        System.out.println("Wizard " + getName() + " defends");
    }
}

// Knight class
class Knight extends Warrior {

    public Knight(String name) {
        super(name, 100); // Assuming a knight has 100 health
    }

    @Override
    void attack() {
        System.out.println("Knight " + getName() + " attacks with a sword");
    }

    @Override
    void defend() {
        System.out.println("Knight " + getName() + " defends with a shield");
    }
}
