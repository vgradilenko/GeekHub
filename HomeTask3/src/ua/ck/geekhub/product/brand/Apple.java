package ua.ck.geekhub.product.brand;

/**
 * Created by grava on 04.11.2016.
 */
public class Apple implements Brand {

    private final String name = "Apple";

    public String getBrandName() {
        return name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        return name != null ? name.equals(apple.name) : apple.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
