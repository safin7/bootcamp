package hw;

import org.w3c.dom.ls.LSOutput;

public class Vehicle1 {

    public void move(){
        System.out.println("Vehicle is moving");
    }


}
class car1 extends Vehicle1{
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
}

class motorCycle1 extends Vehicle1 {
    @Override
    public void move() {
        System.out.println("MotorCycle is moving");
    }

 
}
 class asd{
     public static void main(String[] args) {
         Vehicle1 a = new Vehicle1();
         a.move();
         Vehicle1 b = new car1();
         b.move();
         Vehicle1 c = new motorCycle1();
         c.move();

     }
 }

