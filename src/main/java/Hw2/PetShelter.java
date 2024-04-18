package Hw2;

public class PetShelter {
    private PetSpecies[] pets;
    private int capacity;
    private int size;

    public PetShelter(int capacity) {
        this.capacity = capacity;
        this.pets = new PetSpecies[capacity];
        this.size = 0;
    }

    public boolean addPet(PetSpecies pet) {
        if (size < capacity) {
            pets[size] = pet;
            size++;
            return true;
        } else {
            System.out.println("Shelter is full. Cannot add more pets.");
            return false;
        }
    }

//remove method
    public void showPets() {
        if (size == 0) {
            System.out.println("No pets in the shelter.");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (pets[i] != null) {
                System.out.println(pets[i].getStatus());
            }
        }
    }
}
