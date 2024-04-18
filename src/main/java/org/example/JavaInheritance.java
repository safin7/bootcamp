package org.example;

public class JavaInheritance {
    String brand;
    public JavaInheritance(String brand){
        this.brand=brand;
    }
}
class Car extends JavaInheritance{
    private int numOfWheels;

    public Car(String brand, int numOfWheels) {
        super(brand);
        this.numOfWheels = numOfWheels;
    }
    public void drive(){
        System.out.println("Driving with"+ numOfWheels+ " wheels");
    }

}
class motorcycle extends JavaInheritance{
    private boolean hasSideCar;

    public motorcycle(String brand, boolean hasSideCar) {
        super(brand);
        this.hasSideCar = hasSideCar;
    }

    public void wheelie(){
        if(hasSideCar){
            System.out.println("cannot do wheelie with sideCar");
        }else{
            System.out.println("Performing Wheelie");
        }
    }
}
class JavaIn{
    public static void main(String[] args) {
        Car car = new Car("BMW",4);
        motorcycle motor = new motorcycle("BMX",false);

        car.drive();
        
    }
}
