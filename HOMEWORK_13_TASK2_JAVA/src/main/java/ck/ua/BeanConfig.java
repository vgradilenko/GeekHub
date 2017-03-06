package ck.ua;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@PropertySource("classpath:car.properties")
@Configuration
public class BeanConfig {
    @Bean
    Engine engine() {
        return new Engine(250);
    }

    @Bean
    Tyres wintTyres() {
        return new WinterTyres("car.winterTyres.name", 12);
    }

    @Bean
    Tyres summTyres() {
        return new SummerTyres("car.winterTyres.name", 10);
    }

    @Bean
    Wheel wheel() {
        return new Wheel(summTyres());
    }

    @Bean
    Car car() {
        return new Car(Arrays.asList(
                wheel(), wheel(), wheel(), wheel()
        ), engine());
    }
}
