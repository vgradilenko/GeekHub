package ua.ck.geekhub.hw2.figures;

/**
 * Created by grava on 28.10.2016.
 */
public class Circle extends Shape {

    private double radius;

    public Circle() {
        this.radius = -1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * (radius * radius);
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
