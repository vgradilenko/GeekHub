package ck.ua;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:car.properties")
@Component
public class Engine {

    @Value(value = "${car.engine}")
    private int engineСapacity;

    public int getEngineСapacity() {
        return engineСapacity;
    }

    public void setEngineСapacity(int engineСapacity) {
        this.engineСapacity = engineСapacity;
    }
}
