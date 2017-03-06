import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car = context.getBean(Car.class);
        Tyres tyres = context.getBean(SummerTyres.class);
        System.out.println(car.getWheels());
        System.out.println(car.getEngine());
        System.out.println("____________");
        System.out.println(tyres.getName());
        System.out.println(tyres.getSize());


    }
}
