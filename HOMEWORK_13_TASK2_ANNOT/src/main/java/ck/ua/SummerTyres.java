package ck.ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@PropertySource("classpath:car.properties")
@Component
public class SummerTyres extends Tyres {

    @Autowired
    public SummerTyres(@Value("${car.summerTyres.name}") String name,
                       @Value("${car.summerTyres.size}") int size) {
        super(name, size);
    }
}
