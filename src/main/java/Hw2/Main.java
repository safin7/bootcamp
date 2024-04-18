package Hw2;

public class Main {
    public static void main(String[] args) {
        PetShelter shelter = new PetShelter(5);

        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Tommy");
        Bird bird = new Bird("Tweety");

        shelter.addPet(dog);
        shelter.addPet(cat);
        shelter.addPet(bird);

        dog.play();
        cat.sleep();
        bird.feed();

        shelter.showPets();
    }
}
