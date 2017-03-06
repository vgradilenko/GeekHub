package ua.ck.geekhub.hw2.figures;

/**
 * Created by grava on 28.10.2016.
 */
public class Square extends Shape {

    private double edgeA;

    public Square(double edgeA) {
        this.edgeA = edgeA;
    }

    public Square() {
        this.edgeA = -1;
    }

    public double getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(double edgeA) {
        this.edgeA = edgeA;
    }

    public double calculateArea() {
        return this.edgeA * this.edgeA;
    }

    public double calculatePerimeter() {
        return 4 * this.edgeA;
    }

    public String toString() {
        return "Square{" +
                "edgeA=" + edgeA +
                '}';
    }
}
