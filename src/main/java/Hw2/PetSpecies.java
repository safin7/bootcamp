package Hw2;

public abstract class PetSpecies implements VirtualPet {
    protected String name;
    private int hunger;
    private int happiness;
    private int energy;

    public PetSpecies(String name) {
        this.name = name;
        this.hunger = 100;
        this.happiness = 100;
        this.energy = 100;
    }

    @Override
    public void feed() {
        setHunger(hunger-10);
       setHappiness(happiness+10);
    }

    @Override
    public void play() {
       setHappiness(happiness+10);
       setEnergy(energy-10);
    }

    @Override
    public void sleep() {
        setEnergy(energy+10);
        setHappiness(happiness+10);
    }


    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public String getStatus() {
        return "Name: " + name + ", Hunger = " + hunger + ", Happiness = " + happiness + ", Energy= " + energy;
    }
}
