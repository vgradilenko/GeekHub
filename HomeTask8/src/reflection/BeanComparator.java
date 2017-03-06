package reflection;

import serializer.json.Ignore;

import java.awt.*;
import java.lang.reflect.Field;

public class BeanComparator {
    public static void compare(Object o1, Object o2) throws IllegalAccessException {
        for (Field field : o1.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Ignore.class)) {
                System.out.println(field.getName() + " " + field.get(o1).equals(field.get(o2)));
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Cat first = new Cat("Tom", 1, 2.12, Color.BLUE);
        Cat second = new Cat("Tim", 2, 2.12, Color.BLUE);
        compare(first, second);
    }
}
