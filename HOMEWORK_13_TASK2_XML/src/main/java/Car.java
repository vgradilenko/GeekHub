import java.util.List;

public class Car {
    private List<Wheel> wheels;
    private Engine engine;

    public Car(List<Wheel> wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public Car() {
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
