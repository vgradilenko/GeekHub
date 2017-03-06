package ua.ck.geekhub.hw2.figures;

/**
 * Created by grava on 28.10.2016.
 */
public class Rectangle extends Square {

    private double edgeB;

    public Rectangle(double edgeA, double edgeB) {
        super(edgeA);
        this.edgeB = edgeB;
    }

    public Rectangle() {
        super(-1);
        this.edgeB = -1;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(double edgeB) {
        this.edgeB = edgeB;
    }

    public double calculateArea() {
        return this.getEdgeA() * this.edgeB;
    }

    public double calculatePerimeter() {
        return 2*(this.getEdgeA() + this.edgeB);
    }

    public String toString() {
        return "Rectangle{ edgeA= " + this.getEdgeA() + "edgeB=" + edgeB + '}';
    }
}
