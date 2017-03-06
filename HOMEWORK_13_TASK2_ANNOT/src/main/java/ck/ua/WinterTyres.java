package ck.ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:car.properties")
@Component
public class WinterTyres extends Tyres {

    @Autowired
    public WinterTyres(@Value("${car.winterTyres.name}") String name,
                       @Value("${car.winterTyres.size}") int size) {
        super(name, size);
    }
}
