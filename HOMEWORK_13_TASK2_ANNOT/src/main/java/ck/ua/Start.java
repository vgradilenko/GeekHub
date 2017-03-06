package ck.ua;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ck");

        Engine engine = context.getBean(Engine.class);
        WinterTyres winterTyres = context.getBean(WinterTyres.class);
        SummerTyres summerTyres = context.getBean(SummerTyres.class);
        Wheel wheel = context.getBean(Wheel.class);
        
        Car car = context.getBean(Car.class);
        System.out.println("engine: " + engine.getEngineСapacity());
        System.out.println("_________");
        System.out.println("winter " + winterTyres.getName());
        System.out.println("winter " + winterTyres.getSize());
        System.out.println("_________");
        System.out.println("summer " + summerTyres.getName());
        System.out.println("summer " + summerTyres.getSize());
        System.out.println("_________");
        System.out.println("wheel " + wheel.getTyres());
        System.out.println("_________");
        System.out.println("car " + car.getWheels());
        System.out.println("car " + car.getEngine());

    }
}
