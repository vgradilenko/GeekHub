package ua.ck.geekhub.hw2;

import ua.ck.geekhub.hw2.figures.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by grava on 29.10.2016.
 */
public class MainClass {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Shape shape;
        System.out.println("Enter type figure");
        String figure = (reader.readLine()).toUpperCase();
        ShapeType types = ShapeType.valueOf(figure);

        switch (types){
            case CIRCLE:
                System.out.println("enter radius:");
                shape = new Circle(Integer.parseInt(reader.readLine()));
                System.out.println(shape.calculatePerimeter());
                System.out.println(shape.calculateArea());
                break;
            case RECTANGLE:
                System.out.println("Enter edgeA & edgeB");
                int edgeA = Integer.parseInt(reader.readLine());
                int edgeB = Integer.parseInt(reader.readLine());
                shape = new Rectangle(edgeA, edgeB);
                System.out.println(shape.calculatePerimeter());
                System.out.println(shape.calculateArea());
                break;
            case SQUARE:
                System.out.println("Enter edgeA");
                shape = new Square(Integer.parseInt(reader.readLine()));
                System.out.println(shape.calculatePerimeter());
                System.out.println(shape.calculateArea());
                break;
            case TRIANGLE:
                System.out.println("Enter edgeA & edgeA & edgeC");
                int edgeX = Integer.parseInt(reader.readLine());
                int edgeY = Integer.parseInt(reader.readLine());
                int edgeZ = Integer.parseInt(reader.readLine());
                shape = new Triangle(edgeX, edgeY, edgeZ);
                System.out.println(shape.calculatePerimeter());
                System.out.println(shape.calculateArea());
                break;
            default:
                System.out.println("the figure does not exist");
        }
        reader.close();
    }





}
