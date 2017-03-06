package reflection;

import serializer.json.Ignore;

import java.awt.*;
import java.lang.reflect.Field;

public class BeanRepresenter {
    public static String represent(Object o) throws IllegalAccessException {
        String info = "";

        for (Field field : o.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Ignore.class)) {
                field.setAccessible(true);
                info += "field=" + field.getName() + " value=" + field.get(o) + "\n";
            }
        }

        return info;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Cat boris = new Cat("BorisBritva", 1, 2.14, Color.black);
        System.out.println(represent(boris));
    }
}
