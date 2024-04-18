package Hw2;

public class Dog extends PetSpecies {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        super.play();
        System.out.println(name + " fetching the ball");
    }
}

 class Cat extends PetSpecies {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println(name + " finds a spot for a nap.");
    }
}

 class Bird extends PetSpecies {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void feed() {
        super.feed();
        System.out.println(name + " eating seeds.");
    }
}
