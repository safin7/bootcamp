package org.example;

public class Abstraction {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Area of a circle: " + circle.area());
        System.out.println("Perimeter of circle: " + circle.perimeter());

        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("Area of a rectangle: " + rectangle.area());
        System.out.println("Perimeter of rectangle: " + rectangle.perimeter());
    }
}

abstract class Shapes {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shapes {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shapes {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}


