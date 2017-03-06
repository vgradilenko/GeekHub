package reflection;

import java.awt.*;
import java.lang.reflect.Field;

public class CloneCreator {
    public static Object createClon(Object object) throws IllegalAccessException, InstantiationException {
        Object clone = object.getClass().newInstance();

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field.set(clone, field.get(object));
        }

        return clone;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Cat original = new Cat();
        original.setAge(2);
        original.setColor(Color.black);
        original.setName("Bars");
        original.setWeight(3.10);

        Cat clon = (Cat) createClon(original);

        System.out.println(BeanRepresenter.represent(clon));
    }
}
