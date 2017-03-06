package ck.ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@PropertySource("classpath:car.properties")
@Scope(value = "prototype")
@Component("wheel")
public class Wheel {

    @Autowired
    @Qualifier("summerTyres")
    private Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public Wheel() {

    }

    public Tyres getTyres() {
        return tyres;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "tyres=" + tyres +
                '}';
    }
}
