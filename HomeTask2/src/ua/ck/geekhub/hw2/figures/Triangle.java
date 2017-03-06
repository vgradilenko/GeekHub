package ua.ck.geekhub.hw2.figures;

/**
 * Created by grava on 28.10.2016.
 */
public class Triangle extends Rectangle  {

    private double edgeC;

    public Triangle(double edgeA, double edgeB, double edgeC) {
        super(edgeA, edgeB);
        this.edgeC = edgeC;
    }

    public Triangle() {
        super(-1, -1);
        this.edgeC = -1;
    }

    public double calculatePerimeter() {
        return this.getEdgeA() + this.getEdgeB() + this.edgeC;
    }

    public double calculateArea(){
        double semiperimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - this.getEdgeA()) *
                (semiperimeter - this.getEdgeB()) * (semiperimeter - this.edgeC));
    }

    public String toString() {
        return "Triangle{" +
                "edgeA=" + this.getEdgeA() +
                ", edgeB=" + this.getEdgeB() +
                ", edgeC=" + this.edgeC +
                '}';
    }
}
