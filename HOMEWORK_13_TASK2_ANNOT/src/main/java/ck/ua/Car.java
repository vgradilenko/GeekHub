package ck.ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Component
public class Car {

    @Autowired
    private Wheel wheel;
    @Autowired
    private Wheel whee2;
    @Autowired
    private Wheel whee3;
    @Autowired
    private Wheel whee4;
    @Autowired
    private Engine engine;

    public List<Wheel> getWheels() {
        return Arrays.asList(wheel, whee2, whee3, whee4);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
